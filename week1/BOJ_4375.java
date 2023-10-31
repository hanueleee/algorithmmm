package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=br.readLine()) != null) {
            N = Integer.parseInt(input);
            long sum = 1;
            long cnt = 1;
            while (sum % N != 0) {
                sum += pow(10, cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static long pow(long A, long B) {
        if (B == 1) {
            return A % N;
        }

        long temp = pow(A, B / 2);
        if (B % 2 == 1) {
            return (temp * temp * A) % N;
        }
        return (temp * temp) % N;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        while ((input = br.readLine()) != null) {
//            int N = Integer.parseInt(input);
//            int cnt = 1, ret = 1;
//            while (true) {
//                if (cnt % N == 0) {
//                    System.out.println(ret);
//                    break;
//                } else {
//                    cnt = (cnt * 10) + 1;
//                    cnt %= N;
//                    ret++;
//                }
//            }
//        }
//    }
}
