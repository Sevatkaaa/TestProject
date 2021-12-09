package labs.intelsys;

import javafx.util.Pair;

import java.util.List;

public class PackmanRunner {
    public static void main(String[] args) {
        System.out.println("Enter table: o - food to eat, x - wall, O - finish, e - packman, after that print stop to stop");
        PackmanWorld packmanWorld = new PackmanWorld();
        packmanWorld.readData();
//        packmanWorld.printData();
        List<Pair<Integer, Integer>> path = packmanWorld.bfsShortestPath();
//        List<Pair<Integer, Integer>> path = packmanWorld.dfsShortestPath();
        if (path != null) {
            System.out.println("Totally made " + (path.size() - 1) + " steps");
            System.out.print("Start -> ");
            path.forEach(p -> System.out.print("(" + p.getKey() + ", " + p.getValue() + ") -> "));
            System.out.println("End!");
        } else {
            System.out.println("Can't find path :(");
        }
        packmanWorld.printSteps(path);
    }
}
