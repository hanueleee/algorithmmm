package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
    private static int N;
    private static int K;
    private static int[] nums;
    private static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        sums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i - 1] + nums[i];
        }

        int max = -10000000;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, sums[i] - sums[i - K]);
        }

        System.out.println(max);
    }
}
