package com.Datos1.Proyecto2.CookTime.RestAPI;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.Datos1.Proyecto2.CookTime.JSONFiles.UsersJSON;


@ApplicationPath("rest/")
public class RestApplication extends Application{
	private static UsersJSON usersJson;
	
	

	public RestApplication() {
		usersJson = UsersJSON.getInstance();
		//usersJson.parseUsers(); //loads JSON file users to the Binary Tree
	}
	
	public static UsersJSON getUsersJson() {
		return usersJson;
	}

	public static void setUsersJson(UsersJSON usersJson) {
		RestApplication.usersJson = usersJson;
	}
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classList = new HashSet<>();
		classList.add(UsersResources.class);
		return classList;
	}
	
}
