package day05;
public class Easy_BuySellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5;
        System.out.println("Buy Sell Stock passed!");
    }
}