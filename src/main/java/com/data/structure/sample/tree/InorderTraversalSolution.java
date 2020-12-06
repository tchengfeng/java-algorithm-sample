package com.data.structure.sample.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalSolution {

    List<Integer> resultList = new ArrayList<Integer>();

    /**
     * 递归 - DFS
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return resultList;
        }
        inorderTraversal(root.left);
        resultList.add(root.val);
        inorderTraversal(root.right);
        return resultList;
    }

    /**
     * 迭代 - TODO
     */


}
