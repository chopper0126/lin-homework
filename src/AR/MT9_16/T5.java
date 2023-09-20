package AR.MT9_16;


import java.util.*;

public class T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        List<Edge> edges = new ArrayList<>();
        List<Edge> resultEdges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt(), p = sc.nextInt();
            Edge edge = new Edge(u, v, w, i + 1);
            if (p == 1) {
                union(parent, u, v);
                resultEdges.add(edge);
            } else {
                edges.add(edge);
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.w));

        for (Edge edge : edges) {
            int uRoot = find(parent, edge.u), vRoot = find(parent, edge.v);
            if (uRoot != vRoot) {
                resultEdges.add(edge);
                union(parent, edge.u, edge.v);
            }
        }

        Set<Integer> connectedCities = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            connectedCities.add(find(parent, i));
        }

        if (connectedCities.size() > 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(resultEdges.size());
        for (Edge edge : resultEdges) {
            System.out.print(edge.index + " ");
        }
    }

    public static int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x), rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    static class Edge {
        int u, v, w, index;
        Edge(int u, int v, int w, int index) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.index = index;
        }
    }
}

