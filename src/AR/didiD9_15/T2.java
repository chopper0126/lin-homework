package AR.didiD9_15;


import java.util.*;

public class T2 {

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minBlackGrids(grid));
    }

    private static int minBlackGrids(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        dist[0][0] = grid[0][0];

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = point.x + dx[d];
                int ny = point.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny] > dist[point.x][point.y] + grid[nx][ny]) {
                        dist[nx][ny] = dist[point.x][point.y] + grid[nx][ny];
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
