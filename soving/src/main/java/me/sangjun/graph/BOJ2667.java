package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2667 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] edgeRelation = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        }

        //결과
        Collections.sort(result);
        bw.write(String.valueOf(result.size()) + "\n");
        for (Integer v : result) {
            bw.write(String.valueOf(v) + "\n");
        }
        bw.flush();
        bw.close();
    }

    /**
     * @param startI
     * @param startJ
     * @return
     * @Deprecated :혼자 문제 풀이시 작성한 함수. 해당 메소드는 모든 간선을 if 조건문을 사용.
     */
    private static int bfs(int startI, int startJ) {
        int count = 0;

        Queue<Integer[]> que = new LinkedList<>();
        Integer[] start = {startI, startJ};
        que.add(start);
        visited[startI][startJ] = true;
        count++;

        while (!que.isEmpty()) {
            Integer[] V = que.poll();

            if (V[0] - 1 >= 1 && !visited[V[0] - 1][V[1]] && map[V[0] - 1][V[1]] == 1) {
                Integer[] near = {V[0] - 1, V[1]};
                que.add(near);
                visited[V[0] - 1][V[1]] = true;
                count++;
            }
            if (V[1] - 1 >= 1 && !visited[V[0]][V[1] - 1] && map[V[0]][V[1] - 1] == 1) {
                Integer[] near = {V[0], V[1] - 1};
                que.add(near);
                visited[V[0]][V[1] - 1] = true;
                count++;
            }
            if (V[1] + 1 <= N && !visited[V[0]][V[1] + 1] && map[V[0]][V[1] + 1] == 1) {
                Integer[] near = {V[0], V[1] + 1};
                que.add(near);
                visited[V[0]][V[1] + 1] = true;
                count++;
            }
            if (V[0] + 1 <= N && !visited[V[0] + 1][V[1]] && map[V[0] + 1][V[1]] == 1) {
                Integer[] near = {V[0] + 1, V[1]};
                que.add(near);
                visited[V[0] + 1][V[1]] = true;
                count++;
            }
        }

        return count;
    }

    /**
     * 강의 문제 풀이. //dfs
     */
    private static int dfs(int startI, int startJ) {
        int count = 1;
        visited[startI][startJ] = true;

        for (int i = 0; i < 4; i++) {
            int x = startI + edgeRelation[i][0];
            int y = startJ + edgeRelation[i][1];

            if (x < 1 || x > N || y < 1 || y > N) {
                continue;
            }
            if (visited[x][y]) {
                continue;
            }
            if (map[x][y] == 0) {
                continue;
            }
            count += dfs(x, y);
        }

        return count;
    }

}
