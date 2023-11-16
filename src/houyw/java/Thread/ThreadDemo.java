package houyw.java.Thread;

/**
 * @Author: DELL
 * @Date: 2023/5/4 11:22
 * @Description:
 */
public class ThreadDemo {
    static int num = 10;
    public static void main(String[] args) {
      new Thread(new myThread()).start();
      new Thread(new myThread1()).start();

    }

    static class myThread implements Runnable {
        @Override
        public void run() {
            while(num>0){
                System.out.println("减1，剩余："+ --num);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
    static class myThread1 implements Runnable{
        @Override
        public void run() {
            while(num<10){
                System.out.println("加1");
                num++;
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
