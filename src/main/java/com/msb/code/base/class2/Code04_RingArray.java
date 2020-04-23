package com.msb.code.base.class2;

/**
 * 用数组方式实现一个队列，固定大小不变
 */
public class Code04_RingArray {

    public static class MyQueue{
        private int[] arr;
        private int pollIndex;
        private int pushIndex;
        private int size;
        private int limit;

        public MyQueue(int l) {
            pollIndex = 0;
            pushIndex = 0;
            size = 0;
            arr = new int[l];
            limit = l;
        }

        public void push(int a) throws Exception{
            if (size >= limit) {
                throw new Exception("队列满了，不能再加了");
            }
            arr[pushIndex] = a;

            addIndex();

        }

        public int pop() throws Exception{
            if (size == 0) {
                throw new Exception("队列空了");
            }
            int a = arr[pollIndex];
            subIndex();
            return a;
        }

        // 可以将下面的方法解耦成左老师的写法
        private void addIndex() {
            size ++;
            pushIndex = pushIndex == size - 1 ? 0 : ++pushIndex;
        }

        private void subIndex() {
            size --;
            pollIndex = pollIndex == 0 ? size-1 : --pollIndex;
        }

    }

    /**
     * 左老师的实现
     */
    public static class ZuoQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public ZuoQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }

    public static void main(String[] args) {

    }
}
