package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char tar = s.charAt(i);
            if ('A'<= tar && tar <= 'Z') {
                sb.append((char) ((tar-'A'+13) % 26+'A'));
            } else if ('a'<=tar && tar <='z') {
                sb.append((char) ((tar-'a'+13) % 26+'a'));
            } else {
                sb.append(tar);
            }
        }

        System.out.println(sb.toString());
    }
}
