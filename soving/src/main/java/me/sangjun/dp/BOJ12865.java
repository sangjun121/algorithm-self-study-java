package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] stuff = new int[N + 1][2]; //0번원소: 무게(w), 1번원소: 가치(v)

        for (int i = 1; i <= N; i++) {
            String[] inputLine = br.readLine().split(" ");
            stuff[i][0] = Integer.parseInt(inputLine[0]);
            stuff[i][1] = Integer.parseInt(inputLine[1]);
        }

        int[][] dy = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - stuff[i][0] < 0) {
                    dy[i][j] = dy[i - 1][j];
                } else {
                    if (dy[i - 1][j - stuff[i][0]] + stuff[i][1] >= dy[i-1][j]) {
                        dy[i][j] = dy[i - 1][j - stuff[i][0]] + stuff[i][1];
                    } else {
                        dy[i][j] = dy[i - 1][j];
                    }
                }
            }
        }

        bw.write(String.valueOf(dy[N][K]));
        bw.flush();
        bw.close();
    }
}
