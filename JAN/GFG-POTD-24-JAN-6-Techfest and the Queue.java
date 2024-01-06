//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    public static long sumOfPowers(long a, long b) {
        if (b == 1) {
            if (a == 1) {
                return 0;
            }
            a++;
        }

        int max = (int) b + 1;
        int[] primeFactors = new int[max];
        Arrays.fill(primeFactors, -1);

        for (int i = 2; i <= b; i++) {
            if (primeFactors[i] == -1) {
                primeFactors[i] = i;
                for (long j = (long) i * i; j <= b; j += i) {
                    if (primeFactors[(int) j] == -1) {
                        primeFactors[(int) j] = i;
                    }
                }
            }
        }

        long answer = 0;
        for (long i = a; i <= b; i++) {
            long x = i;
            while (x != 1) {
                x /= primeFactors[(int) x];
                answer++;
            }
        }

        return answer;
    }
}
       
