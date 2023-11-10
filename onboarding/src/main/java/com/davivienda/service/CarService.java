package com.davivienda.service;

import com.davivienda.entities.Car;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

@Transactional
@ApplicationScoped
public class CarService {
    @Inject
    EntityManager em;

    public List<Car> findAll() {
        return em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }

    public Car findById(Integer id) throws Exception {
        Car car = em.find(Car.class, id);
        if (car == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist!", 404);
        }
        return car;
    }

    public void create(Car newCar) {
        em.persist(newCar);
    }

    public Car update(Car carUpdated) {
        Car car = em.find(Car.class, carUpdated.getId());
        if (car == null) {
            throw new WebApplicationException("Car with id " + carUpdated.getId() + " does not exist!", 404);
        }
        car.setModel(carUpdated.getModel());
        car.setPlate(carUpdated.getPlate());
        return car;
    }

    @Transactional
    public Integer delete(Integer id) {
        Car car = em.getReference(Car.class, id);
        if (car == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist!", 404);
        }
        em.remove(car);
        return id;
    }
}
