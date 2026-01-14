# 기본 입출력

### 0. 기본 import 문
```java
import java.io.*
import java.util.*
```

### 1. 기본 문자열 입력

```java
import java.io.*;

public static void main(String[] args) throws IOException 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = br.readLine();
```

### 2. 기본 문자열 출력

```java
import java.io.*;

public static void main(String[] args) throws IOException 
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(result); //여기서 result는 String
bw.flush();
bw.close();
```
