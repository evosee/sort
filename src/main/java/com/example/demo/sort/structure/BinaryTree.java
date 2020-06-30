package com.example.demo.sort.structure;

/**
 * @author chensai
 * @version 1.0
 * @date 2020/6/30 15:18
 * <p>
 * 二叉树
 */
public class BinaryTree {

    private Node root;

    public boolean insert(Object data) {
        Node node = new Node(data, null, null);
        if (root == null) {
            root = node;
            return true;
        } else {
            Node parent = root;
            Comparable comparable = (Comparable) data;
            while (true) {
                Comparable currentData = (Comparable) parent.data;
                if (comparable.compareTo(currentData) > 0) {
                    Node right = parent.right;
                    if (right == null) {
                        parent.right = node;
                        return true;
                    } else {
                        parent = right;
                    }
                } else if (comparable.compareTo(currentData) < 0) {
                    Node left = parent.left;
                    if (left == null) {
                        parent.left = node;
                        return true;
                    } else {
                        parent = left;
                    }
                } else {
                    return false;
                }
            }
        }

    }

    public Node get(Object data) {
        Node parent = root;
        Comparable comparable = (Comparable) data;
        while (parent != null) {
            Comparable currentData = (Comparable) parent.data;
            if (comparable.compareTo(currentData) > 0) {
                Node right = parent.right;
                parent = right;

            } else if (comparable.compareTo(currentData) < 0) {
                Node left = parent.left;
                parent = left;

            } else {
                return parent;
            }
        }
        return null;
    }

    public Object min(){
        Node parent = root;
        while (parent!=null){
            Node node = parent.left;
            if(node==null){
                return parent.data;
            }else{
                parent=node;
            }
        }
        return null;
    }
    public Object max(){
        Node parent = root;
        while (parent!=null){
            Node node = parent.right;
            if(node==null){
                return parent.data;
            }else{
                parent=node;
            }
        }
        return null;
    }

    public void treeWalk(Node node){
        if(node!=null){
            Node left = node.left;
            treeWalk(left);
            System.out.println(node.data);
            Node right = node.right;
            treeWalk(right);
        }
    }

    private static class Node {
        private Object data;
        private Node left;
        private Node right;

        public Node(Object data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(9);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(7);
        binaryTree.insert(0);
    //    System.out.println(binaryTree.get(9));
     //   System.out.println(binaryTree.get(5).right.data);
     //  binaryTree.treeWalk(binaryTree.root);
        System.out.println(binaryTree.min());
        System.out.println(binaryTree.max());
    }

}
