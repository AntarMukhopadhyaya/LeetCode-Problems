class Solution {
public:
    int maxProduct(vector<int>& nums) {
        // The answer will lie on either suffix or prefix
        // when suffix == 0 make it 1
        // when prefix == 0 make it 1
        // prefix starts from start of the array
        // suffix starts from end of the array
        // the answer is the max of suffix and prefix
        
        int maxi = INT_MIN;
        int n = nums.size();
        int prefix = 1, suffix = 1;
        for(int i =0; i < n; i++){
            
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            maxi = max(maxi,max(prefix,suffix));
        }
        return maxi;
    }
};