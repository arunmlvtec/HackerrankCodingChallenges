import java.util.*;

public class MaxBinaryNums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        Stack<Integer> st = new Stack<Integer>();
        int rem = 0;
        int ctr = 0;
        int max = 0;
        if (n > 0 /*&& n <= 100000*/){
            while (n > 0){
                rem = n % 2;
                st.push(rem);
                n = n / 2;
            }
            while (!st.empty()){
                if (st.pop() == 1){
                    ctr++;
                }
                else {
                    if (max < ctr)
                        max = ctr;
                    ctr = 0;
                }
            }
        }
        max = max < ctr ? ctr : max;
        System.out.println(max);
    }
}
