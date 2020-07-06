package com.Datos1.Proyecto2.CookTime.RestAPI;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface RestResources {
	
	public Response get(@PathParam("userEmail") String getRequest);
	public Response getAll();
	public Response register(@Context UriInfo uriInfo);

}
