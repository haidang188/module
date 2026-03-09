package ss_5.thuc_hanh.bai1;

public class Main {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111, "Ha");
        Student s2 = new Student(222, "Hai");
        Student s3 = new Student(333, "Dang");

        s1.display();
        s2.display();
        s3.display();
    }
}
