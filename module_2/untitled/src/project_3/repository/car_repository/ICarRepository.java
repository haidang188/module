package project_3.repository.car_repository;

import project_3.model.Car;

import java.util.List;

public interface ICarRepository {
    void saveCar(Car car);
    void removeCar(Car car);
    List<Car> findAll();
}
