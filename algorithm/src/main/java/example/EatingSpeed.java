package example;

public class EatingSpeed {
    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n :
                piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }
    public static int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }
    public static int getMax(int[] piles) {
        int max = 0;
        for (int n :
                piles) {
            max = Math.max(n, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
