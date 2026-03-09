package project_2.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private double salary;

    public Teacher(int id, String name, String email, LocalDate birthday, double salary) {
        super(id, name, email, birthday);
        this.salary = salary;
    }
    public Teacher(String name, String email, LocalDate birthday, double salary) {
        super(name, email, birthday);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                '}' + super.toString();
    }
}
