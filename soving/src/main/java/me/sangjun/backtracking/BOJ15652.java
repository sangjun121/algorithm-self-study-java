package me.sangjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 N과 M 문제(4)
 * https://web.archive.org/web/20260418211216/https://www.acmicpc.net/problem/15652
 */
public class BOJ15652 {
    private static int N;
    private static int M;
    private static StringBuilder sb  = new StringBuilder();
    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if(depth == M){
            for (int value : deque) {
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!deque.isEmpty() && i < deque.peekLast()) continue;

            deque.addLast(i);
            dfs(depth+1);
            deque.removeLast();
        }
    }
}
