package org.renm.leetcode.serializeAndDeserializeBinaryTree;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CodecTest {
    TreeNode node1;
    String data1;

    TreeNode node2;
    String data2;

    TreeNode node3;
    String data3;

    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("teardown");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("before class");
    }

    @Test
    public void serializeTest() {
        System.out.println("serializeTest");
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode root = node1;
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        Codec ser = new Codec();
        String serialize = ser.serialize(root);
        System.out.println(serialize);
    }

    @Test
    public void deserializeTest() {
        System.out.println("deserializeTest");
        Codec deser = new Codec();
        TreeNode deserialize = deser.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(deserialize);
    }

}