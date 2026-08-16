package me.sangjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 N과 M 문제(7)
 * https://web.archive.org/web/20260418211216/https://www.acmicpc.net/problem/15656
 */
public class BOJ15656 {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static Deque<Integer> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if(depth == M){
            for (int value : deque) {
                sb.append(value);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            deque.addLast(numbers[i]);
            dfs(depth + 1);
            deque.removeLast();
        }
    }
}
