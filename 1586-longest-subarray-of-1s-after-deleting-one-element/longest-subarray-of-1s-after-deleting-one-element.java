class Solution {
    public int longestSubarray(int[] arr) {
       int n= arr.length, i =0, j = 0;

       int z =0;
       for(int ele : arr){
         if(ele==0) z++ ;
       } 
       if(z==0) return n-1;  // i am removing a '1'

       int zeroes= 0, maxLen =0;
       while(i<n && arr[i]==0) i++; // move 'i' to 1st '1'
       if(i==n) return 0;
       j=i;
       while(j<n){
          if(arr[j]==1) j++;
          else{ // arr[j]==0
            if(zeroes==0){
               j++;
               zeroes++;
            }
            else{ // zeroes ==1
                int len = j-i-1;
                maxLen = Math.max(maxLen,len);
                j++;
                while(i<n && arr[i]==1) i++;
                i++;
            }
        }
       }
       if(zeroes==0) return j-i; // 0 1 1 is diff from 1 1
       int len = j-i-1;
       maxLen = Math.max(maxLen,len);
       return maxLen;
    }
}