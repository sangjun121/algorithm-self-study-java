# 기본 입출력

### 1. 기본 문자열 입력

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = br.readLine();
```

### 2. 기본 문자열 출력

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(result); //여기서 result는 String
bw.close();
```
