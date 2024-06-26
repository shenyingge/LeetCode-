package domain;

import dataStruct.TreeNode;
import utils.TreeUtils;

public class LOCF_07 {
    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeUtils.printTree(treeNode);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return recTree(0,0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    /**
     * 递归构建二叉树
     * 例如：
     * 前序 [3,9,20,15,7]
     * 中序 [9,3,15,20,7]
     * 以前序的第一个元素为值，找到该元素在中序中的位置
     * 这个位置将中序数组分割成了左子树和右子树的两个元素集合
     * 计算左右子树的元素个数，lsize和rsize，就可以确定左右子树在前序数组中的分布
     * 定位左右子树在前序数组的位置范围之后，再次递归调用函数分而治之
     * 递归函数需要明确每次分布在前序和中序数组中不同的作用范围，
     * 这里使用p_l,p_r,i_l,i_r分别指代各自的左右边界。
     * 重点：左右边界的值都可以取到
    */
    public static TreeNode recTree(int p_index, int p_l, int p_r, int i_l, int i_r, int[] preorder, int[] inorder){
        if(p_l > p_r || i_l > i_r || (p_index<0) || (p_index>=preorder.length))return null;
        else{
            TreeNode nNode = new TreeNode(preorder[p_index]);
            if(p_l == p_r)return nNode;
            int i_index = -1;
            for(int i = i_l; i <= i_r; i++){
                if(inorder[i] == preorder[p_index]){
                    i_index = i;
                    break;
                }
            }
            if(i_index == -1)return null;
            int lsize = i_index-i_l;
            int rsize = i_r-i_index;
            int l_p_l = p_index+1;
            int l_p_r = p_index+lsize;
            int l_i_l = i_l;
            int l_i_r = i_index-1;
            int r_p_l = p_index+1+lsize;
            int r_p_r = p_r;
            int r_i_l = i_index+1;
            int r_i_r = i_r;
            nNode.left = recTree(p_index+1,p_index+1,p_index+lsize,i_l,i_index-1,preorder,inorder);
            nNode.right = recTree(p_index+1+lsize,p_index+1+lsize,p_r,i_index+1,i_r,preorder,inorder);
            return nNode;
        }
    }
}
