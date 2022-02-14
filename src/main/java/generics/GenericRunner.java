package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericRunner {
    public static void main(String[] args) {
        List<? super Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        animalList.add(new Cat());
        animalList.add(new Tiger());
        for (int i = 0; i < animalList.size(); i++) {
            Animal object = (Animal) animalList.get(i);
            object.sound();
        }

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        List<Tiger> tigers = new ArrayList<>();
        tigers.add(new Tiger());
        tigers.add(new Tiger());
        List<Animal> ans = new ArrayList<>();
        ans.add(new Animal());
        ans.add(new Animal());
        List<? extends Cat> animals = tigers;
        for (int i = 0; i < animals.size(); i++) {
            Cat cat = animals.get(i);
            cat.sound();
        }
    }
}
