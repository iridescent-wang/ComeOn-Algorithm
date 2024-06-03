package eor;
// 逆序二进制的状态
//https://leetcode.cn/problems/reverse-bits/
public class ReverseBits {

    public int reverseBits(int n) {
        int res =0;
        for(int i=0;i<32;i++){
            res = res|(n&1)<<(31-i);
            n = n>>>1;
        }
        return res;
    }

    //分治
    public static int reverseBits2(int n) {
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = (n >>> 16) | (n << 16);
        return n;
    }
}
