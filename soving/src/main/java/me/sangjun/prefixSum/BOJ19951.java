package me.sangjun.prefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * N: 칸의 개수 M: 조교의 수(쿼리의 수) H(i): 각 i칸의 높이 (총 N개) a: 시작칸의 번호 b: 마지막 칸의 번호 k: 덮거나 파내는 결정인자
 */
public class BOJ19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] h = new int[N + 1];
        String[] hInput = br.readLine().split(" ");
        for (int i = 0; i < hInput.length; i++) {
            h[i + 1] = Integer.parseInt(hInput[i]);
        }

        int[][] q = new int[M][3]; // 0:a 1:b 2:k
        for (int i = 0; i < M; i++) {
            String[] qInput = br.readLine().split(" ");
            q[i][0] = Integer.parseInt(qInput[0]);
            q[i][1] = Integer.parseInt(qInput[1]);
            q[i][2] = Integer.parseInt(qInput[2]);
        }

        // 차분 배열 구하기
        int[] diff = getPrefixSumByDiffArray(q, M, N);

        for (int i = 1; i <= N; i++) {
            h[i] += diff[i];
            bw.write(String.valueOf(h[i]) + " ");
            bw.flush();
        }
        bw.close();
    }

    private static int[] getPrefixSumByDiffArray(int[][] q, int qCount, int arrSize) {
        int[] diff = new int[arrSize + 1];
        int[] prefixSum = new int[arrSize + 1];

        for (int i = 0; i < qCount; i++) {
            diff[q[i][0]] += q[i][2];
            if (q[i][1] < arrSize) {
                diff[q[i][1] + 1] -= q[i][2];
            }
        }

        prefixSum[1] = diff[1];
        for (int i = 2; i <= arrSize; i++) {
            prefixSum[i] = prefixSum[i - 1] + diff[i];
        }

        return prefixSum;
    }
}
