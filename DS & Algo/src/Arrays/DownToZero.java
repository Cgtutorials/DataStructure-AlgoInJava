package Arrays;

import java.util.Scanner;

public class DownToZero {
    static final int LIMIT = 1_000_000;
    static int[] solutions = buildSolutions();

    public static void main(String[] args) {
        System.out.println(DownToZero.solve(111111));
    }

    static int[] buildSolutions() {
        int[] solutions = new int[LIMIT + 1];
        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = solutions[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    solutions[i] = Math.min(solutions[i], solutions[i / j] + 1);
                }
            }
        }
        return solutions;
    }

    static int solve(int N) {
        return solutions[N];
    }
}
