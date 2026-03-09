package project_3.repository.car_repository;

import project_3.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private static List<Car> cars;
    static {
        cars = new ArrayList<Car>();
        cars.add(new Car("38A-12345", "Toyota",
                2025, "Nguyen Van A", 5, "touríst"));
        cars.add(new Car("38A-23456", "Honda",
                2025, "Nguyen Van B", 5, "tourist"));
        cars.add(new Car("38A-34567", "Kia",
                2025, "Nguyen Van C", 5, "tourist"));
        cars.add(new Car("38B-45678", "Hyundai",
                2025, "Nguyen Van D", 5, "bus"));
        cars.add(new Car("38B-12345", "Thaco",
                2025, "Nguyen Van E", 5, "bus"));
        cars.add(new Car("38B-12345", "Hyundai",
                2025, "Nguyen Van H", 5, "bus"));
    }

    @Override
    public void saveCar(Car car) {
    cars.add(car);
    }

    @Override
    public void removeCar(Car car) {
    for (int i = 0; i < cars.size(); i++) {
        Car car1 = cars.get(i);
        if (car1 != null) {
            cars.remove(i);
            break;
        }

    }
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }
}
