package com.outsera;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movies")
public class MoviesResource {

    @Inject
    MoviesService moviesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIntervalMovies() {
        try {
            return Response.ok(moviesService.getIntervalMovies()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }
}
