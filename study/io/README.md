# 기본 입출력

## 0. 기본 import 문
```java
import java.io.*
import java.util.*
```

## 1. 기본 문자열 입력 - BufferedReader 사용

```java
import java.io.*;

public static void main(String[] args) throws IOException 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = br.readLine();
```

### 1-1. BufferedReader 주요 메소드


## 2. 기본 문자열 출력 - BufferedWriter 사용

```java
import java.io.*;

public static void main(String[] args) throws IOException 
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(result); //여기서 result는 String
bw.flush();
bw.close();
```

### 2-1. BufferedWriter 사용시 주의사항
1. bw.flush()의 사용시점은 언제인가?
    - bw.write는 버퍼에 출력할 데이터를 작성하는 것이고, bw.flush는 버퍼를 비우면서 출력하는 것이다. bw.close는 버퍼를 비우면서 출력하고 stream을 닫는다.
    - 따라서, bw.flush는 마지막에 최종 출력시에만 호출해주어도 충분하다.
2. bw.newLine() 이후에 bw.flush를 해주어야 하는가?
    - bw.newLine()은 “출력”이 아니라, 버퍼에 줄바꿈 문자를 쓰는 작업이다. 따라서 bw.write와 함께 사용하다가 최종적으로 bw.flush를 호출하면 된다. 여기에 bw.close까지 호출하는 것이 안전하다.
3. 왜 int i에 대해서 bw.write(i)를 하면 제대로 출력되지 않는가?
   - i를 숫자로 출력하는 게 아니라, 유니코드(ASCII) 코드값이 i인 문자 1개를 출력한다.
   - 따라서 숫자를 출력하기 위해, ```bw.write(String.valueOf(i));```로 String으로 변환 후 출력한다.
