package com.data.structure.sample.tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversalSolution {

    List<Integer> resultList = new ArrayList<Integer>();

    /**
     * 递归 - DFS
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return resultList;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        resultList.add(root.val);
        return resultList;
    }

    /**
     * 迭代 - TODO
     */




}
