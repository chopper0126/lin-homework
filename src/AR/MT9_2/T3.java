package AR.MT9_2;


import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组的大小
        int[] arr = new int[n]; // 数组
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // 输入数组元素
        }
        scanner.close();

        int firstElement = arr[0]; // 第一个元素
        int maxElement = firstElement; // 最大元素
        int operations = 0; // 操作次数

        // 找到数组中的最大元素
        for (int i = 1; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        // 计算每个元素与最大元素的差值，需要的操作次数即为差值的二进制表示中1的个数
        for (int i = 0; i < n; i++) {
            int diff = maxElement - arr[i];
            operations += countSetBits(diff);
        }

        System.out.println(operations);
    }

    // 计算一个整数的二进制表示中1的个数
    private static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
