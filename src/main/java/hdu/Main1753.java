package hdu;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1753
{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        while (in.hasNext())
        {
            BigDecimal a = in.nextBigDecimal();
            BigDecimal b = in.nextBigDecimal();

            System.out.println(a.add(b).stripTrailingZeros().toPlainString());
            
        }

    }
    
}
