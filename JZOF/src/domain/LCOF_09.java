package domain;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * 栈1用来插入数据
 * 栈2用来输出数据
 * 需要输出数据时，将栈1中的元素全部插入到栈2
*/
public class LCOF_09 {

}
class CQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public CQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void appendTail(int value) {
        st1.push(value);
    }

    public int deleteHead() {
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
        }
        return st2.empty()?-1:st2.pop();
    }
}
