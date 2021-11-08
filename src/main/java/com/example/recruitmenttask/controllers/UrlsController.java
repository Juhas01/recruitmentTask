package com.example.recruitmenttask.controllers;

import com.example.recruitmenttask.Services.UrlsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/url")
public class UrlsController {

    private UrlsService urlsService;

    public UrlsController() {
    }

    @Inject
    public UrlsController(UrlsService urlsService) {
        this.urlsService = urlsService;
    }

    @GET
    @Produces("application/json")
    public Response getAllUrls(){
        return Response.ok(urlsService.getAllUrlsSimple()).build();
    }

}
