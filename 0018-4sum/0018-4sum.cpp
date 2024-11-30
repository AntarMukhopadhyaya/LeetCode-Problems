class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        //TC: O(n^3)
        //SC: O(no of quads)
        int n = nums.size();
        vector<vector<int>> ans;
        // Sort the array so that we get unique quad
        sort(nums.begin(),nums.end());
        for(int i =0; i < n; i++){
            //Check for duplicates
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j= i+1; j < n; j++){
                //Check for Duplicates
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                //Two Pointer start
                int k= j+1;
                int l = n-1;
                while(k < l){
                    long long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    // if sum == target then this is the quad
                    if(sum == target){
                        vector<int> temp = {nums[i] , nums[j] , nums[k] , nums[l]};
                        ans.push_back(temp);
                        k++;
                        l--;
                        //Check if k does not overlap l and skip duplicate for k
                        while(k < l && nums[k] == nums[k-1]) k++;
                        //Check if k does not overlap l and skip duplicate for l
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
};