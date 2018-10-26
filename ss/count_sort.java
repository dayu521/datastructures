package ss;

import java.util.Arrays;

// n为 0<n<K 的整数
public class count_sort {
    public static void run(int[] x){
        run(x,findmax(x));
    }

    private static void run(int[] x, int k) {
        int[] A1=new int[k+1];
        int[] out=new int[x.length];
        for(int i=0;i<x.length;i++)
            A1[x[i]]++;
        for (int i=1;i<A1.length;i++)
            A1[i]=A1[i]+A1[i-1];
        for (int i=x.length-1;i>=0;i--){
            //实际上要向前偏移一位
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
