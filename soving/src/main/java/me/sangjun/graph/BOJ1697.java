package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
    private static final boolean[] visited = new boolean[100001];
    private static final int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        bfs(N);

        bw.write(String.valueOf(dist[K]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;
        dist[start] = 0;

        while(!que.isEmpty()){
            int current = que.poll();

            int[] canMoved = new int[]{current - 1, current + 1, current * 2};
            for (int i = 0; i < 3; i++) {
                int next = canMoved[i];
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (visited[next]) {
                    continue;
                }

                que.add(next);
                visited[next] = true;
                dist[next] = dist[current] + 1;
            }
        }
    }
}
