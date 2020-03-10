package daily;

//543. 二叉树的直径

import dataStruct.TreeNode;

public class P543 {
    /*
    1.必须经过根节点的最大距离 = 该结点为中心，其左右子树为各自起点分别向下可以延伸最长的路径相加
    2.递归遍历剩余结点重复执行上述操作，同时更新最大值
    第二步可以合并到第一步递归过程中进行
    */
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return res;
    }
    public int rec(TreeNode n){
        if(n == null)return 0;
        else{
            int l = rec(n.left);
            int r = rec(n.right);
            res = Math.max(l+r,res);
            return Math.max(l,r)+1;
        }
    }
}
