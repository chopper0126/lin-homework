package AR.JD.JD8_19;

import java.util.Scanner;

public class JD819_T1 {
    public static void main(String[] args) {
        //遍历

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            char[][] temp = new char[3][3];
            for (int j = 0; j < 3; j++) {
                String line = sc.next();
                for (int k = 0; k < 3; k++) {
                    temp[j][k] = line.charAt(k);
                }
            }
            boolean redWin = false;
            boolean pinkWin = false;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    //判断当前棋子是否被夹住
                    if (j == 1){
                        if (temp[j][k] != temp[j-1][k] && temp[j-1][k] == temp[j+1][k] && temp[j-1][k] != '.'){
                            if (temp[j][k] == 'o'){
                                redWin = true;
                            }else {
                                pinkWin = true;
                            }
                        }
                    }

                    if (k == 1){
                        if (temp[j][k] != temp[j][k-1] && temp[j][k-1] == temp[j][k+1] && temp[j][k-1] != '.'){
                            if (temp[j][k] == 'o'){
                                redWin = true;
                            }else {
                                pinkWin = true;
                            }
                        }
                    }
                }

            }
            //讨论结果
            if (redWin == pinkWin){
                sb.append("draw");
                System.out.println("draw");
            }else if (redWin == true && pinkWin == false){
                sb.append("kou");
                System.out.println("kou");
            }else {
                sb.append("yukari");
                System.out.println("yukari");
            }


        }

    }
}
