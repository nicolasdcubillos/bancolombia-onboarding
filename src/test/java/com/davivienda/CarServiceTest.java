package com.davivienda;

import com.davivienda.entities.Car;
import com.davivienda.service.CarService;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.common.constraint.Assert;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CarServiceTest {
    @Test
    public void testValidatePlate() {
        CarService carService = new CarService();
        Car car = new Car();
        car.setPlate("DUS791");
        Assert.assertTrue(carService.validatePlate(car));
        car.setPlate("DUS7911");
        Assert.assertFalse(carService.validatePlate(car));
    }
}
