package me.sangjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 N과 M 문제
 * https://web.archive.org/web/20260426093738/https://www.acmicpc.net/problem/15650
 */
public class BOJ15650 {
    private static int N;
    private static int M;
    private static boolean[] visit;
    private static Deque<Integer> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth){
        if (depth == M) {
            for (int value : deque) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            if (visit[i]) continue;
            if(!deque.isEmpty() && i <= deque.peekLast()) continue;

            visit[i] = true;
            deque.addLast(i);

            dfs(depth + 1);

            visit[i] = false;
            deque.removeLast();
        }
    }
}
