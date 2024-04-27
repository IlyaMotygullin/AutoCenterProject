package com.example.makswork_autocenter.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @Column(name = "id_users")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUser;

    @Column(name = "name_users")
    String name;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "surname")
    String surname;

    @Column(name = "password_users")
    String password;

    @Column(name = "price_repair_auto")
    Integer priceRepair;

    @Column(name = "price_auto_parts")
    Integer priceAutoParts;

    @OneToMany(mappedBy = "user")
    List<Car> carList;

    public User() {
    }

    public User(String name, String lastname, String surname, String password, Integer priceRepair,
                Integer priceAutoParts) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.password = password;
        this.priceRepair = priceRepair;
        this.priceAutoParts = priceAutoParts;
    }

    public User(String name, String lastname, String surname, String password) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
