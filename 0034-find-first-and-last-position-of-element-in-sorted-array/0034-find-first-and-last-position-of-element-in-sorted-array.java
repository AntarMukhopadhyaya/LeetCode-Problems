class Solution {
    public static int findFirst(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
            
        }
        return first;
    }
    public static int findLast(int[] nums, int target){
        int low = 0, high = nums.length -1 ;
        int last = -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid +1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = Solution.findFirst(nums,target);
        if(first == -1){
            return new int[] {-1,-1};
        }else {
            int last = Solution.findLast(nums,target);
            return new int[]{first,last};
        }
        
        
    }
}