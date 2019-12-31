package first.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author wuping
 * @date 2019-12-27
 */

public class ZeroEvenOdd {

    //leetcode 1116
    private int n;

    private int index = -1;
    private Lock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if(index == -1) {
                printNumber.accept(0);
                index++;
                oddCondition.signalAll();
                return;
            }

            while((index & 1) == 1) {
                zeroCondition.await();
            }

            printNumber.accept(0);
            index++;
            if((index & 3) == 1) {
                oddCondition.signalAll();
            } else if((index & 3) == 3) {
                evenCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while((index & 3) != 3) {
                evenCondition.await();
            }
            printNumber.accept(index >> 1);
            index++;
            zeroCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while((index & 3) != 1) {
                oddCondition.await();
            }

            printNumber.accept((index >> 1) + 1);
            index++;
            zeroCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
