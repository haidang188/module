package ss_4.demo;
/*
 * Ten: String
 * Email: String
 * idC: String
 * phoneNumber: String
 *
 * alt + insert: tao construtor nhanh */

public class Student {
    private String name;
    private String email;
    private String idC;
    private String phoneNumber;
    public static String academy = "CG";

    public Student() {
    }

    public Student(String name, String email) {

    }

    public Student(String name, String email, String idC, String phoneNumber) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void learn(String sub) {
        System.out.println("Dang hoc mon " + sub);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", idC='" + idC + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
