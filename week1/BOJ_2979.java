package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {
    private static int A;
    private static int B;
    private static int C;
    private static int[] start = new int[3];
    private static int[] end = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i < 100; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (start[j] <= i && i < end[j]) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                sum += A;
            } else if (cnt == 2) {
                sum += B * 2;
            } else if (cnt == 3) {
                sum += C * 3;
            }
        }
        System.out.println(sum);
    }
}
