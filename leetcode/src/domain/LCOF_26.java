package domain;

import dataStruct.TreeNode;

public class LCOF_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B == null)return true;
        else if(A == null || B == null)return false;
        boolean l = isSubStructure(A.left,B);
        boolean mid = A.val == B.val && isSimilar(A, B);
        if(mid) return true;
        boolean r = isSubStructure(A.right,B);
        return l||r;
    }
    public boolean isSimilar(TreeNode A, TreeNode B){
        if(B == null)return true;
        else if(A == null)return false;
        else{
            if(A.val != B.val)return false;
            else return isSimilar(A.left,B.left)&&isSimilar(A.right,B.right);
        }
    }
}
