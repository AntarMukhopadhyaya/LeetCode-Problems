import math
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
       
        count1 = count2 = 0
        ele1 = ele2 = -math.inf
        # applying the extended Boyer Moore's voting algo
        for i in range(n):
            if count1 == 0 and nums[i] != ele2:
                count1 = 1
                ele1 = nums[i]
            elif count2 == 0 and nums[i] != ele1:
                count2 =1
                ele2 = nums[i]
            elif nums[i] == ele1:
                count1 += 1
            elif nums[i] == ele2:
                count2 += 1
            else:
                count1  -= 1
                count2 -= 1
        count1 = count2 = 0
        #Manually check if the sotred elements are majority elements or not
        for i in range(n):
            if nums[i] == ele1:
                count1 += 1
            if nums[i] == ele2:
                count2 += 1
        ans = []
        mini = int(n/3)+1
        if count1 >= mini:
            ans.append(ele1)
        if count2 >= mini:
            ans.append(ele2)
        ans.sort()
        return ans
        