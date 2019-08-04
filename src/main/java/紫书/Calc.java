package 紫书;

import java.util.Scanner;

public class Calc
{
    void add(int x)
    {
        x += 1;
        System.out.println("x=" + x);
    }

    public static void main(String[] args)
    {
        
        // write your code here
        int a = 2;
        Calc c = new Calc();
        c.add(a);
        System.out.println("a=" + a);
    }
}