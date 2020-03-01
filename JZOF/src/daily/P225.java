package daily;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
*/
public class P225 {
    MyStack myStack = new MyStack();
}

class MyStack{
    private Queue<Integer> queue1 = null;
    private Queue<Integer> queue2 = null;
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size() > 1){
            int val = queue1.element();
            queue1.remove();
            queue2.add(val);
            top = val;
        }
        int val = queue1.element();
        queue1.remove();
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;
        return val;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0;
    }
}