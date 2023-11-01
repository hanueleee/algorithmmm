package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + N + 1];
        int[] sum = new int[N + N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = N + 1; i <= 2 * N; i++) {
            if (arr[i % N] == 0) {
                sum[i] = sum[i - 1] + arr[N];
            } else {
                sum[i] = sum[i - 1] + arr[i % N];
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = sum[i + K] - sum[i];
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }
}
