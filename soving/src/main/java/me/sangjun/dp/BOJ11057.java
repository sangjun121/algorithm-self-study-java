package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
        int[][] value = new int[11][n + 1];

        /**
         * init
         */
        for (int i = 0; i <= 10; i++) {
            if (i == 10) {
                value[i][1] = 10;
            } else {
                value[i][1] = 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                value[j][i] = sum(value, i - 1, j, 9);
            }
            value[10][i] = sum(value, i, 0, 9);
        }

        bw.write(String.valueOf(value[10][n]));
        bw.flush();
        bw.close();
    }

    private static int sum(int[][] arr, int n, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum %= 10007;
            sum += (arr[i][n] % 10007);
        }
        return sum;
    }
}
