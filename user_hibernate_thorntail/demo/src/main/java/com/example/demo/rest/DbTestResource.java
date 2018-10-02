package com.example.demo.rest;

import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/hello")
@RequestScoped
public class DbTestResource {
    @GET
    @Produces("text/plain")
    public String doGet() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jboss/datasources/MY_SQL");
        Connection conn = ds.getConnection();
        try {
            return "Howdy using driver: " + conn.getMetaData().getDriverName();
        } finally {
            conn.close();
        }
    }
}
