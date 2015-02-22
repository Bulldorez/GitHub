package com.javarush.test.level17.lesson10.home02;

/**
 * Created by bulld_000 on 22.02.2015.
 */
public class Producer implements Runnable
{
    public Producer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    private final Buffer buffer;
    private static int iteam_produce_count = 0;

    @Override
    public void run()
    {
        String iteam_produce = "";

        while (true)
        {
            iteam_produce_count++;
            iteam_produce = "It" + iteam_produce_count;

           // System.out.println("Produced " + iteam_produce);
            buffer.put_iteam(iteam_produce);

            try { Thread.sleep(3000); } catch (InterruptedException e) {}
        }
    }
}
