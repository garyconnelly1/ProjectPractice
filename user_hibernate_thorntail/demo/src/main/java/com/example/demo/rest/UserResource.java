package com.example.demo.rest;


import com.example.demo.model.User;
import com.example.demo.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;


@Path("/users")
@RequestScoped
public class UserResource {

	@PersistenceContext(unitName = "MyPU")
	EntityManager em;

	@Inject
	UserService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(service.findAll()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int userId) {
		User user = service.findById(userId);
		if(user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(user).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response persistUser(User user) {
		return Response.ok(service.save(user)).build();
		//System.out.println("inside post");
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, User user) {
		if(service.update(user) != null)
			return Response.ok(user).build();
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		if(service.delete(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
