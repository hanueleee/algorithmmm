package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808 {
    private static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tar = br.readLine();

        for (int i = 0; i < tar.length(); i++) {
            arr[tar.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 알파벳 'b' - 'a' = 1
}
