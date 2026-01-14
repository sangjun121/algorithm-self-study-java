package me.sangjun.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 사전순 정렬을 사용하고, 이진 탐색을 통한 원소 찾기 시간 복잡도
 */
public class BOJ14425_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] countInput = br.readLine().split(" ");

        List<String> documents = new ArrayList<>();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(countInput[0]); i++) {
            documents.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(countInput[1]); i++) {
            words.add(br.readLine());
        }

        Collections.sort(documents);
        Collections.sort(words);

        int count = 0;
        for (String word : words) {
            if (isExist(documents.toArray(new String[0]), word)) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    /**
     * Binary Search
     * 시간 복잡도 sortedDocument의 길이가 N일때
     * O(log2(n) * L (문자열 길이))
     *
     * @return isExist
     */
    private static boolean isExist(String[] sortedDocument, String word) {
        int startIndex = 0, endIndex = sortedDocument.length - 1;

        while (startIndex <= endIndex) {
            int m = (startIndex + endIndex) / 2;
            if (sortedDocument[m].compareTo(word) < 0) {
                startIndex = m + 1;
            } else if (sortedDocument[m].compareTo(word) > 0) {
                endIndex = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
