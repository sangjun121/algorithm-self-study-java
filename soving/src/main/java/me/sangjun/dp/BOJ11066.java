package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] input = new int[T][501];

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            input[i][0] = K;
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= K; j++) {
                input[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        for (int i = 0; i < T; i++) {
            int result = getMinValue(input[i]);
            String resultString = String.valueOf(result);
            bw.write(resultString + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static int getMinValue(int[] valueArr) {
        int size = valueArr[0];
        int[][] dy = new int[size + 1][size + 1];
        int[][] sum = getSum(valueArr);

        //init
        for (int i = 1; i <= size; i++) {
            dy[i][i] = 0;
        }

        int startJ = 2;
        int i = 1;
        int j = 2;

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                int value = dy[i][k] + dy[k + 1][j] + sum[i][j];
                if (value <= min) {
                    min = value;
                }
            }
            dy[i][j] = min;

            // 대각선 순회
            i++;
            j++;
            if (j == size + 1 && i == 2) {
                return dy[1][size];
            }

            if (j == size + 1) {
                i = 1;
                startJ += 1;
                j = startJ;
            }
        }
    }

    private static int[][] getSum(int[] valueArr) {
        int size = valueArr[0];
        int[][] sums = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += valueArr[k];
                }
                sums[i][j] = sum;
            }
        }
        return sums;
    }
}
