package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    public int y;
    public int x;

    public Pos(final int y, final int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ_2178 {

    public static int N;
    public static int M;
    public static int[][] visited;
    public static int[][] miro;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int[] integers = Arrays.stream(line.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            miro[i] = integers;
        }

        visited = new int[N][M];
        bfs(0, 0);

        System.out.println(visited[N-1][M-1]);
    }

    private static void bfs(final int y, final int x) {
        Queue<Pos> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(new Pos(y, x));

        while (q.size() != 0) {
            Pos poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (ny < 0 || N <= ny || nx < 0 || M <= nx || visited[ny][nx] != 0 || miro[ny][nx] == 0) {
                    continue;
                }

                visited[ny][nx] = visited[poll.y][poll.x] + 1;
                q.add(new Pos(ny, nx));
            }
        }
    }
}
