package com.example.makswork_autocenter.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @Column(name = "id_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCar;

    @Column(name = "model_car")
    String model;

    @Column(name = "color_car")
    String color;

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users")
    User user;

    public Car() {
    }

    public Car(String model, String color, User user) {
        this.model = model;
        this.color = color;
        this.user = user;
    }
}
