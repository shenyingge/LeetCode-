package domain;

import dataStruct.TreeNode;

public class LCOF_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)return null;
        else{
            TreeNode l = mirrorTree(root.left);
            TreeNode r = mirrorTree(root.right);
            root.left = r;
            root.right = l;
            return root;
        }
    }
}
