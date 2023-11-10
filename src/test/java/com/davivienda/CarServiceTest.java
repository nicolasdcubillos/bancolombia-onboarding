package com.davivienda;

import com.davivienda.entities.Car;
import com.davivienda.service.CarService;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.common.constraint.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@QuarkusTest
public class CarServiceTest {

    static CarService carService;
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Inicialización de variables.");
        carService = new CarService();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Liberación de recursos.");
    }

    @Before
    public void setUp() {
        System.out.println("Antes de cada test.");
    }

    @After
    public void tearDown() {
        System.out.println("Después de cada test.");
    }


    @Test
    public void testValidatePlate() {
        System.out.println("En el test.");
        Car car = new Car();
        car.setPlate("DUS791");
        Assert.assertTrue(carService.validatePlate(car));
        car.setPlate("DUS7911");
        Assert.assertFalse(carService.validatePlate(car));
    }
}
