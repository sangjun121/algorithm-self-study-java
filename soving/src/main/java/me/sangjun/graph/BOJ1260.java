package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ1260 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //정점
        int M = Integer.parseInt(input[1]); // 간선 수
        int V = Integer.parseInt(input[2]); // 탐색 시작점

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] eInput = br.readLine().split(" ");
            adj.computeIfAbsent(Integer.parseInt(eInput[0]), k -> new ArrayList<>()).add(Integer.parseInt(eInput[1]));
            adj.computeIfAbsent(Integer.parseInt(eInput[1]), k -> new ArrayList<>()).add(Integer.parseInt(eInput[0]));
        }

        adj.forEach((key, value) -> {
            Collections.sort(value);
        });

        boolean[] dfsVisit = new boolean[N + 1];
        boolean[] bfsVisit = new boolean[N + 1];
        dfs(V, adj, dfsVisit);
        bw.newLine();
        bfs(V, adj, bfsVisit);
        bw.flush();
        bw.close();
    }

    private static void bfs(int start, Map<Integer, List<Integer>> adj, boolean[] visit) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int v = que.poll();
            bw.write(v + " ");

            for (int w : adj.getOrDefault(v, new ArrayList<>())) {
                if (visit[w]) {
                    continue;
                }
                que.add(w);
                visit[w] = true;
            }
        }
    }

    private static void dfs(int start, Map<Integer, List<Integer>> adj, boolean[] visit) throws IOException {
        visit[start] = true;
        bw.write(start + " ");

        for (int w : adj.getOrDefault(start, new ArrayList<>())) {
            if (visit[w]) {
                continue;
            }

            dfs(w, adj, visit);
        }
    }

    /**
     * ArrayList의 배열로 인접리스트 구현하기. ArrayList<Integer>[]
     */
    private static void makeListWithArrayListArray(int N){
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
    }
}
