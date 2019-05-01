package com.github.vspro.rest.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface IHelloService {


    @GET
    @Path("sayHi")
    public String sayHi(@QueryParam("to") String to);

}
