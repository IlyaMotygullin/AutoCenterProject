package com.example.makswork_autocenter.repository;

import com.example.makswork_autocenter.entity.Car;
import com.example.makswork_autocenter.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value = "userRepository")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRepositoryImpl implements UserRepository {
    Configuration configuration = new Configuration()
            .addAnnotatedClass(Car.class)
            .addAnnotatedClass(User.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    /**
     * создание пользователя
     * @param user
     */
    @Override
    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        user.setPriceRepair(0);
        user.setPriceAutoParts(0);
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * добавление машины пользователю
     * @param car
     * @param idUsers
     */
    @Override
    public void addCar(Car car, int idUsers) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUsers);
        car.setUser(user);
        user.getCarList().add(car);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * добавляет стоимость выбранных запчастей
     * @param priceAutoParts
     * @param idUser
     */
    @Override
    public void addPriceAutoParts(int priceAutoParts, int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUser);
        Integer priceAutoParts1 = user.getPriceAutoParts();
        user.setPriceAutoParts(priceAutoParts + priceAutoParts1);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * добавляет стоимость выбранных элементов
     * @param price
     * @param idUser
     */
    @Override
    public void addPriceRepair(int price, int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUser);
        Integer priceRepair = user.getPriceRepair();
        user.setPriceRepair(price + priceRepair);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * удаляет стоимоть выбранных запчастей
     * @param idUser
     */
    @Override
    public void deletePriceAutoParts(int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUser);
        user.setPriceAutoParts(0);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * удаляет стоимость выбранных элементов
     * @param idUser
     */
    @Override
    public void deletePriceRepair(int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUser);
        user.setPriceRepair(0);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * идет удаление машин у пользователя
     * @param idUser
     */
    @Override
    public void deleteCar(int idUser) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        User user = session.get(User.class, idUser);
        List<Car> carList = user.getCarList();
        Car car = carList.get(0);
        carList.remove(car);
        user.getCarList().clear();
        session.merge(car);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * получение всех пользователей
     * @return
     */
    @Override
    public List<User> getUserList() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> userList = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        return userList;
    }
}
