package br.com.contato12.controller;

import java.util.UUID;

import br.com.contato12.entity.UserEntity;
import br.com.contato12.service.Service;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Controller {

    private final Service service;

    public Controller(Service service){
        this.service = service;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize){
        var users = service.findAll(page, pageSize);
        return Response.ok(users).build();
    }


    @POST
    @Transactional
    public Response create(UserEntity userEntity){
        return Response.ok(service.createUser(userEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id){
        return Response.ok(service.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") UUID id){
        service.deleteById(id);
        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") UUID id, UserEntity userEntity){
        return Response.ok(service.updateUser(id, userEntity)).build();
    }
}   
