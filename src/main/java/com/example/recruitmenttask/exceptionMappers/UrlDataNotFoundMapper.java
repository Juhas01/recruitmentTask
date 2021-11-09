package com.example.recruitmenttask.exceptionMappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UrlDataNotFoundMapper implements ExceptionMapper<com.example.recruitmenttask.exceptionMappers.URlDataNotFoundException> {
    @Override
    public Response toResponse(com.example.recruitmenttask.exceptionMappers.URlDataNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).type("text/plain").entity(exception.getMessage()).build();
    }
}
