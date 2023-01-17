package org.mains;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task1=new PerformTransaction();
        Runnable task2=new ShowMenu();
        executor.execute(task2);
        executor.execute(task1);
        executor.shutdown();
    }

}