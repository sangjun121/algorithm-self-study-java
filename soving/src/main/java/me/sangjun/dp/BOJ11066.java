package me.sangjun.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] input = new int[T][501];

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            input[i][0] = K;
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= K; j++) {
                input[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        for (int i = 0; i < T; i++) {
            int result = getMinValue(input[i]);
            String resultString = String.valueOf(result);
            bw.write(resultString + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static int getMinValue(int[] valueArr) {
        int size = valueArr[0];
        int[][] dy = new int[size + 1][size + 1];
        int[][] sum = getSum(valueArr);

        //init
        for (int i = 1; i <= size; i++) {
            dy[i][i] = 0;
        }

        int startJ = 2;
        int i = 1;
        int j = 2;

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                int value = dy[i][k] + dy[k + 1][j] + sum[i][j];
                if (value <= min) {
                    min = value;
                }
            }
            dy[i][j] = min;

            // 대각선 순회
            i++;
            j++;
            if (j == size + 1 && i == 2) {
                return dy[1][size];
            }

            if (j == size + 1) {
                i = 1;
                startJ += 1;
                j = startJ;
            }
        }
    }

    /**
     * @Deprecated O(N ^ 3)의 시간 복잡도 소요. 아래 Prefix Sum 기법 사용 추천
     */
    private static int[][] getSum(int[] valueArr) {
        int size = valueArr[0];
        int[][] sums = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += valueArr[k];
                }
                sums[i][j] = sum;
            }
        }
        return sums;
    }

    /**
     * @Deprecated 대각선 순서(왼쪽 위에서 아래)로 탐색 2중 for문 접근법 - 각 행과 열의 i와 j를 2중 for문으로 사용하지 않고, i와 len를 기반으로 2중 for문을 구성하는 방식.
     * 구간의 길이 len은 j-i로 구성된다.
     *
     * <br>
     * 정석 코드는 위의 Readme에서 확인.
     * @see <a href="https://github.com/sangjun121/algorithm-self-study-java/tree/main/study/array">Readme</a>
     * 에서 확인
     */
    private static void findByDiagonalSeq() {
        int[][] arr = new int[4][4];
        int k = 4 - 1; //길이의 최대는 4

        for (int len = 0; len <= k; len++) {
            for (int i = 1; i <= k + 1 - len; i++) {
                int j = i + len;
                // arr[i][j] 처리
            }
        }
    }

    /**
     * @Deprecated 단지 미사용인 함수, 위의 getSum보다 효율적이다. Prefix Sum(구간합) 기법, 이차원 배열이므로 O(N^2)의 시간 복잡도 소요.
     */
    private static int[][] getPrefixSum(int[] valueArr) {
        int size = valueArr[0];
        int[][] sum = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            sum[i][1] = valueArr[i];
            for (int j = i + 1; j <= size; j++) {
                sum[i][j] = sum[i][j - 1] + valueArr[j];
            }
        }

        return sum;
    }
}
