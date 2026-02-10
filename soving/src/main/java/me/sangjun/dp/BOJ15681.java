package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ15681 {
    private static Map<Integer, Set<Integer>> childs = new HashMap<>();
    private static Map<Integer, Integer> parents = new HashMap<>();
    private static Map<Integer, Integer> sizes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        int[][] edges = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            String[] edgeInput = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(edgeInput[0]); //start idx
            edges[i][1] = Integer.parseInt(edgeInput[1]); //end idx
        }

        int[] U = new int[Q];
        for (int i = 0; i < Q; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        //2. 간선 Init
        Map<Integer, Set<Integer>> connect = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            connect.computeIfAbsent(edges[i][0], k -> new HashSet<>()).add(edges[i][1]);
        }
        for (int i = 0; i < N - 1; i++) {
            connect.computeIfAbsent(edges[i][1], k -> new HashSet<>()).add(edges[i][0]);
        }

        //3. 트리 만들기
        makeTree(R, -1, connect);

        //4. sizes 구하기
        countNodeOfSubTree(R);

        for (int i = 0; i < Q; i++) {
            bw.write(String.valueOf(sizes.get(U[i])));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    private static void makeTree(int currentNode, int parent, Map<Integer, Set<Integer>> connect) {
        Set<Integer> nearNodes = connect.get(currentNode);

        for (Integer nearNode : nearNodes) {
            if (nearNode != parent) {
                childs.computeIfAbsent(currentNode, k -> new HashSet<>()).add(nearNode);
                parents.put(nearNode, currentNode);
                makeTree(nearNode, parents.get(nearNode), connect);
            }
        }
    }

    private static int countNodeOfSubTree(int currentNode) {
        int size = 1;
        Set<Integer> childNodes = childs.getOrDefault(currentNode, new HashSet<>());
        if (childNodes.isEmpty()) {
            sizes.put(currentNode, size);
            return size;
        }

        for (int childNode : childNodes) {
            size += countNodeOfSubTree(childNode);
        }
        sizes.put(currentNode, size);
        return size;
    }
}
