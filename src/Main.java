import struct.ListNode;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line0 = in.nextLine(); // 5 3
        String[] s = line0.split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);

        String[][] martix = new String[x][y];
        for (int i = 0; i < x; i++) {
            String linei = in.nextLine();
            martix[i] = linei.split(" ");
        }
        String lastLine = in.nextLine();
        String[] vars = lastLine.split(":");
        String[] start = vars[0].split("");
        String[] end = vars[1].split("");

        int colStart = (int) (start[0].toCharArray()[0]) - 65;
        int rowStart = Integer.parseInt(start[1]); // 2

        int colEnd = (int) (end[0].toCharArray()[0]) - 65;
        int rowEnd = Integer.parseInt(end[1]);
        int sum = 0;
        for (int i = colStart; i <= colEnd; i++) {
            for (int j = rowStart - 1; j <= rowEnd - 1; j++) {
                if (j >= martix.length || i >= martix[0].length) {
                    continue;
                }
                String num = martix[j][i];
                if (num.startsWith("=")) {
                    // 是一个公式,计算公式的值 如 A1+C1
                    sum += 0;
                } else {
                    sum += Integer.parseInt(num);
                }
            }
        }
        System.out.println(sum);
    }

    private static int getNumber(String[][] martix, String pos) {
        String[] vars = pos.split("");
        int col = (int) (vars[0].toCharArray()[0]) - 65;
        int row = Integer.parseInt(vars[1]);
        String num = martix[row][col];
        return Integer.parseInt(num);
    }
}