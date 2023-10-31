package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BOJ_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> chars = br.readLine().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Map<Character, Integer> cm = new TreeMap<>();
        chars.forEach(it -> cm.put(it, cm.getOrDefault(it, 0) + 1));

        List<Character> collect = cm.entrySet().stream()
                .filter(it -> it.getValue() % 2 != 0)
                .map(Entry::getKey)
                .collect(Collectors.toList());
        if (collect.size() > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Set<Entry<Character, Integer>> entries = cm.entrySet();
        for (Entry<Character, Integer> entry : entries) {
            int cnt = entry.getValue() / 2;
            while (cnt > 0) {
                sb.append(entry.getKey());
                cnt--;
            }
        }
        String front = sb.toString();
        String back = sb.reverse().toString();
        String result;
        if (collect.size() == 0) {
            result = front + back;
        } else {
            result = front + collect.get(0) + back;
        }
        System.out.println(result);
    }
}
