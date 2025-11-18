//   Method -----> 1
// class Solution {
//     public int numberOfSubarrays(int[] arr, int k) {
//        int i =0, j=0, a=0, b=0, n = arr.length , k2=0;
//        int count =0;
//        while(i<n && arr[i]%2==0) i++;
//        while(j<n && k2<k) if(arr[j++]%2!=0) k2++;
//        if(k2<k) return 0;
//        j--;
//        b =j+1;
//        while(b<n && arr[b]%2==0) b++;
//        b--;
//        while(b<n){ // sliding window
//           count += (i-a+1)* (b-j+1); // math
//           a= i+1;
//           i++;
//           while(i<n && arr[i]%2==0) i++;
//           j =b+1;
//           b= j+1;
//           while(b<n && arr[b]%2==0) b++;
//           b--;
//        }
//        return count;
//     }
// }
//           Method ------> 2

// class Solution {
//     public int numberofSubarrays(int []arr, int k) {
//         int n = arr.length, count=0;
//         for(int i=0;i<n;i++) arr[i] %= 2;
//         for(int i=1;i<n;i++) arr[i] += arr[i-1];
//         Map<Integer,Integer> map = new HashMap<>();
//         map.put(0, -1);
//         for(int i=0;i<n;i++){
//             if(!map.containsKey(arr[i])) map.put(arr[i],i);
//             int a =0;
//             if(map.containsKey(arr[i]-k)) a= map.get(arr[i]-k);
//             int b =0;
//             if(map.containsKey(arr[i]-k+1)) b = map.get(arr[i]-k+1);
//             if(arr[i]==k) count += (b-a+1);
//             if(arr[i]>k) count += (b-a);
        
//         }
//         return count;

//     }
//  }

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int oddCount = 0, count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // empty prefix

        for (int num : nums) {

            // convert to 0/1 for even/odd
            oddCount += (num % 2);

            // check if oddCount - k existed before
            if (map.containsKey(oddCount - k)) {
                count += map.get(oddCount - k);
            }

            // store current prefix sum frequency
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}
