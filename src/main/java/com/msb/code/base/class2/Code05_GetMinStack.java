package com.msb.code.base.class2;

import java.util.Stack;

/**
 * 实现获取栈中最小值，时间复杂度为O(1)
 * 思路：用两个栈
 */
public class Code05_GetMinStack {

    static class MyStack1 {
        Stack<Integer> stackData = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();

        public void push(Integer value) {
            stackData.push(value);
            if (stackMin.empty()) {
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                stackMin.push(peek < value ? peek : value);
            }
        }

        public int pop() throws Exception{
            if (stackData.empty()) {
                throw new Exception("栈空了");
            }

            Integer pop = stackData.pop();
            stackMin.pop();
            return pop;
        }

        public int getmin() throws Exception{
            if (stackData.empty()) {
                throw new Exception("栈空了");
            }

            return stackMin.peek();
        }

    }

    static class MyStack2 {
        Stack<Integer> stackData = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();

        public void push(Integer value) {
            stackData.push(value);
            if (stackMin.empty()) {
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                if (peek > value) stackMin.push(value);
            }
        }

        public int pop() throws Exception{
            if (stackData.empty()) {
                throw new Exception("栈空了");
            }

            Integer pop = stackData.pop();
            Integer peek = stackMin.peek();
            if (pop <= peek) {
                stackMin.pop();
            }
            return pop;
        }

        public int getmin() throws Exception{
            if (stackData.empty()) {
                throw new Exception("栈空了");
            }

            return stackMin.peek();
        }

    }

    public static void main(String[] args) throws Exception{
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println("min:" + stack1.getmin());
        stack1.push(4);
        System.out.println("min:" + stack1.getmin());
        stack1.push(1);
        System.out.println("min:" + stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println("min:" + stack1.getmin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println("min:" + stack2.getmin());
        stack2.push(4);
        System.out.println("min:" + stack2.getmin());
        stack2.push(1);
        System.out.println("min:" + stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println("min:" + stack2.getmin());
    }


//    public static class MyStack1 {
//        private Stack<Integer> stackData;
//        private Stack<Integer> stackMin;
//
//        public MyStack1() {
//            this.stackData = new Stack<Integer>();
//            this.stackMin = new Stack<Integer>();
//        }
//
//        public void push(int newNum) {
//            if (this.stackMin.isEmpty()) {
//                this.stackMin.push(newNum);
//            } else if (newNum <= this.getmin()) {
//                this.stackMin.push(newNum);
//            }
//            this.stackData.push(newNum);
//        }
//
//        public int pop() {
//            if (this.stackData.isEmpty()) {
//                throw new RuntimeException("Your stack is empty.");
//            }
//            int value = this.stackData.pop();
//            if (value == this.getmin()) {
//                this.stackMin.pop();
//            }
//            return value;
//        }
//
//        public int getmin() {
//            if (this.stackMin.isEmpty()) {
//                throw new RuntimeException("Your stack is empty.");
//            }
//            return this.stackMin.peek();
//        }
//    }
//
//    public static class MyStack2 {
//        private Stack<Integer> stackData;
//        private Stack<Integer> stackMin;
//
//        public MyStack2() {
//            this.stackData = new Stack<Integer>();
//            this.stackMin = new Stack<Integer>();
//        }
//
//        public void push(int newNum) {
//            if (this.stackMin.isEmpty()) {
//                this.stackMin.push(newNum);
//            } else if (newNum < this.getmin()) {
//                this.stackMin.push(newNum);
//            } else {
//                int newMin = this.stackMin.peek();
//                this.stackMin.push(newMin);
//            }
//            this.stackData.push(newNum);
//        }
//
//        public int pop() {
//            if (this.stackData.isEmpty()) {
//                throw new RuntimeException("Your stack is empty.");
//            }
//            this.stackMin.pop();
//            return this.stackData.pop();
//        }
//
//        public int getmin() {
//            if (this.stackMin.isEmpty()) {
//                throw new RuntimeException("Your stack is empty.");
//            }
//            return this.stackMin.peek();
//        }
//    }
}
