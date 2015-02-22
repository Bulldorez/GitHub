package com.javarush.test.level17.lesson10.home02;

import java.util.ArrayList;

/**
 * Created by bulld_000 on 22.02.2015.
 */
public class Buffer
{
    private static ArrayList<String> iteams = new ArrayList<String>();
    private static int iteams_count;

    public synchronized  void put_iteam(String iteam)
    {
        iteams.add(iteam);
        iteams_count++;
      //  System.out.println("Положили: " + iteam + " в буффер. Уже есть" + iteams_count + " элементов");
        System.out.println("Buffer: " + iteams.toString());

        if (iteams_count>0) notifyAll();
    }

    public synchronized  String get_iteam()
    {
        while (iteams_count == 0)
        {
            try { this.wait(); } catch (InterruptedException e) {
                System.out.println("Interrupted in Buffer get_iteam");
            }
        }

        int get_element_num = --iteams_count; // get last element
        String result = iteams.get(get_element_num);
        iteams.remove(get_element_num);

       // System.out.println("Забрали: " + result);
        return result;
    }

    public static int get_iteams_count()
    {
        return iteams_count;
    }


}
