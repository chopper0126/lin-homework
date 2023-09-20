package qiuzhao.du.D9_12;


import java.util.Scanner;

/**
 * rob
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 假期的天数
        int[] works = new int[n]; // 每天能完成的作业数

        for (int i = 0; i < n; i++) {
            works[i] = scanner.nextInt();
        }
        int[] f = new int[n+2];//定义记忆数组
        for(int i = 0; i < n; i++){
            f[i + 2] = Math.max(f[i + 1],f[i] + works[i]);
        }

        System.out.println(f[n + 1]);
    }
}

