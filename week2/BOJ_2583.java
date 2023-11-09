package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Pos {
    public int y;
    public int x;

    public Pos(final int y, final int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ_2583 {

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, -1, 0, 1};
    private static int[][] zone;
    private static boolean[][] visited;
    private static int M;
    private static int N;
    private static Map<Integer, Integer> cnt = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        zone = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    zone[k][j] = 1;
                }
            }
        }

        visited = new boolean[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && zone[i][j] == 0) {
                    dfs(i, j, res);
                    res++;
                }
            }
        }
        System.out.println(res);
        cnt.entrySet().stream()
                .map(it -> it.getValue())
                .sorted()
                .forEach(it -> System.out.print(it + " "));

    }

    private static void dfs(final int y, final int x, final int idx) {
        visited[y][x] = true;
        cnt.put(idx, cnt.getOrDefault(idx, 0) + 1);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || M <= ny || nx < 0 || N <= nx || visited[ny][nx] || zone[ny][nx] == 1) {
                continue;
            }
            dfs(ny, nx, idx);
        }
    }
}

/*
int dfs(int y, int x){
    visited[y][x] = 1;
    int ret = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx] == 1 || a[ny][nx] == 1) continue;
        ret += dfs(ny, nx);
    }
    return ret;
}

    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(a[i][j] != 1 & visited[i][j] == 0) {
                ret.push_back(dfs(i, j));
            }
        }
    }
 */
