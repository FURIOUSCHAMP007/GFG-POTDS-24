class Solution {
    static int splitArray(int[] arr, int N, int K) {
        int left = getMax(arr, N);
        int right = getSum(arr, N);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int partitions = countPartitions(arr, N, mid);

            if (partitions > K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int getMax(int[] arr, int N) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    static int getSum(int[] arr, int N) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    static int countPartitions(int[] arr, int N, int targetSum) {
        int partitions = 1;
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num > targetSum) {
                partitions++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return partitions;
    }

}