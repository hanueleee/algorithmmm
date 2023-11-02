package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static boolean[][] visited;
    private static int[][] bat;
    private static int M;
    private static int N;
    private static int K;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            bat = new int[N][M];
            for (int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                bat[y][x] = 1;
            }

            visited = new boolean[N][M];
            cnt = 0;
            play(bat);
            System.out.println(cnt);
        }
    }

    private static void play(final int[][] bat) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (!visited[i][j] && bat[i][j] == 1) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(final int y, final int x) {
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || N <= ny || nx < 0 || M <= nx || visited[ny][nx] || bat[ny][nx] == 0) {
                continue;
            }
            dfs(ny, nx);
        }
    }
}
