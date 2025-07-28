// Problem2
// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)


// Time Complexity : O(log(bigger array))
// Space Complexity : O(n) for list of result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// used binary serach on smaller array for finding the right partition.
// for each partition checked if last element of left is smalller than first of right of alternative arrays
//this logic works becuase median divies an array in two equal halves. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if arrays are empty
        if(nums1.length==0 && nums2.length==0) return 0.0;
        //we always want nums1 to be array with less elements than nums2
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n1=nums1.length;
        int n2=nums2.length;
        int low =0;
        int high = n1;
        //perform binary search on nums1 to find the right partitions.
        while(low<=high){
            int partX = low+ (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int l1= partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            int l2= partY ==0 ? Integer.MIN_VALUE : nums2[partY-1];
            int r1 = partX==n1? Integer.MAX_VALUE: nums1[partX];
            int r2= partY==n2? Integer.MAX_VALUE: nums2[partY];
            if(l1<=r2 && l2<=r1) {
                if((n1+n2)%2==0) return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.min(r1,r2);
            }
            else if(l1>r2) high=partX-1;
            else low=partX+1;
                
        }
        return 18.18;
    }
}