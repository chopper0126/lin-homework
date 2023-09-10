package AR.MT9_2;


import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        boolean found = false;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            findMeituan(matrix, i, 0, sb);
            if (sb.toString().contains("meituan")) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "YES" : "NO");
    }

    private static void findMeituan(char[][] matrix, int row, int col, StringBuilder sb) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return;
        }

        sb.append(matrix[row][col]);
        if (sb.length() > 7) {
            sb.deleteCharAt(0);
        }

        findMeituan(matrix, row, col + 1, sb);
        findMeituan(matrix, row + 1, col, sb);
    }
}
