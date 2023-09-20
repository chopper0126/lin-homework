package AR.MT9_16;


import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), H = sc.nextInt(), A = sc.nextInt();

        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i] = new Monster();
        }
        for (int i = 0; i < n; i++) {
            monsters[i].health = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            monsters[i].attack = sc.nextInt();
        }

        Arrays.sort(monsters, (a, b) -> Integer.compare(Math.max(a.health, a.attack), Math.max(b.health, b.attack)));

        int count = 0;
        for (Monster monster : monsters) {
            if (monster.health < H && monster.attack < A) {
                count++;
                H = monster.health;
                A = monster.attack;
            }
        }

        System.out.println(count);
    }

    static class Monster {
        int health;
        int attack;
    }
}
