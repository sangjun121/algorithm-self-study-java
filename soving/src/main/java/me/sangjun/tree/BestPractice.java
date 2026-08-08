package me.sangjun.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 정보
 * 1. 트리의 간선의 개수는 V-1이다.
 */
public class BestPractice {
    private final static int V = 10;
    private final static List<Integer>[] graph = new ArrayList[V];

    static {
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(4);
        graph[3].add(1);
        graph[4].add(2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    }

    /**
     * 1. bfs로 트리 순회하기
     * 정보: 트리의 BFS는 인접한 노드 중에, 부모를 제외한 자식 노드만 아직 방문하지 않았다.
     *      그래서, que에 자식 노드들만 담아주면 된다.
     *      따라서 별도의 visit 배열을 관리하기보다, 부모 정보를 담는 배열을 관리하는 편이 쉽다.
     */
    public void bfs(int root){
        int[] parents = new int[V];
        int[] depth = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        parents[root] = -1; // 루트는 부모 없음
        depth[root] = 0;

        queue.add(root);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int nextNode : graph[node]){
                if(parents[node] == nextNode){ //트리에서의 BFS이기 때문에 별도의 visit 없이 부모인지만 확인
                    continue;
                }

                queue.add(nextNode);
                parents[nextNode] = node;
                depth[nextNode] = depth[node] + 1;
            }
        }
    }

    /**
     * 2. Stack을 활용한 반복문 DFS로 트리 순회하기 (재귀X)
     *    위의 bfs에서 Queue를 Stack으로 수정하면 된다.
     */
    public void dfsWithStack(int root){
        int[] parents = new int[V];
        int[] depth = new int[V];

    }
}
