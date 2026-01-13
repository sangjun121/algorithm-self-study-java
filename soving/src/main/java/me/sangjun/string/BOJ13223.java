package me.sangjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ13223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] currentTimeIput = br.readLine().split(":");
        String[] executeTimeInput = br.readLine().split(":");
        int[] currentTime = new int[3];
        int[] executeTime = new int[3];
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            currentTime[i] = Integer.parseInt(currentTimeIput[i]);
            executeTime[i] = Integer.parseInt(executeTimeInput[i]);
        }

        // 초 계산
        if (executeTime[2] < currentTime[2]) {
            executeTime[1] -= 1;
            executeTime[2] += 60;
        }
        result[2] = executeTime[2] - currentTime[2];

        // 분 계산
        if (executeTime[1] < currentTime[1]) {
            executeTime[0] -= 1;
            executeTime[1] += 60;
        }
        result[1] = executeTime[1] - currentTime[1];

        // 시 계산
        if (executeTime[0] < currentTime[0]) {
            executeTime[0] += 24;
        }
        result[0] = executeTime[0] - currentTime[0];

        parseZero(result);
        String output = new String(parseTime(result[0]) + ":" + parseTime(result[1]) + ":" + parseTime(result[2]));

        bw.write(output);
        bw.flush();
        bw.close();
    }

    private static String parseTime(int target){
        if (0 <= target && target <= 9) {
            return "0" + target;
        }
        return Integer.toString(target);
    }

    private static void parseZero(int[] target){
        if (target[0] == 0 && target[1] == 0 && target[2] == 0) {
            target[0] = 24;
        }
    }
}
