class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low  + (high - low) / 2;
            if(nums[mid] == target) return true;
            // Handle the Edge Case when duplicates occur
            // if duplicates occur just increase low by 1 and high by -1
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                high = high - 1;
                low  = low + 1;
                continue;
            }
            // Check if left half is sorted
            if(nums[mid] >= nums[low]){
                // check if element lies in this left half
                if(nums[low] <= target && target <= nums[mid]){
                    // if yes trim the right half
                    high = mid - 1;
                }else {
                    // if no trim the left half
                    low = mid + 1;
                }
            }
            //Check if right half is sorted
            if(nums[mid] <= nums[high]){
                // Check if element lies in this right half
                if(nums[mid] <= target && target <= nums[high]){
                    // if yes trim the left half
                    low = mid +1;
                }else {
                    // if not trim the right half
                    high = mid -1;
                }
            }
        }
        return false;
    }
}