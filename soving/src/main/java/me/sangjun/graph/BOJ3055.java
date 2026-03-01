package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 빈 곳: . -> 0 물이 찬 곳: * -> 1 돌: X -> 2 비버굴: D -> 3 고슴도치 현재 위치: S -> 0
 */
public class BOJ3055 {
    private static final int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static int R;
    private static int C;

    private static int[][] map;
    private static final int[] endIndex = new int[2];

    private static final Queue<Integer> waterIndex = new LinkedList<>();
    private static boolean[][] waterVisit;
    private static int[][] waterDist;

    private static final Queue<Integer> dochiIndex = new LinkedList<>();
    private static boolean[][] dochiVisit;
    private static int[][] dochiDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new int[R][C];
        waterDist = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                waterDist[i][j] = Integer.MAX_VALUE;
            }
        }
        waterVisit = new boolean[R][C];

        dochiDist = new int[R][C];
        dochiVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] inputRow = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String token = inputRow[j];
                if (token.equals(".")) {
                    map[i][j] = 0;
                } else if (token.equals("*")) {
                    map[i][j] = 1;
                    waterIndex.add(i);
                    waterIndex.add(j);
                    waterVisit[i][j] = true;
                    waterDist[i][j] = 0;
                }
                if (token.equals("X")) {
                    map[i][j] = 2;
                }
                if (token.equals("D")) {
                    map[i][j] = 3;
                    endIndex[0] = i;
                    endIndex[1] = j;
                    waterDist[i][j] = Integer.MAX_VALUE;
                }
                if (token.equals("S")) {
                    map[i][j] = 0;
                    dochiIndex.add(i);
                    dochiIndex.add(j);
                    dochiVisit[i][j] = true;
                }
            }
        }

        waterBfs();
        dochiBfs();

        //출력
        if (dochiDist[endIndex[0]][endIndex[1]] == 0) {
            bw.write("KAKTUS");
        } else {
            bw.write(String.valueOf(dochiDist[endIndex[0]][endIndex[1]]));
        }
        bw.flush();
        bw.close();
    }

    private static void waterBfs() {
        int[][] waterMap = copyMap();

        while (!waterIndex.isEmpty()) {
            int x = waterIndex.poll();
            int y = waterIndex.poll();

            for (int i = 0; i < 4; i++) {
                int dx = dir[i][0] + x;
                int dy = dir[i][1] + y;

                if (0 > dx || 0 > dy || dx >= R || dy >= C) {
                    continue;
                }
                if (waterVisit[dx][dy]) {
                    continue;
                }
                if (waterMap[dx][dy] != 0) {
                    continue;
                }

                waterIndex.add(dx);
                waterIndex.add(dy);
                waterVisit[dx][dy] = true;
                waterDist[dx][dy] = waterDist[x][y] + 1;
            }
        }
    }

    private static void dochiBfs(){
        while (!dochiIndex.isEmpty()) {
            int x = dochiIndex.poll();
            int y = dochiIndex.poll();

            for (int i = 0; i < 4; i++) {
                int dx = dir[i][0] + x;
                int dy = dir[i][1] + y;

                if (0 > dx || 0 > dy || dx >= R || dy >= C) {
                    continue;
                }
                if (dochiVisit[dx][dy]) {
                    continue;
                }
                if (map[dx][dy] != 0 && map[dx][dy] != 3) {
                    continue;
                }
                if(waterDist[dx][dy] <= dochiDist[x][y] + 1){
                    continue;
                }

                dochiIndex.add(dx);
                dochiIndex.add(dy);
                dochiVisit[dx][dy] = true;
                dochiDist[dx][dy] = dochiDist[x][y] + 1;
            }
        }
    }

    private static int[][] copyMap() {
        int[][] newMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }
}
