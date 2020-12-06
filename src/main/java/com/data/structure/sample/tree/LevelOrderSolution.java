package com.data.structure.sample.tree;

import java.util.*;

public class LevelOrderSolution {

    List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    /**
     * 递归 - DFS
     * @param root
     * @param level
     */
    public void helper(TreeNode root, int level){
        if(resultList.size() == level){
            resultList.add(new ArrayList<Integer>());
        }

        resultList.get(level).add(root.val);

        if(root.left != null){
            helper(root.left, level + 1);
        }
        if(root.right != null){
            helper(root.right, ++level + 1);
        }
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if(root == null){
            return resultList;
        }
        helper(root,0);
        return resultList;
    }

    /**
     * 迭代 - BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        new LevelOrderSolution().levelOrderDFS(treeNode1);
        new LevelOrderSolution().levelOrderBFS(treeNode1);



    }




}
