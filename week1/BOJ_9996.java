package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        int idx = pattern.indexOf("*");
        String bef = pattern.substring(0, idx);
        String aft = pattern.substring(idx+1);

        for (int i=0; i<N; i++) {
            String tar = br.readLine();
            if (tar.length() < bef.length() || tar.length() < aft.length() || tar.length() < bef.length() + aft.length()) {
                System.out.println("NE");
                continue;
            }

            String tarBef = tar.substring(0, bef.length());
            String tarAft = tar.substring(tar.length() - aft.length());
            if (tarBef.equals(bef) && tarAft.equals(aft)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
