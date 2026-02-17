package me.sangjun.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BOJ2251 {
    private static boolean[][][] visited;
    private static final Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        int[] limited = new int[]{A, B, C};
        visited = new boolean[A + 1][B + 1][C + 1];

        bfs(0, 0, C, limited);
        List<Integer> resultResult = new ArrayList<>(result);
        Collections.sort(resultResult);

        for (int v : resultResult) {
            bw.write(String.valueOf(v) + " ");
        }
        bw.flush();
        bw.close();
    }

    static class State {
        int[] currentState = new int[3]; //0,1,2 순으로 각각 ABC

        State(int[] value) {
            for (int i = 0; i < 3; i++) {
                currentState[i] = value[i];
            }
        }

        State move(int from, int to, int[] limit) {
            int[] newState = new int[3];
            for (int i = 0; i < 3; i++) {
                newState[i] = currentState[i];
            }

            if (currentState[from] + currentState[to] > limit[to]) {
                newState[from] -= (limit[to] - currentState[to]);
                newState[to] = limit[to];
            } else {
                newState[from] = 0;
                newState[to] += currentState[from];
            }

            return new State(newState);
        }
    }

    private static void bfs(int a, int b, int c, int[] limited){
        Queue<State> que = new LinkedList<>();

        que.add(new State(new int[]{a, b, c}));
        visited[a][b][c] = true;

        while (!que.isEmpty()) {
            State state = que.poll();
            if(state.currentState[0] == 0){
                result.add(state.currentState[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }
                    State movedState = state.move(i, j, limited);
                    if(visited[movedState.currentState[0]][movedState.currentState[1]][movedState.currentState[2]]){
                        continue;
                    }
                    que.add(movedState);
                    visited[movedState.currentState[0]][movedState.currentState[1]][movedState.currentState[2]] = true;
                }
            }
        }
    }
}
