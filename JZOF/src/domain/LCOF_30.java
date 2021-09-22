package domain;

import java.util.Stack;

public class LCOF_30 {
}

/**
 * 面试题30. 包含min函数的栈
 * 栈1用来实现基础的功能
 * 栈2用来存储当前栈的最小值
 * 动态规划的思路，空间换时间。
 */
class MinStack {

    private final Stack<Integer> st1;
    private final Stack<Integer> st2;

    /** initialize your data structure here. */
    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
        if(st2.size() == 0) {
            st2.push(x);
        }else{
            int m = min();
            st2.push(Math.min(m,x));
        }
    }

    public void pop() {
        st1.pop();
        st2.pop();
    }

    public int top() {
        return st1.peek();
    }

    public int min() {
        if(st2.size() > 0) {
            return st2.peek();
        }
        return 0;
    }
}