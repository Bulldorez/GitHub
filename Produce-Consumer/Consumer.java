package com.javarush.test.level17.lesson10.home02;

import java.util.ArrayList;

/**
 * Created by bulld_000 on 22.02.2015.
 */
public class Consumer implements Runnable
{
    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    private final Buffer buffer;
    private static int got_count = 0;
    private ArrayList<String> gotten_iteams = new ArrayList<String>();

    @Override
    public void run()
    {
        while(true)
        {
            String iteam_get = buffer.get_iteam();

            gotten_iteams.add(iteam_get);
            got_count++;
           // System.out.println("Consumed: " + iteam_get);
            System.out.println("Consumed: " + gotten_iteams.toString());


            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}
