# Map 자료구조

## 주요 문법
### 1. map.entrySet(): Map 전체 원소 순회하기
```java
Map<String, Integer> map = new HashMap<>();

for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}
```

### 2. computeIfAbsent: Map에서 key가 없을 때만 값을 생성해 저장하고, 이미 있으면 기존 값을 그대로 반환하는 lazy 초기화 메서드. 
```java
Map<String, List<String>> group = new HashMap<>();

// A가 있다면, 해당 A에 대응되는 value(리스트)에 "apple" 추가. 없다면, new ArrayList<>()를 생성하고 put(저장)을 한 이후에 "apple" 추가.
group.computeIfAbsent("A", k -> new ArrayList<>()).add("apple");
```
