package dsa.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {

    public static double getMaxValue(Item[] arr, int capacity) {
        Arrays.sort(arr, new Comparator<Item>() {

            @Override
            public int compare(Item it1, Item it2) {
                double r1 = new Double((double) it1.profit / (double) it1.weight);
                double r2 = new Double((double) it2.profit / (double) it2.weight);

                if (r2 > r1) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });

        double totalValue = 0d;

        for (Item it : arr) {

            int curWt = it.weight;
            int curVal = it.profit;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue = totalValue + curVal;
            } else {

                double fraction = (double) capacity / (double) curWt;
                capacity = (int) (capacity - (fraction * curWt));
                totalValue = totalValue + (fraction * curVal);
                break;
            }
        }

        return totalValue;
    }

    static class Item {
        int weight;
        int profit;

        public Item(int profit, int weight) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int capacity = 50;
        double maxValue = getMaxValue(arr, capacity);
        System.out.println(maxValue);
    }
}
