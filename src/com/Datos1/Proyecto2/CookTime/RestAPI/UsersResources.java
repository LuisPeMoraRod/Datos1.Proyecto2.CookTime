

package com.Datos1.Proyecto2.CookTime.RestAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.Datos1.Proyecto2.CookTime.UsersManagement.User;
import com.Datos1.Proyecto2.CookTime.Trees.BinaryTree;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResources {
	
	
	private static BinaryTree<User> BT = BinaryTree.getInstance();
	private ArrayList<User> responseList;
	private User responseUser;
	
	
	@GET
	@Path("/{userEmail}")
	public Response getUser(@PathParam("userEmail") String userEmail){
		responseUser = BT.getUserByEmail(userEmail);
		if (responseUser != null) {
			return  Response.ok(responseUser).build();
		}else {
			return Response.status(Status.NOT_FOUND).entity("User not found for: "+userEmail).build();
		}
		
	}
	
	/**
	 * Returns all the registered users (sorted by alphabetical order) as a response to the client
	 */
	@GET
	public Response getAllUsers()
	{
		responseList = BT.getList();
		return  Response.ok(responseList).build();
	}
	/**
	 * Registers a new user: authenticates and adds user to the binary tree
	 * @param uriInfo : UriInfo
	 * @return newUser : Response
	 */
	@POST
	@SuppressWarnings("rawtypes")
	public Response registerUser(@Context UriInfo uriInfo)  {
		String key;
		String email = null ,name  = null,password  = null;
		int age=0;
		User newUser;
		for( Map.Entry entry: uriInfo.getQueryParameters().entrySet() ) {
			key = entry.getKey().toString();
			StringTokenizer tokenizer = new StringTokenizer(entry.getValue().toString(),"[ // ]");
			switch (key) {
			case "email":
				email=tokenizer.nextToken();
				break;
			case "name":
				name = tokenizer.nextToken();
				break;
			case "age":
				age = Integer.parseInt(tokenizer.nextToken());
				break;
			case "password":
				password = tokenizer.nextToken();
				break;

			default:
				break;
			}
		}
		if (email == null || name == null || password == null) {
			return Response.status(Status.CONFLICT).entity("Email, name and mustn't be empty").build();
		}else if (BT.getUserByEmail(email)==null) {
			newUser= User.builder().withEmail(email).withName(name).withAge(age).withPassword(password).build();
			BT.insert(newUser);
			responseList = BT.getList();
			return  Response.ok(newUser).build();
		} else {
			return Response.status(Status.CONFLICT).entity("Email already in use").build();
		}
		
	}
	
}