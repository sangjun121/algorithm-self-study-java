# Sort (정렬)

## 시간 복잡도 정리

### 1. Collections.sort()의 시간복잡도 
- Collections.sort()의 시간복잡도는 최악/평균/최선 모두 O(n log n)이다.
- 왜 O(n log n)인가? Collections.sort()는 내부적으로 TimSort를 사용한다. TimSort는 Merge Sort (O(n log n)) 와 Insertion Sort (O(n))를 결합한 하이브리드 정렬 알고리즘으로 O(n log n) 으로 잡는 것이 적절하다.
