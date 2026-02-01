# 완전 탐색

### List <-> Array
```java

List<Integer> exampleList = new ArrayList<>();
Integer[] array = exampleList.toArray(new Integer[0]); 
// 여기서 new Integer[exampleList.size()]와 같은 효과를 내는 메소드이다.
// 결국, exampleList의 길이에 맞는 배열을 반환한다.
```
