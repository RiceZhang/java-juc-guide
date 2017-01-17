package org;

/**
 * 测试并发 与 串行 的执行时间
 *
 * <p>
 *     线程具有创建 和 上下文 切换的开销
 * </p>
 * Created by R on 2017/1/18.
 */
public class ConcurrencyTest {

     private static final long  count = 10001;

     public static void main(String[] args) {
        concurrency();
        serial();
     }

    /**
     * 并行
     */
    public static void concurrency() {
         long start = System.currentTimeMillis();
         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 int a = 0;
                 for(long i = 0; i < count; i++){
                     a+=5;
                 }
             }
         });
        thread.start();
        int b = 0;
        for(long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis();
        System.out.println("serial:" + time + "ms,b=" + b);

    }

    /**
     * 串行
     */
    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i=0; i < count; i++) {
            a+=5;
        }
        int b = 0;
        for(long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis();
        System.out.println("serial:" + time + "ms,b=" + b+ ",a=" + a);
    }

}
