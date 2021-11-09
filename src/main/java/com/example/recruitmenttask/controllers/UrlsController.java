package com.example.recruitmenttask.controllers;

import com.example.recruitmenttask.models.UrlsDataSimple;
import com.example.recruitmenttask.services.IUrlsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/url")
public class UrlsController {

    private IUrlsService urlsService;

    public UrlsController() {
    }

    @Inject
    public UrlsController(IUrlsService urlsService) {
        this.urlsService = urlsService;
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAllUrls(){
        return Response.ok(urlsService.getAllUrlsSimple()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addUrl(UrlsDataSimple urlToAdd){
        return Response.ok(urlsService.addUrl(urlToAdd)).build();
    }

}
