package org.renm.leetcode.serializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.removeFirst();
            if (node == null) {
                list.add(null);
            } else {
                list.add(node.getVal());
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                nodes.addLast(left);
                nodes.addLast(right);
            }
        }

        return format(trimEnd(list));
    }

    //public for test
    public String format(List<Integer> list) {
        StringBuilder builder = new StringBuilder("[");
        for (Integer i : list) {
            builder.append(i);
            builder.append(',');
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }

    //public for test
    public List<Integer> trimEnd(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            Integer v = list.get(i);
            if (v == null) {
                list.remove(i);
            } else {
                break;
            }
        }
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<TreeNode> contents = unpakage(data);
        if (contents.isEmpty()) {
            return null;
        }
        TreeNode root = contents.removeFirst();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.addLast(root);
        while (!contents.isEmpty()) {
            TreeNode collect = temp.removeFirst();
            TreeNode node = contents.removeFirst();
            collect.setLeft(node);
            if (node != null) {
                temp.addLast(node);
            }
            if (!contents.isEmpty()) {
                node = contents.removeFirst();
                collect.setRight(node);
                if (node != null) {
                    temp.addLast(node);
                }
            }
        }
        return root;
    }

    //public for test
    public LinkedList<TreeNode> unpakage(String data) {
        LinkedList<TreeNode> list = new LinkedList<>();
        String nobrackets = data.substring(1, data.length() - 1);
        String[] split = nobrackets.split(",");
        for (String s : split) {
            if (s.equals("null")) {
                list.add(null);
            } else {
                list.add(new TreeNode(Integer.parseInt(s)));
            }
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));