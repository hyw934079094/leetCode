package houyw.java.Thread;

import java.util.function.IntConsumer;

/**
 * @Author: DELL
 * @Date: 2023/10/31 14:52
 * @Description:
 */
public class ZeroEvenOdd{

    /**
     * 1116. ��ӡ������ż��
     * ���к��� printNumber ������һ�������������ã������������������̨��
     *
     * ���磬���� printNumber(7) ������� 7 ������̨��
     * ������ ZeroEvenOdd ��һ��ʵ����������������������zero��even �� odd ��ZeroEvenOdd ����ͬʵ�����ᴫ�ݸ�������ͬ�̣߳�
     *
     * �߳� A������ zero() ��ֻ��� 0
     * �߳� B������ even() ��ֻ���ż��
     * �߳� C������ odd() ��ֻ�������
     * �޸ĸ������࣬��������� "010203040506..." ���������еĳ��ȱ���Ϊ 2n ��
     *
     * ʵ�� ZeroEvenOdd �ࣺ
     *
     * ZeroEvenOdd(int n) ������ n ��ʼ�����󣬱�ʾ��Ҫ���������
     * void zero(printNumber) ���� printNumber �����һ�� 0 ��
     * void even(printNumber) ����printNumber �����ż����
     * void odd(printNumber) ���� printNumber �����������
     *
     *
     * ʾ�� 1��
     *
     * ���룺n = 2
     * �����"0102"
     * ���ͣ������߳��첽ִ�У�����һ������ zero()����һ���̵߳��� even()�����һ���̵߳���odd()����ȷ�����Ϊ "0102"��
     * ʾ�� 2��
     *
     * ���룺n = 5
     * �����"0102030405"
     */

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(n);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(n);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(n);
    }

}
