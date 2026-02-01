package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 계단오르기 문제 (DP)
 */
public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(String.valueOf(value[1]));
            bw.flush();
            bw.close();
            return;
        }
        if (n == 2) {
            bw.write(String.valueOf(value[1] + value[2]));
            bw.flush();
            bw.close();
            return;
        }
        if (n == 3) {
            if ((value[1] + value[3]) > (value[2] + value[3])) {
                bw.write(String.valueOf(value[1] + value[3]));
                bw.flush();
                bw.close();
            } else {
                bw.write(String.valueOf(value[2] + value[3]));
                bw.flush();
                bw.close();
            }
            return;
        }

        int[] dy = new int[n + 1];
        dy[1] = value[1];
        dy[2] = value[1] + value[2];

        if ((value[1] + value[3]) > (value[2] + value[3])) {
            dy[3] = value[1] + value[3];
        } else {
            dy[3] = value[2] + value[3];
        }

        for (int i = 4; i <= n; i++) {
            int first = dy[i - 2] + value[i];
            int second = dy[i - 3] + value[i - 1] + value[i];

            if (first > second) {
                dy[i] = first;
            } else {
                dy[i] = second;
            }
        }

        bw.write(String.valueOf(dy[n]));
        bw.flush();
        bw.close();
    }
}

