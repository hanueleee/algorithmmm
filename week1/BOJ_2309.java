package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    private static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        int sum = arr.stream()
                .mapToInt(it -> it)
                .sum();

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr.get(i) - arr.get(j) == 100) {
                    arr.remove(i);
                    arr.remove(j-1);
                    arr.stream()
                            .forEach(it -> System.out.println(it));
                    return;
                }
            }
        }
    }
}
