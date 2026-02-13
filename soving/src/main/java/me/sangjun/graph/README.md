## BOJ1260 DFS와 BFS

### 문제풀이시 막혔던 사항
1. Map 자료구조를 사용하여 그래프의 인접리스트를 구현하는 경우, 빈 Key에 대해 리스트 초기화해주는 것에서 오류 발생
   - 웬만하면 computeIfAbsent를 숙지하고, 기억이 나지 않는 경우 조건문으로 작성하자.
2. BufferedWriter에 대한 flush 사용 시점. 이 부분에 대한 정확한 공부가 필요할듯 하다. 
   - 해당 부분은 study/io 파트에 정리
3. Collections.sort()의 시간복잡도 정확히 암기하기.
