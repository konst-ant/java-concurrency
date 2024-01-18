package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by KAntipin on 07.04.2016.
 */
public class UncaughtExceptionTask implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("Check uncaught exception NumberFormatException. If you input number below it's OK, but if you input non-number symbols exception will follow");
            System.out.println("Print the numeric argument ->");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input="0";
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("Exception while reading input line");
                e.printStackTrace();
            }
            Integer num = Integer.parseInt(input);
            System.out.println("Youre number is:" + num);
        }
    }
}
