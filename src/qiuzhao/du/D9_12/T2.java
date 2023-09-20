package qiuzhao.du.D9_12;


import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 宝石数量
        int k = scanner.nextInt(); // 每带回3颗宝石快乐值的增加量
        int[] a = new int[n]; // 宝石的美丽值

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a); // 对宝石的美丽值进行排序

        long maxHappiness = 0; // 最大快乐值
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > 0) {
                // 如果宝石是正数，直接带回家并增加快乐值
                maxHappiness += a[i];
                cnt++;
            } else if (i >= 2 && a[i] + a[i - 1] + a[i - 2] + k >= 0) {
                // 如果宝石是负数，且能通过额外加分k转为正数，就带回家并增加快乐值
                maxHappiness += a[i] + a[i - 1] + a[i - 2] ;
                i   -= 2; // 跳过另外2颗宝石
                cnt += 3;
            }else {
                break;
            }
            if (cnt > 2){
                maxHappiness += k;
                cnt = 0;
            }
        }
        System.out.println(maxHappiness);
    }
}
