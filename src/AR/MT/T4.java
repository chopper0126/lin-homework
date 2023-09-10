package AR.MT;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[n];

        int avg = m / n;
        res[0] = 1;
        for(int i = 1;i < n;i++){
            if(i <= avg){
                res[i] = res[i - 1] + i;
            }else if(m - res[i - 1] >= i){
                res[i] = res[i - 1] +i;
            }else{
                res[i] = res[i - 1] +1;
            }
        }
        for(int r : res){
            System.out.print(r + " ");
        }
    }
}