package AR.JD.JD8_26;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String HUMAN = "human";
        String MONSTER = "monster";

        String[][] renwu = new String[n][2];
        String[] isAlive = new String[n];
        for (int i = 0; i < n; i++) {
            renwu[i][0] = sc.next();
            renwu[i][1] = sc.next();

            isAlive[i] = "Y";
        }
        int[][] zubie = new int[m][2];

        String[][] isFight = new String[m][2];
        for (int i = 0; i < m; i++) {
            zubie[i][0] = sc.nextInt();
            zubie[i][1] = sc.nextInt();

            isFight[i][0] = sc.next();
            isFight[i][1] = sc.next();

        }
        for (int i = 0; i < m; i++) {
            String first = isFight[i][0];
            int u = zubie[i][0] - 1;
            int v = zubie[i][1] - 1;
            String uID = renwu[u][0];
            String vID = renwu[v][0];

            int uForce = Integer.parseInt(renwu[u][1]);
            int vForce = Integer.parseInt(renwu[v][1]);

            if("Y".equals(first) && "Y".equals(isAlive[u])){
                if(!uID.equals(vID)){
                    if (MONSTER.equals(vID)){
                        if (uForce == vForce){
                            isAlive[v] = "N";
                            isAlive[u] = "N";
                            break;
                        }
                        int res = vForce - uForce > 0 ? u : v;
                        isAlive[res] = "N";
                    }else if (vForce - uForce > 0){
                        isAlive[u] = "N";
                    }
                }
            }
            String second = isFight[i][1];
            if("Y".equals(second) && "Y".equals(isAlive[v])){
                if(!vID.equals(uID)){
                    if (MONSTER.equals(uID)){
                        if (uForce == vForce){
                            isAlive[v] = "N";
                            isAlive[u] = "N";
                            break;
                        }
                        int res = vForce - uForce > 0 ? u : v;
                        isAlive[res] = "N";
                    }else if (uForce - vForce > 0){
                        isAlive[u] = "N";
                    }

                }


            }

        }
        Arrays.stream(isAlive).forEach(System.out::print);
    }
}
