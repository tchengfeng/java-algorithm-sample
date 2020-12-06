package com.data.structure.sample.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversalSolution {

    List<Integer> resultList = new ArrayList<Integer>();


    /**
     * 递归 - DFS
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return resultList;
        }

        resultList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return resultList;
    }

    /**
     * 迭代 - TODO
     */


}
