package labs.intelsys.packman;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PackmanWorld {

    private static final String STOP = "stop";
    private static final Runtime RUNTIME = Runtime.getRuntime();

    private List<String> world = new ArrayList<>();
    private List<Pair<Integer, Integer>> ghosts = new ArrayList<>();

    public PackmanWorld() {
    }

    public PackmanWorld(PackmanWorld w) {
        this.world = new ArrayList<>(w.world);
        this.ghosts = new ArrayList<>(w.ghosts);
    }

    public void readData() {
        System.out.println("Start reading data...");
        long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String data = reader.readLine();
            while (!STOP.equals(data)) {
                world.add(data);
                data = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Read all data, time in ms - " + (endTime - startTime));
    }

    public void printData() {
        System.out.println("Start printing data...");
        long startTime = System.currentTimeMillis();
        Pair<Integer, Integer> packman = getPackman();
        List<String> newWorld = new ArrayList<>(world);
        ghosts.forEach(g -> {
            if (g.equals(packman)) {
                newWorld.forEach(System.out::println);
                throw new IllegalArgumentException("Packman died :((((");
            }
            String s = newWorld.get(g.getKey());
            s = s.substring(0, g.getValue()) + "w" + s.substring(g.getValue() + 1);
            newWorld.remove((int)g.getKey());
            newWorld.add(g.getKey(), s);
        });
        newWorld.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("Printed all data, time in ms - " + (endTime - startTime));
    }

    public List<Pair<Integer, Integer>> aStarShortestPath() {
        long startMemory = RUNTIME.freeMemory();
//        System.out.println("Start BFS shortest path...");
        long startTime = System.currentTimeMillis();
        int n = world.size();
        int m = world.get(0).length();
        int[] visitedFrom = new int[n * m];
        boolean[] visited = new boolean[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visitedFrom[i * n + j] = -1;
            }
        }
        Pair<Integer, Integer> packman = getPackman();
        Pair<Integer, Integer> finish = getFinish();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(packman);
        int packmanValue = getCellValue(packman);
        visitedFrom[packmanValue] = packmanValue;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.poll();
            int from = getCellValue(cell);
            if (visited[from]) {
                continue;
            }
            visited[from] = true;
            if (cell.equals(finish)) {
                List<Pair<Integer, Integer>> answer = getAnswer(visitedFrom, packman, finish);
                long endTime = System.currentTimeMillis();
//                System.out.println("BFS shortest path found, time in ms - " + (endTime - startTime));
                long endMemory = RUNTIME.freeMemory();
//                System.out.println("TOTAL MEMORY USED in bytes: " + (startMemory - endMemory));
                return answer;
            }
            List<Pair<Integer, Integer>> neighbours = getNeighbours(cell);
            neighbours.stream().forEach(nb -> {
                int nbValue = getCellValue(nb);
                if (visitedFrom[nbValue] == -1) {
                    visitedFrom[nbValue] = from;
                }
                if (!visited[nbValue]) {
                    queue.add(nb);
                }
            });
        }
        long endTime = System.currentTimeMillis();
//        System.out.println("BFS shortest path NOT found, time in ms - " + (endTime - startTime));
        return null;
    }

    public List<Pair<Integer, Integer>> greedShortestPath() {
        long startMemory = RUNTIME.freeMemory();
//        System.out.println("Start DFS shortest path...");
        long startTime = System.currentTimeMillis();
        int n = world.size();
        int m = world.get(0).length();
        int[] visitedFrom = new int[n * m];
        boolean[] visited = new boolean[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visitedFrom[i * n + j] = -1;
            }
        }
        Pair<Integer, Integer> packman = getPackman();
        Pair<Integer, Integer> finish = getFinish();
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(packman);
        int packmanValue = getCellValue(packman);
        visitedFrom[packmanValue] = packmanValue;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.poll();
            int from = getCellValue(cell);
            if (visited[from]) {
                continue;
            }
            visited[from] = true;
            if (cell.equals(finish)) {
                List<Pair<Integer, Integer>> answer = getAnswer(visitedFrom, packman, finish);
                long endTime = System.currentTimeMillis();
//                System.out.println("DFS shortest path found, time in ms - " + (endTime - startTime));
                long endMemory = RUNTIME.freeMemory();
//                System.out.println("TOTAL MEMORY USED in bytes: " + (startMemory - endMemory));
                return answer;
            }
            List<Pair<Integer, Integer>> neighbours = getNeighbours(cell);
            neighbours.stream().forEach(nb -> {
                int nbValue = getCellValue(nb);
                if (visitedFrom[nbValue] == -1) {
                    visitedFrom[nbValue] = from;
                }
                if (!visited[nbValue]) {
                    queue.add(0, nb);
                }
            });
        }
        long endTime = System.currentTimeMillis();
