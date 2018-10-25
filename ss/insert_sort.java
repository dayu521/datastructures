package ss;

public class insert_sort {
    //为快排使用
    public static <T extends Comparable<? super T> > void run(T[] a,int left,int right){
        T temp=null;
        int i,j;
        for( i=left+1;i<=right;i++){
            temp=a[i];
            for ( j=i;j>0&&temp.compareTo(a[j-1])<0;j--)
                a[j]=a[j-1];
            a[j]=temp;
        }

    }
    public static void main(String[] x){
        tools.testsort(insert_sort::run,"插入排序");
    }
    public static <T extends Comparable<? super T> > void run(T[] ts) {
        run(ts,0,ts.length-1);
    }
}
