package backtracing;

import java.util.List;
import java.util.Scanner;

public class backTracingDemo {
    public static void main(String[] args) {
        //创建对象
        N077 n077 = new N077();
        //调用combine函数
        List<List<Integer>> combine = n077.combine(4, 2);
        System.out.println(combine);
        System.out.println("---------");
        //创建对象
        N0216 n0216 = new N0216();
        //
        List<List<Integer>> lists = n0216.combinationSum3(3, 7);
        System.out.println(lists);

        //创建对象
        NO17 no17 = new NO17();

        //调用letterCombinations函数
        List<String> list = no17.letterCombinations("23");
        System.out.println(list);
        System.out.println("-----------");

        //创建对象
        NO39 no39 = new NO39();

        //调用letterCombinations函数
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> listList = no39.combinationSum(candidates, 7);
        System.out.println(listList);
        System.out.println("------");

        //创建对象
        NO131 no131 = new NO131();
        String s = "aab";
        List<List<String>> partition = no131.partition(s);
        System.out.println(partition);
        System.out.println("-----");

        //
        NO491 no491 = new NO491();
        int[] nums = {1, 1, 2};
        List<List<Integer>> subsequences = no491.findSubsequences(nums);
        System.out.println(subsequences);
        System.out.println("-----");

        //全排列
        NO46 no46 = new NO46();
        List<List<Integer>> permute = no46.permute(nums);
        System.out.println(permute);
        System.out.println("-----");

        //47.全排列||
        NO47 no47 = new NO47();
        List<List<Integer>> permuteUnique = no47.permuteUnique(nums);
        System.out.println("全排列|| :" + permuteUnique);

        //temp
//        List<List<String>> tickets = new ArrayList<List<String>>();
//        tickets.add();
//        System.out.println(tickets.get(1).get(1));
        //N皇后
        NO51 no51 = new NO51();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int n = sc.nextInt();
//        int n = 4;
        List<List<String>> listList1 = no51.solveNQueens(n);
        System.out.println(n+"皇后："+listList1);
    }
}