//        System.out.println("DFS shortest path NOT found, time in ms - " + (endTime - startTime));
        return null;
    }

    public void printSteps(List<Pair<Integer, Integer>> path) {
        for (int i = 0; i < path.size(); i++) {
            makeGhostStep();
            Pair<Integer, Integer> packman = getPackman();
            List<String> newWorld = new ArrayList<>(world);
            ghosts.forEach(g -> {
                if (g.equals(packman)) {
                    newWorld.forEach(System.out::println);
                    throw new IllegalArgumentException("Packman died :((((");
                }
                String s = newWorld.get(g.getKey());
                s = s.substring(0, g.getValue()) + "w" + s.substring(g.getValue() + 1);
                newWorld.remove((int)g.getKey());
                newWorld.add(g.getKey(), s);
            });
            Pair<Integer, Integer> step = path.get(i);
            String s = world.get(packman.getKey());
            String newS = s.replace('e', ' ');
            world.set(packman.getKey(), newS);
            String s2 = world.get(step.getKey());
            char[] chars = s2.toCharArray();
            chars[step.getValue()] = 'e';
            world.set(step.getKey(), new String(chars));
            System.out.println("Printing step " + i);
            printData();
//            if (i == path.size() - 1) {
//                sleep(5000);
//            }
            sleep(300);
        }
    }

    private void makeGhostStep() {
        if (!ghosts.isEmpty()) {
            ghosts = ghosts.stream().map(g -> {
                List<Pair<Integer, Integer>> neighbours = getNeighbours(g).stream().filter(n -> world.get(n.getKey()).charAt(n.getValue()) == 'o' || world.get(n.getKey()).charAt(n.getValue()) == ' ').collect(Collectors.toList());
                if (!neighbours.isEmpty()) {
                    return neighbours.get(((int) (Math.random() * 100)) % neighbours.size());
                } else {
                    return g;
                }
            }).collect(Collectors.toList());
        }
    }

    private void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private List<Pair<Integer, Integer>> getAnswer(int[] visitedFrom, Pair<Integer, Integer> packman, Pair<Integer, Integer> finish) {
        int n = world.size();
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        int currentCellValue = getCellValue(finish);
        int startCellValue = getCellValue(packman);
        while (currentCellValue != startCellValue) {
            ans.add(new Pair<>(currentCellValue / n, currentCellValue % n));
            currentCellValue = visitedFrom[currentCellValue];
        }
        ans.add(new Pair<>(currentCellValue / n, currentCellValue % n));
        Collections.reverse(ans);
        return ans;
    }

    private int getCellValue(Pair<Integer, Integer> nb) {
        return nb.getKey() * world.size() + nb.getValue();
    }

    private List<Pair<Integer, Integer>> getNeighbours(Pair<Integer, Integer> cell) {
        List<Pair<Integer, Integer>> nb = new ArrayList<>();
        int x = cell.getKey();
        int y = cell.getValue();
        // top
        int x1 = x - 1;
        int y1 = y;
        if (x1 >= 0 && world.get(x1).charAt(y1) != 'x') {
            nb.add(new Pair<>(x1, y1));
        }
        // bottom
        x1 = x + 1;
        y1 = y;
        if (x1 < world.size() && world.get(x1).charAt(y1) != 'x') {
            nb.add(new Pair<>(x1, y1));
        }
        // left
        x1 = x;
        y1 = y - 1;
        if (y1 >= 0 && world.get(x1).charAt(y1) != 'x') {
            nb.add(new Pair<>(x1, y1));
        }
        // right
        x1 = x;
        y1 = y + 1;
        if (y1 < world.get(0).length() && world.get(x1).charAt(y1) != 'x') {
            nb.add(new Pair<>(x1, y1));
        }
        return nb;
    }

    private Pair<Integer, Integer> getFinish() {
        return getCell('o');
    }

    private Pair<Integer, Integer> getPackman() {
        return getCell('e');
    }

    private Pair<Integer, Integer> getCell(char cell) {
        int n = world.size();
        int m = world.get(0).length();
        Pair<Integer, Integer> packman = null;
        for (int i = 0; i < n; i++) {
            boolean isFound = false;
            for (int j = 0; j < m; j++) {
                if (world.get(i).charAt(j) == cell) {
                    packman = new Pair<>(i, j);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return packman;
    }

    public boolean isGame() {
        return getFinish() != null;
    }

    public void addGhost() {
        ghosts.add(getGhostCell());
    }

    private Pair<Integer, Integer> getGhostCell() {
        int n = world.size();
        int m = world.get(0).length();
        Pair<Integer, Integer> ghost = null;
        for (int i = n / 3; i < n; i++) {
            boolean isFound = false;
            for (int j = n / 3; j < m; j++) {
                if (world.get(i).charAt(j) == 'o') {
                    ghost = new Pair<>(i, j);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return ghost;
    }
}
