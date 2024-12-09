class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            //Calculate the mid
            int mid = low + (high - low) / 2;
            // If search space is already sorted
            // then always nums[low] will be smaller
            if(nums[low] <= nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }
            // Check if left part is sorted
            if(nums[low] <= nums[mid]){
                // Get the minimum which is low as the array is sorted
                ans = Math.min(ans,nums[low]);
                // Eleminate the left part because we have gotten the minimum
                low = mid + 1;
            }else { // If left part is not sorted then right part is sorted
                // Get the minimum value which is mid as the array is sorted
                ans = Math.min(ans,nums[mid]);
                // Eliminate the right part because we have gotten the minimum
                high = mid -1;
            }
        }
        return ans;
        
    }
}