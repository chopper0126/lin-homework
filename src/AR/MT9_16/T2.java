package AR.MT9_16;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        double res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        res = Math.ceil(res);
        if((int)(11-res) < 0) {
            System.out.println(0);
            return;
        }
        if(res == 0) {
            System.out.println(10);
            return;
        }
        System.out.println((int)(11 - res));
    }
}
