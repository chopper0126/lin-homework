package AR.MT;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        int k = sc.nextInt();

        int len = 0;
        for (int i = 0; i < k; i++) {
            len = ch.length;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (ch[j] == 'a'){
                    sb.append("bc");
                } else if (ch[j] == 'b') {
                    sb.append("ca");
                }else {
                    sb.append("ab");
                }
            }
            char[] newCh = sb.toString().toCharArray();
            ch = newCh;
        }

        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }

    }
}
