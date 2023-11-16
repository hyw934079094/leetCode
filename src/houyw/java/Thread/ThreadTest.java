package houyw.java.Thread;

import java.util.function.IntConsumer;

/**
 * @Author: DELL
 * @Date: 2022/8/29 20:35
 * @Description:
 */
public class ThreadTest {
    /*public static void main(String[] args) {
        IntConsumerDemo intConsumerDemo = new IntConsumerDemo();
        intConsumerDemo.

    }*/
    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }


    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

        }

        public void even(IntConsumer printNumber) throws InterruptedException {

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

        }
    }
    static class IntConsumerDemo {
        public static void repeat(int n, IntConsumer action){
            for(int i=0;i<n;i++) {
                action.accept(i);
            }
        }

        public static void main(String[] args) {
            repeat(10,i-> System.out.println("Countdown: "+(9-i)));
        }
    }


}
