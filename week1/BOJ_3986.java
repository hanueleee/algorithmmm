package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i=0; i<N; i++) {
            List<Character> chars = br.readLine().chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());

            Stack<Character> st = new Stack<>();
            for(int j=0; j<chars.size(); j++) {
                if (!st.empty() && st.peek().equals(chars.get(j))) {
                    st.pop();
                } else {
                    st.push(chars.get(j));
                }
            }
            if (st.empty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
