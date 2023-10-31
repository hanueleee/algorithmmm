package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < N; j++) {
                String input = br.readLine();
                String type = input.split(" ")[1];
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }
            int sum = clothes.values().stream()
                    .mapToInt(num -> num + 1)
                    .reduce(1, (x, y) -> x * y);
            System.out.println(sum - 1);
        }
    }
}
