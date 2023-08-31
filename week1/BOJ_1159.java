package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1159 {

    private static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char tar = br.readLine().charAt(0);
            arr[tar - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        String ans = sb.toString();
        if (ans.length()==0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(ans);
        }
    }
}
