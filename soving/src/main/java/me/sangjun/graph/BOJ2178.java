package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
    private static int[][] maze;
    private static boolean[][] visit;
    private static int[][] dist;
    private static int N;
    private static int M;

    private static final int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);

        maze = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(input2[j - 1]);
            }
        }

        bfs(1, 1);
        bw.write(String.valueOf(dist[N][M]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        visit[startX][startY] = true;
        dist[startX][startY] = 1;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = x + dir[i][0];
                int nY = y + dir[i][1];

                if (nX < 1 || nX > N || nY < 1 || nY > M) {
                    continue;
                }
                if (visit[nX][nY]) {
                    continue;
                }
                if (maze[nX][nY] == 0) {
                    continue;
                }

                que.add(nX);
                que.add(nY);
                visit[nX][nY] = true;
                dist[nX][nY] = dist[x][y] + 1;
            }
        }
    }
}
