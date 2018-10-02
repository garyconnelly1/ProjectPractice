package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.model.Worker;
//import com.example.demo.service.UserService;
import com.example.demo.service.WorkerService;

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


@Path("/workers")
@RequestScoped
public class WorkerResource {
	
	@PersistenceContext(unitName = "MyPU")
	EntityManager em;
	
	@Inject
	WorkerService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkers() {
		return Response.ok(service.findAll()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int workerId) {
		Worker worker = service.findById(workerId);
		if(worker == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(worker).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response persistUser(Worker worker) {
		return Response.ok(service.save(worker)).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, Worker worker) {
		if(service.update(worker) != null)
			return Response.ok(worker).build();
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
