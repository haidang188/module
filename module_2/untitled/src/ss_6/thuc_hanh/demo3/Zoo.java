package ss_6.thuc_hanh.demo3;

// Ép kiểu
public class Zoo {
    public static void main(String[] args) {

        Cat cat = new Cat("cat");
        Dog dog = new Dog("dog");
        Animal[] animals = {cat, dog};
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                ((Dog) animal).DogDoSth();
            } else {
                ((Cat) animal).CatDoSth();
            }
        }


    }
}
