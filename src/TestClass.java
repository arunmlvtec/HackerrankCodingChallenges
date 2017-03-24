/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();
        int count = 0;
        if (a > 0 && b > 0) {
            int min = (a <= b) ? a : b;
            for (int i = 1; i <= (min/2); i++){
                if ((a % i) == 0 && (b % i) == 0) {
                    count += 1;
                }
            }
            if ((a % min) == 0 && (b % min) == 0)
                count += 1;
            System.out.println(count);
        }
        else {
            System.out.println(1);
        }
    }
}
