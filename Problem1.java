//  Problem1 
// Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// Time Complexity : O(nlog(n)+logn+logm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//sorted the array
//iterated over smaller array and for every element did binary serach to find first occurance
//of elment on larger array. if found made the range for upcoming bianry search as occurance +1-last element of
//larger array

// can do using hashmap and sort+two pointers as well.

//hashmap
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if(nums1.length>nums2.length) return intersect(nums2,nums1);
//         int n1= nums1.length;
//         int n2= nums2.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num: nums1){
//             map.put(num,map.getOrDefault(num, 0)+1);
//         }
//         List<Integer> intermediate = new ArrayList<>();
//         for(int num: nums2){
//             if(map.get(num)==null) continue;
//             int found =map.get(num);
//             if(found>1) map.put(num, found-1);
//             else map.remove(num);
//             intermediate.add(num);
//         }
//         int[] result= new int[ intermediate.size()];
//         int i=0;
//         for(int num: intermediate){
//             result[i++]=num;
//         }
//         return result;
//     }
// }

//sort+2 pointer
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if(nums1.length>nums2.length) return intersect(nums2,nums1);
//         int n1= nums1.length;
//         int n2= nums2.length;
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int p1=0;
//         int p2=0;
//         List<Integer> intermediate = new ArrayList<>();
//         while(p1<n1 && p2<n2){
//             if(nums1[p1]==nums2[p2]) {
//                 intermediate.add(nums1[p1]);
//                 p1++;
//                 p2++;
//             }
//             else if(nums1[p1]>nums2[p2]) p2++;
//             else p1++;
//         }
//         int[] result= new int[ intermediate.size()];
//         int i=0;
//         for(int num: intermediate){
//             result[i++]=num;
//         }
//         return result;
//     }
// }

//sort+ binary search of bigger array

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        int n1= nums1.length;
        int n2= nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0;
        int high=n2-1;
        List<Integer> intermediate = new ArrayList<>();
        for(int num: nums1){
            int index=binarySearch(low, high, nums2, num);
            if(index!=-1){
                intermediate.add(num);
                low=index+1;
            }
        }
        int[] result= new int[ intermediate.size()];
        int i=0;
        for(int num: intermediate){
            result[i++]=num;
        }
        return result;
    }
    private int binarySearch(int low, int high, int[] arr, int target){
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(arr[mid]==target){
                if(mid==low || arr[mid]>arr[mid-1]) return mid;
                else high=mid-1;
            }
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}
