package ss_6.thuc_hanh.demo2;

// Ép kiểu - kiểu đối
public class Zoo {
    public static void main(String[] args) {

        Cat cat = new Cat("cat");
        Dog dog = new Dog("dog");
        Animal animal = cat;
        Animal animal1 = new Dog("animal");
        dog = (Dog) animal1;



    }
}
