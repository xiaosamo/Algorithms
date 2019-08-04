package 校赛;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = " _   _\n" +
                "/ \\_/ \\\n" +
                "|     |\n" +
                "\\     /\n" +
                " \\   /\n" +
                "  \\_/";
        String s2 = "  __      __\n" +
                " /  \\    /  \\\n" +
                "/    \\__/    \\\n" +
                "|            |\n" +
                "|            |\n" +
                "\\            /\n" +
                " \\          /\n" +
                "  \\        /\n" +
                "   \\      /\n" +
                "    \\    /\n" +
                "     \\__/";


        while (in.hasNext()) {
            int n = in.nextInt();



            if (n == 1) {
                System.out.println(s);

            } else {

                System.out.println(s2);
            }
        }



    }


}
