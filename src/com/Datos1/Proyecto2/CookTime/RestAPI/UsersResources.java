package com.Datos1.Proyecto2.CookTime.RestAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
	static {
		User user = User.builder().withEmail("luismorarod98@gmail.com").withName("Luis Pedro").withAge(21).withPassword("password").build();
		BT.insert(user);
	}
	
	@GET
	public Response getUsers(){
		return  Response.ok(BT).build();
	}
	
	@POST
	@SuppressWarnings("rawtypes")
	public Response addUsers(@Context UriInfo uriInfo)  {
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
		newUser= User.builder().withEmail(email).withName(name).withAge(age).withPassword(password).build();
		BT.insert(newUser);
		return Response.ok(BT).build();
	}
	
}