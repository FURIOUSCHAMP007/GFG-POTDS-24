class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        HashMap<Integer, Integer> remainderIndexMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        remainderIndexMap.put(0, -1); // Initialize the map with remainder 0 and index -1

        for (int i = 0; i < n; i++) {
            prefixSum += a[i];

            // Calculate the remainder of the prefix sum divided by k
            int remainder = ((prefixSum % k) + k) % k;

            // If the remainder is already in the map, update the maxLength
            if (remainderIndexMap.containsKey(remainder)) {
                int currentLength = i - remainderIndexMap.get(remainder);
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Store the remainder with its index
                remainderIndexMap.put(remainder, i);
            }
        }

        return maxLength;
    }
}
