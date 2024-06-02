package eor;

public class Swap {
    public static void main(String[] args) {
        int a = -2323;
        int b = 10;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

        int[] arr = { 3, 3 };
        swap(arr, 0, 1);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        swap(arr, 0, 0);
        System.out.println(arr[0]);
    }

    // 当i!=j，没问题，会完成交换功能
    // 当i==j，会出错 因为arr[i] = arr[i] ^ arr[j]=0;
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
