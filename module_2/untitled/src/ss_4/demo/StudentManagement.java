package ss_4.demo;

public class StudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1.academy);
        System.out.println(s2.academy);
        Student.academy = "CA";
        System.out.println(s1.academy);
        System.out.println(s2.academy);
    }
}
