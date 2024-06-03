package eor;

//https://leetcode.cn/problems/missing-number/description/
//丢失的数字，n个元素值属于[0,n]，找确实的哪个数
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int eorAll=0,eorHas = 0;
        for(int i=0;i<nums.length;i++){
            eorAll = eorAll^i;
            eorHas = eorHas^nums[i];
        }
        eorAll = eorAll^nums.length;
        return eorAll^eorHas;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(missingNumber(nums));//0
    }

}
