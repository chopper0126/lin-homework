package AR.zhongxing.D919;


import java.util.Scanner;
        import java.util.ArrayList;
        import java.util.List;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 植物的个数
        List<int[]> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plants.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }

        System.out.println(survivingPlants(plants));
    }

    public static int survivingPlants(List<int[]> plants) {
        int count = 0;
        for (int i = 0; i < plants.size(); i++) {
            boolean isCovered = false;
            for (int j = 0; j < plants.size(); j++) {
                if (i != j && covers(plants.get(j), plants.get(i))) {
                    isCovered = true;
                    break;
                }
            }
            if (!isCovered) {
                count++;
            }
        }
        return count;
    }

    public static boolean covers(int[] a, int[] b) {
        return a[0] >= b[0] && a[1] <= b[1];
    }
}

