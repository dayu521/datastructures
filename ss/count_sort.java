package ss;

import java.util.Arrays;

// n为 0<n<K 的整数
public class count_sort {
    public static void run(int[] x){
        run(x,findmax(x));
    }

    private static void run(int[] x, int k) {
        //0也算一位，所以加上1
        int[] A1=new int[k+1];
        int[] out=new int[x.length];
        for(int i=0;i<x.length;i++)
            A1[x[i]]++;
        for (int i=1;i<A1.length;i++)
            A1[i]=A1[i]+A1[i-1];
        for (int i=x.length-1;i>=0;i--){
            //实际上要向前偏移一位
            //这里有个小坑，假设前面有k-1,下一位理应该放在k上，但数组是包括0,所以0到k-1一共
            //k位，k应该放在k-1，即A1[x[i]]-1
            out[A1[x[i]]-1]=x[i];
            A1[x[i]]--;
        }
        System.out.println(Arrays.toString(out));
    }

    private static int findmax(int[] x) {
        Integer value=x[0];
        for(int i=1;i<x.length;i++)
            if(value.compareTo(x[i])<0)
                value=x[i];
        return value;
    }
    public static void main(String[] x) {
        run(new int[]{5, 6, 3, 7, 9,8,6,2,4,3,8,6,5,1,3,4});
    }
}
