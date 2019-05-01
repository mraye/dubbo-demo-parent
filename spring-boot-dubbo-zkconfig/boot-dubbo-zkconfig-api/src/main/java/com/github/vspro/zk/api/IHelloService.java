package com.github.vspro.zk.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("hello")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface IHelloService {


    @GET
    @Path("sayHi")
    public String sayHi(@QueryParam("to") String to);

    @GET
    @Path("getWxConfig")
    public String getWxConfig();



}
