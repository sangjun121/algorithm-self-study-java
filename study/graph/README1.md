# 그래프 응용

## 1. 격자형 그래프를 표현하는 방법
- 대표 예시 문제: [BOJ2667 단지번호 붙이기](../../soving/src/main/java/me/sangjun/graph/README.md) 
- 이 문제처럼 2차원 배열에 표현된 그래프를 **격자형 그래프**라고 한다. 격자형 그래프를 코드로 표현하는 방법을 알고 있어야 한다. 정점과 간선을 어떻게 표현할지 고민하면 된다.
    - 이 문제에서는 각 격자 한칸이 정점. 인접하는 격자가 같은 값(1)인 경우, 간선으로 해석하면 된다.

### 1-1. 인접한 칸의 관계를 표현하는 배열 만들기
- **간선의 관계를 표현하는 배열을 만들면 이를 해결할 수 있다.**
  - 이 문제에서는 dir[4][2] = { (-1,0), (0,1) , (1,0) ,(0,-1) } 을 미리 저장하고, 모든 정점에 대해 해당 배열의 원소를 더해 인접한 정점을 구하면 된다.
- 이 문제처럼 간선의 관계가 인접한 경우인 경우에는 총 4가지의 케이스가 나오지만, 인접한 2칸인 경우에는 총 8가지가 된다. 이를 모두 조건문으로 작성해 줄 수 없으니, 이와 같은 배열을 사용하여 문제를 해결할 수 있다.

## 2. 전혀 그래프와 연관이 없어 보이나, 문제의 조건을 정점과 간선으로 잘 정의하여 그래프로 풀어야 하는 문제
- 대표 예시 문제: [BOJ2251 물통](../../soving/src/main/java/me/sangjun/graph/README.md)

## 3. MulitSource BFS 
- **시작점이 여러 개(n)인 그래프 탐색에서, BFS를 n번 수행하지 않고, 단 한번의 BFS로 탐색을 수행하는 것을 의미한다.**
- 기존의 BFS는 시작점 하나만 Queue에 넣고 while문을 시작했다면, 가능한 모든 시작점을 bfs 실행 초기에 전부 Queue에 넣은 상태로 BFS를 시작하는 것을 의미한다.
- 따라서 시간 복잡도는 O(V+E)가 유지된다.

### 3-1. 구현 코드
```java
import java.util.LinkedList;
import java.util.Queue;

//해당 함수의 의미: start에서 시작해서 갈 수 있는 정점들을 모두 탐색하기.

static void bfs(int start) {
    Queue<Integer> que = new LinkedList<>();

  /**
   * 새롭게 추가된 코드.
   * 예를 들어, 2차원 배열 안의 데이터가 2인 경우가 모두 탐색 시작점이 되야한다면, 아래와 같은 코드로 queue에 시작점 담기
   * (예시문제 BOJ 14502 연구소)
   */
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (map[i][j] == 2) { //여기서 (i,j)를 아래 정점 v로 해석하면 된다.
        Node node = {i, j};
        que.add(node);
      } 
    }
  }

  /**
   * 아래는 기존 bfs와 동일하다.
   */
  que.add(start);
    visit[start] = true;

    while (!que.isEmpty()) {
        int v = que.poll();

        for (int w : v에서 갈 수 있는 노드들){
            if (visit[w]) {
                continue;
            }
            
            que.add(w);
            visit[w] = true;
        }
    }
}
```
