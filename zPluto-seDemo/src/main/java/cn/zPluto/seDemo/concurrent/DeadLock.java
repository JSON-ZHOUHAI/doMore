package cn.zPluto.seDemo.concurrent;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/3/16.
 */
public class DeadLock {
    private  static String A ="A";
    private  static String B ="B";

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    private void deadLock(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("A");
               synchronized (A){
                   try {
                       Thread.currentThread().sleep(3000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (B){
                       System.out.println("1");
                   }
               }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
                synchronized (B){
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
