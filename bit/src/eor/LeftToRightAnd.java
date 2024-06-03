package eor;
// 给你两个整数 left 和 right ，表示区间 [left, right]
// 返回此区间内所有数字 & 的结果
// 包含 left 、right 端点
// https://leetcode.cn/problems/bitwise-and-of-numbers-range/
public class LeftToRightAnd {
    public static int rangeBitwiseAnd(int left, int right) {
        //不断删除最右侧的1,求 & 的结果只会保留二进制高位的公共前缀
        // 1111
        // 1011
        while (left < right) {
            right -= right & -right;
        }
        return right;
    }
}
