package hackerrank.contacts;

import java.io.*;
import java.util.*;

public class Solution {

    static class Node {
        char data;
        int count = 0;
        List<Node> children = new ArrayList<>();
    }

    static int[] contacts(String[][] queries) {
        List<Integer> res = new ArrayList<>();
        Node root = new Node();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals("add")) {
                addToTree(queries[i][1].toCharArray(), root, 0);
            } else {
                res.add(searchTree(queries[i][1].toCharArray(), root, 0));
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private static Integer searchTree(char[] s, Node root, int index) {
        List<Node> children = root.children;
        if (index == s.length) {
            return root.count;
        }
        int childIndex = -1;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).data == s[index]) {
                childIndex = i;
                break;
            }
        }
        if (childIndex == -1) {
            return 0;
        }
        return searchTree(s, children.get(childIndex), index + 1);
    }

//    private static Integer getWords(Node root) {
//        if (root.data == 0) {
//            return 1;
//        }
//        int words = 0;
//        List<Node> children = root.children;
//        for (int i = 0; i < children.size(); i++) {
//            words += getWords(children.get(i));
//        }
//        return words;
//    }

    private static void addToTree(char[] s, Node root, int index) {
        root.count++;
        List<Node> children = root.children;
        boolean inChildren = false;
        for (int i = 0; i < children.size(); i++) {
            if (root.children.get(i).data == s[index]) {
                addToTree(s, root.children.get(i), index + 1);
                inChildren = true;
                break;
            }
        }
        if (!inChildren) {
            Node node = addNode(s, index);
            root.children.add(node);
        }
    }

    private static Node addNode(char[] s, int index) {
        Node root = new Node();
        root.count++;
        root.data = s[index];
        if (index < s.length - 1) {
            root.children.add(addNode(s, index + 1));
        }
        if (index == s.length - 1) {
            root.children.add(new Node());
        }
        return root;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println((result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println("\n");
            }
        }
    }
}

