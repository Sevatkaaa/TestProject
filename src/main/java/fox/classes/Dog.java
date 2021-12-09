package fox.classes;

public class Dog extends Animal {
    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, Human owner) {
        super(name, age, owner);
    }

    @Override
    public void sound() {
        System.out.println("Gav-gav, I am dog");
    }
}
