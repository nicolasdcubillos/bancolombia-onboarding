package com.davivienda.resource;

import com.davivienda.entities.Car;
import com.davivienda.service.CarService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/car")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {
    @Inject
    CarService carService;
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response
                .ok(carService.findAll())
                .build();
    }

    @POST
    @Transactional
    public Response create(Car car) {
        if (car.getModel() == null || car.getPlate() == null) {
            throw new WebApplicationException("Model or plate not present in the request body.", 422);
        }
        carService.create(car);
        return Response.ok(car).status(201).build();
    }

    @PUT
    @Transactional
    public Car update(Car car) {
        if (car.getModel() == null || car.getPlate() == null) {
            throw new WebApplicationException("Model or plate not present in the request body.", 422);
        }
        return carService.update(car);
    }

    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") Integer id) {
        carService.delete(id);
        return Response.status(204).build();
    }
}
