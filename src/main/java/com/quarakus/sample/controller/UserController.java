package com.quarakus.sample.controller;

import com.quarakus.sample.configuration.Cookie;
import com.quarakus.sample.dto.UserDTO;
import com.quarakus.sample.model.User;
import com.quarakus.sample.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @Inject
    Cookie cookie;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User get(@PathParam("id") Long id) {
        System.out.println(cookie.getDomain());
        return userService.find(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User save(UserDTO userDTO) {
        return userService.save(userDTO.toUser());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public CompletionStage<List<User>> greeting(@PathParam("name") String name) {
        return CompletableFuture.supplyAsync(() -> userService.find());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
    }
}