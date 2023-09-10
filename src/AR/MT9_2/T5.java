package AR.MT9_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 彩虹糖的数量
        int[] candies = new int[n]; // 保存彩虹糖的颜色
        for (int i = 0; i < n; i++) {
            candies[i] = scanner.nextInt();
        }
        scanner.close();

        int maxHappyDays = findMaxHappyDays(candies);
        System.out.println(maxHappyDays);
    }

    private static int findMaxHappyDays(int[] candies) {
        int maxHappyDays = 0;
        Set<Integer> eaten = new HashSet<>();

        for (int i = 0; i < candies.length - 1; i++) {
            eaten.add(candies[i]); // 将当前彩虹糖的颜色添加到已吃过的集合

            for (int j = i + 1; j < candies.length; j++) {
                eaten.add(candies[j]); // 将下一颗彩虹糖的颜色添加到已吃过的集合

                // 如果已吃过的集合的大小等于已吃过的彩虹糖的组合数量，说明这是一个之前没吃过的组合
                if (eaten.size() == j - i + 1) {
                    maxHappyDays = Math.max(maxHappyDays, j - i + 1);
                }
            }

            eaten.clear(); // 清空已吃过的集合，为下一轮循环做准备
        }

        return maxHappyDays;
    }
}