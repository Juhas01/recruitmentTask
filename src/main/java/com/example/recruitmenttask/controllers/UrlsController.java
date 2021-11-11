package com.example.recruitmenttask.controllers;

import com.example.recruitmenttask.models.UrlDataSimple;
import com.example.recruitmenttask.services.IUrlsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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
    public Response addUrl(UrlDataSimple urlToAdd){
        return Response.ok(urlsService.addUrl(urlToAdd)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUrlById(@PathParam("id") Long urlId){
        return Response.ok(urlsService.getUrlById(urlId)).build();
    }

    @POST
    @Path("/list")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addListOfUrls(List<UrlDataSimple> urlsToAdd){
        return Response.ok(urlsService.addListOfUrls(urlsToAdd)).build();
    }

    @GET
    @Path("/downloading")
    @Produces("application/json")
    public Response getDownloadingQueue(){
        return Response.ok(urlsService.getDownloadingQueue()).build();
    }
}
