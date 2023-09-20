package AR.MT9_16;


import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class T4 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int maxM = 0;
            for (int bit = 30; bit >= 0; bit--) {
                int mask = (1 << bit);
                int count = 0;

                for (int i = 0; i < n; i++) {
                    if ((arr[i] & mask) > 0) {
                        count++;
                    }
                }

                if (count >= 2) {
                    maxM = bit;
                    break;
                }
            }

            System.out.println(maxM);
        }
    }

