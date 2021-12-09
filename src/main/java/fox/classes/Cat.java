package fox.classes;

public class Cat extends Animal {

    static final int maxCount = 10;
    static int currentCount = 0;

    public Cat() {
        super();
        currentCount++;
    }

    public Cat(String name, int age) {
        super(name, age);
        currentCount++;
    }

    public Cat(String name, int age, Human owner) {
        super(name, age, owner);
        currentCount++;
    }

    @Override
    public void sound() {
        System.out.println("Mya-mya, I am a cat!");
    }

    public void printCat() {
        System.out.println("Кот - " + getName() + ", возраст - " + getAge());
    }

    static void printCatCount() {
        System.out.println("Сейчас котов всего " + currentCount);
    }

}
