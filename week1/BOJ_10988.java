package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10988 {
    private static Stack<Character> st = new Stack<>();

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String tar = br.readLine();
//
//        StringBuffer sb = new StringBuffer(tar);
//        String reverse = sb.reverse().toString();
//
//        if (tar.equals(reverse)) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tar = br.readLine();

        if (tar.length() % 2 == 0) {
            for(int i=0; i<(tar.length()/2); i++) {
                st.push(tar.charAt(i));
            }
            for(int i=(tar.length()/2); i<tar.length(); i++) {
                if (st.peek() == tar.charAt(i)) {
                    st.pop();
                }
            }
        } else {
            for(int i=0; i<(tar.length()/2); i++) {
                st.push(tar.charAt(i));
            }
            for(int i=(tar.length()/2)+1; i<tar.length(); i++) {
                if (st.peek() == tar.charAt(i)) {
                    st.pop();
                }
            }
        }

        if (st.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
