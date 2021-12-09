package algorithms.checkbst;

import algorithms.common.BinaryNode;

public class CheckIsBst {
    public static void main(String[] args) {
        CheckIsBst check = new CheckIsBst();
        BinaryNode node1 = new BinaryNode();
        BinaryNode node2 = new BinaryNode();
        BinaryNode node3 = new BinaryNode();
        BinaryNode node4 = new BinaryNode();
        BinaryNode node5 = new BinaryNode();
        BinaryNode node6 = new BinaryNode();
        BinaryNode node7 = new BinaryNode();
        node1.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node5.setLeft(node4);
        node5.setRight(node6);
        node6.setRight(node7); // left
        node4.setLeft(node2);
        node2.setLeft(node1);
        System.out.println(check.isBst(node5));
    }
    
    boolean isBst(BinaryNode root) {
        return isBst(root, null, null);
    }
    
    boolean isBst(BinaryNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.getValue() <= min) {
            return false;
        }
        if (max != null && node.getValue() >= max) {
            return false;
        }
        return isBst(node.getLeft(), min, node.getValue()) && isBst(node.getRight(), node.getValue(), max);
    }
}
