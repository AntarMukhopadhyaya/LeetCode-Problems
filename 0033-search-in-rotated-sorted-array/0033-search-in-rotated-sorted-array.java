class Solution {
    public int search(int[] nums, int target) {
        int low = 0,high = nums.length - 1;
        while(low <= high){
            // Calculate the mid
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            //Check whether the left part is sorted
            else if(nums[low] <= nums[mid]){
                // For an  element to belong in left sorted part.
                // low <= element <= mid
                if(nums[low] <= target &&  target <= nums[mid]){
                    // Dont need the right part
                    high = mid -1;
                }else {
                    // Dont need the left part
                    low = mid +1;
                }
            }else { // Check whether the right part is sorted or not
                // For an element to belong in right sorted part
                // element <= high and element >= mid
                if(target >= nums[mid] && target <= nums[high]){
                   // Dont need left part
                    low  = mid +1;
                }else {
                    // Dont need right part
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}