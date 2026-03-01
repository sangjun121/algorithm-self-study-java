package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1890 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dy = new long[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        dy[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                if (dy[i][j] == 0) {
                    continue;
                }
                if (i + map[i][j] < N) {
                    dy[i + map[i][j]][j] += dy[i][j];
                }
                if (j + map[i][j] < N) {
                    dy[i][j + map[i][j]] += dy[i][j];
                }
            }
        }

        bw.write(String.valueOf(dy[N - 1][N - 1]));
        bw.flush();
        bw.close();
    }
}
