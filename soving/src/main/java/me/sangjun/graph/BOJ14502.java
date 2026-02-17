package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ14502 {
    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final List<Coordinate> isZero = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
                if (map[i][j] == 0) {
                    isZero.add(new Coordinate(i, j));
                }
            }
        }

        int maxSafeZone = 0;

        for (Coordinate a : isZero) {
            for (Coordinate b : isZero) {
                for (Coordinate c : isZero) {
                    if (a.id != b.id && b.id != c.id && a.id != c.id) {
                        int[][] copiedMap = copy(N, M, map);
                        copiedMap[a.x][a.y] = 1;
                        copiedMap[b.x][b.y] = 1;
                        copiedMap[c.x][c.y] = 1;

                        /**
                         * 해당 부분 multi source BFS로 해결 가능
                         */
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < M; j++) {
                                if (copiedMap[i][j] == 2) {
                                    boolean[][] visited = new boolean[N][M];
                                    dfs(i, j, visited, copiedMap, N, M);
                                }
                            }
                        }
                        int safeCount = findZero(N, M, copiedMap);
                        maxSafeZone = Math.max(maxSafeZone, safeCount);
                    }
                }
            }
        }

        bw.write(String.valueOf(maxSafeZone));
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y, boolean[][] visited, int[][] copiedMap, int N, int M) {
        visited[x][y] = true;
        copiedMap[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (0 > nX || nX >= N || 0 > nY || nY >= M) {
                continue;
            }

            if (!visited[nX][nY] && copiedMap[nX][nY] == 0) {
                dfs(nX, nY, visited, copiedMap, N, M);
            }
        }
    }

    static class Coordinate {
        int id;
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = x * 10 + y;
        }
    }

    private static int[][] copy(int N, int M, int[][] ori) {
        int[][] copyed = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyed[i][j] = ori[i][j];
            }
        }

        return copyed;
    }

    private static int findZero(int N, int M, int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
