package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_1620 {
    private static int N;
    private static int M;
    private static Map<String, String> pokemons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pokemons = new HashMap<>();

        for (int i=1; i<N+1; i++) {
            String name = br.readLine();
            pokemons.put(String.valueOf(i), name);
            pokemons.put(name, String.valueOf(i));
        }

        for (int i=0; i<M; i++) {
            String tar = br.readLine();
            System.out.println(pokemons.get(tar));
        }
    }
}
