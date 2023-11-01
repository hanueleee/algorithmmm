package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int q = Integer.parseInt(br.readLine());

        Map<Character, int[]> sumMap = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int[] sum = new int[input.length() + 1];
            for (int i = 1; i <= input.length(); i++) {
                if (input.charAt(i - 1) == ch) {
                    sum[i] = sum[i - 1] + 1;
                } else {
                    sum[i] = sum[i - 1];
                }
            }
            sumMap.put(ch, sum);
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int[] res = sumMap.get(alpha);
            System.out.println(res[r + 1] - res[l]);
        }
    }
}
