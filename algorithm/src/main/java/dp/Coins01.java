package dp;

import javax.management.InstanceNotFoundException;

import static java.lang.Math.min;

public class Coins01 {

    //回溯
    public static int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private static int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
