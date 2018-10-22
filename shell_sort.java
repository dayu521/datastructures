//希尔排序
@NotThreadSafe
public class shell_sort {
    public static <T extends Comparable<? super T> > void run(T[] a){
        //应该写到第二个for循环里头增加可读性，但我老有种
        //每次循环分配内存的花费高于只分配一次的操作。
        // 然而编译器应该会优化的
        T temp=null;
        for(int i=a.length/2;i>0;i=i/2)
            for (int j=i;j<a.length;j++){
                int k=j;
                temp=a[j];
                for(;k>=i&&temp.compareTo(a[k-i])<0;k=k-i){
                    a[k]=a[k-i];
                }
                a[k]=temp;
            }
    }
    public static void main(String[] x){
//        Integer[] m={15,5,32,654,65,32,45,66,32,10};
//        System.out.println(Arrays.toString(m));
//        run(m);
//        System.out.println(Arrays.toString(m));
        tools.testsort(shell_sort::run,"希尔排序");
    }
}
