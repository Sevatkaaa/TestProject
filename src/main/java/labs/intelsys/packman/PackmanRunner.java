package labs.intelsys.packman;

import javafx.util.Pair;

import java.util.List;

public class PackmanRunner {
    public static void main(String[] args) {
        System.out.println("Enter table: o - food to eat, x - wall, O - finish, e - packman, after that print stop to stop");
        PackmanWorld packmanWorld = new PackmanWorld();
        packmanWorld.readData();
        PackmanWorld packmanWorld2 = new PackmanWorld(packmanWorld);
//        packmanWorld.printData();
        try {
            while (true) {
                while (packmanWorld.isGame()) {
                    List<Pair<Integer, Integer>> path = packmanWorld.aStarShortestPath();
                    if (path != null) {
//                        System.out.println("Totally made " + (path.size() - 1) + " steps");
//                        System.out.print("Start -> ");
                        path.forEach(p -> System.out.print("(" + p.getKey() + ", " + p.getValue() + ") -> "));
//                        System.out.println("End!");
                    } else {
//                        System.out.println("Can't find path :(");
                    }
                    packmanWorld.printSteps(path);
                }
                packmanWorld2.addGhost();
                packmanWorld = new PackmanWorld(packmanWorld2);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
