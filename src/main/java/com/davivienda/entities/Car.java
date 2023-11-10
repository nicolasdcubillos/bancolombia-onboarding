package com.davivienda.entities;

import jakarta.persistence.*;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(name = "car")
@NamedQuery(name = "Car.findAll",
        query = "SELECT c FROM Car c")
public class Car {
    @Id
    @Column(name="id")
    @SequenceGenerator(
            name = "carSequence",
            sequenceName = "car_SEQ",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carSequence")
    public Integer id;

    @Column(name="model")
    public String model;

    @Column(name="plate")
    public String plate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
