# 문자열

### String 주요 메소드

1. ```String.toCharArray()``` -> char 배열로 변환
```java
   //example: 
   char[] chars = input.toCharArray();
 ```
 
2. char -> String으로 변환하기
```java
   Character.toString(char i);
 ```

3. int -> String
```java
   String.valueOf(int i);
 ```

4. StringBuilder 활용
```java
StringBuilder result = new StringBuilder();
result.insert(0, parse(target % base)); // 여기서 index는 result의 인덱스를 의미, 따라서 맨 앞에 붙이고 싶은 경우 index를 0으로 지정
result.toString();
```

### 절대값 메소드
```java
import java.util.*;

Math.abs();
```
4. ```String.indexOf(String target, int 찾기 시작할 인덱스)```
```java
int index = docs.indexOf(word, pos);
// 여기서 pos는 찾기 시작할 인덱스를 의미한다.
// 시간 복잡도는 최악의 경우, O(M*N) m과 n은 각각 docs의 길이와 word의 길이를 의미
```
