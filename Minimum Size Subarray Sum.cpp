class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        if(nums[0] >= target)
            return 1;
       
        int ans = INT_MAX;
        int sum = 0;
        
        int i = 0;
        int j = 1;
        sum = nums[i];
        while(j<n && i<n)
        {
            sum += nums[j];
            if(sum >= target)
            {
                while(sum>=target){
                    
                  ans = min(ans,j-i+1);
                  sum -= nums[i];
                  i++;
                }
                
            }
            j++;
            
        }
        return ans==INT_MAX?0:ans;
        
    }
};
