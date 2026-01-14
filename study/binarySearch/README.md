# Binary Search(이분 탐색)
- 자주 사용되는 기법.
- **정렬되어 있는 집합에서**(비교가 가능하다는 의미, 순서가 있다라는 의미) 원하는 값을 찾는 효율적인 탐색 방법
- **정렬이 되어 있다면**, 모든 원소를 탐색하지 않고 이분탐색으로 효율적인 탐색이 가능
- 대소관계를 통해 답이 될 수 있는 범위 [L:R]를 좁혀나가는 방법.

### 시간 복잡도
O(log N)

### JAVA 기본 제공 함수
```int result = Arrays.binarySearch(arr, target);```
- 존재하는 경우, 해당 위치 인덱스를 내보내기 때문에 0이상이 나온다.
- 존재하지 않는 경우는 음수로 반환한다.

### 기본 코드

**while문 종료 조건** 암기하기

```java
public boolean isExist(int[] arr, int target) {
    int startIndex = 0, endIndex = arr.length - 1; //범위 인덱스

    while (startIndex <= endIndex) { // while문 종료 조건
        int m = (startIndex + endIndex) / 2;
        if (arr[m] < target) {
            startIndex = m + 1;
        } else if (arr[m] > target) {
            endIndex = m - 1;
        } else {
            return true;
        }
    }

    return false;
}
```

