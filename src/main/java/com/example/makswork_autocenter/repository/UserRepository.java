package com.example.makswork_autocenter.repository;

import com.example.makswork_autocenter.entity.Car;
import com.example.makswork_autocenter.entity.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void addCar(Car car, int id);
    void addPriceAutoParts(int priceAutoParts, int idUser);
    void addPriceRepair(int price, int idUser);
    void deletePriceAutoParts(int idUser);
    void deletePriceRepair(int idUser);
    void deleteCar(int idUser);
    List<User> getUserList();
}
