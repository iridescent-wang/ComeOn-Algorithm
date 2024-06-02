package eor;


// https://leetcode.cn/problems/maximum-lcci/description/
//找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
public class Maximum {



    //x = a-b 如果x>0最高位为0，否则最高位为1
    //获取符号位就行了
    public static int maximum(int a, int b) {
        long x = (long)a-(long)b;
        int k  = (int) ((x>>>63)&1);
        return (1-k)*a+b*k;
    }

    public static void main(String[] args) {
        System.out.println(maximum(2147483647,-2147483648));
        System.out.println(maximum(1,2));
    }
}
