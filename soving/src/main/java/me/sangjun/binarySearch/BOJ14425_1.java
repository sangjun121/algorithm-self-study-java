package me.sangjun.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * O(N*M) 시간 복잡도, 그냥 전체 리스트 비교를 통한 원소 찾기
 */
public class BOJ14425_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] countInput = br.readLine().split(" ");

        List<String> documentInput = new ArrayList<>();
        List<String> wordInput = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(countInput[0]); i++) {
            documentInput.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(countInput[1]); i++) {
            wordInput.add(br.readLine());
        }

        int count = 0;
        for (String word : wordInput) {
            if (documentInput.contains(word)) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
