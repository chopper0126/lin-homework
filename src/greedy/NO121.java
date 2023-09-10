package greedy;

//121.买股票最大收益
public class NO121 {
    //题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
    //
    //只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //kong
        if (n == 0) {
            return 0;
        }
        //初始化最小值、最大值
        int proMin = prices[0];
        int curProfit = 0;
        //依次比较，并更新
        for (int i = 1; i < n; i++) {
            if (proMin > prices[i]) {
                proMin = prices[i];
            } else {
                curProfit = Math.max(curProfit, prices[i] - proMin);
            }
        }
        return curProfit;
    }
}
