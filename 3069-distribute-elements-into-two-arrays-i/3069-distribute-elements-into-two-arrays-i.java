class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int[] res = new int [nums.length];
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2;i<nums.length;i++)
        {
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1))
            arr1.add(nums[i]);
            else
            arr2.add(nums[i]);
        }
        for(int i =0;i< arr1.size();i++)
        res[i]=arr1.get(i);

        for(int j=0;j< arr2.size();j++)
        res[j+arr1.size()] = arr2.get(j);

        return res;
    }
}