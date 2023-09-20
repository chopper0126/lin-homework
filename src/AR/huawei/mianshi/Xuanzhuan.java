package AR.huawei.mianshi;

import java.util.Arrays;

public class Xuanzhuan {
    public static void main(String[] args) {
        int[][] ints = Xuanzhuanshuzu1(new int[][]{{1,2,3,4},{2,3,4,5},{3,4,5,6}},3,4);
        System.out.println(Arrays.deepToString(ints));
    }
    //顺时针90旋转矩阵
    public static int[][] Xuanzhuanshuzu1(int arry1[][], int m, int n) {
        //m表示原数组的行，n表示原数组的列
        int arry2[][] = new int[n][m];
        int dst;
        dst = m - 1;//因为要从最后一列向前赋值
        for (int x = 0; x < m; x++, dst--) {
            for (int y = 0; y < n; y++) {
                arry2[y][dst] = arry1[x][y];
//在内循环中保持列不变，实现一列一列的赋值，同时也是从最后一列向前赋值
            }
        }
        return arry2;
    }

}
