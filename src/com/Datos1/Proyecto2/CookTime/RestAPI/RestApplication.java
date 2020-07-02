package com.Datos1.Proyecto2.CookTime.RestAPI;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest/")
public class RestApplication extends Application{
	
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classList = new HashSet<>();
		classList.add(UsersResources.class);
		return classList;
	}
}
