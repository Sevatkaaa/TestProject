package algorithms.bfs;

import algorithms.common.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node1.setChildren(Arrays.asList(node2, node3));
        node3.setChildren(Arrays.asList(node4, node5));
        node4.setChildren(Arrays.asList(node6, node7));

        BFS bfs = new BFS();

        bfs.bfs(node1);
    }

    public void bfs(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            System.out.println(node.getValue());
            nodes.addAll(node.getChildren());
        }
    }

}
