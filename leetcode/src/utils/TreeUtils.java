package utils;

import dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 这个类用来打印二叉树
*/
public class TreeUtils {
    public static void printTree(TreeNode treeNode){
        if(treeNode != null){
            Queue<TreeNode> queue1 = new LinkedList<>();
            queue1.add(treeNode);
            while(!queue1.isEmpty()){
                boolean tag = false;
                Queue<TreeNode> queue2 = new LinkedList<>();
                while(!queue1.isEmpty()){
                    TreeNode element = queue1.element();
                    queue1.remove();
                    if(element != null)System.out.println(element.val+" ");
                    else {
                        System.out.println("null ");
                        continue;
                    }
                    queue2.add(element.left);
                    queue2.add(element.right);
                }
                while(!queue2.isEmpty()){
                    TreeNode element = queue2.element();
                    if(element != null)tag = true;
                    queue2.remove();
                    queue1.add(element);
                }
                if(!tag)break;
            }
        }
    }
}
