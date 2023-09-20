package AR.MT9_16;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i =0 ;i < n;i ++){
            res[i] = sc.nextInt();
        }
        System.out.println(f(n,res));
    }
    private static int f(int n,int[] res){
        int score = 0;
        int bonus = 0;
        for(int i= 0;i < n;i++){
            if(res[i] == 1){
                score +=1;
                if(i > 0 && res[i-1] == 1){
                    score += 1;
                }

            }
        }
        return score;
    }
}