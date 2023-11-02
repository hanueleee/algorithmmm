package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2468 {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int[][] zone;
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        zone = new int[N][N];
        int max = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                zone[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, zone[i][j]);
            }
        }

        int res = 0;
        for(int rain=0; rain<max; rain++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j] && zone[i][j] > rain) {
                        dfs(i,j, rain);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    private static void dfs(final int y, final int x, final int rain) {
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || N <= ny || nx < 0 || N <= nx || visited[ny][nx] || zone[ny][nx] <= rain) {
                continue;
            }
            dfs(ny, nx, rain);
        }
    }
}
