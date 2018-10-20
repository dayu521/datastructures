import java.util.Arrays;

//
public class heap_sort {

    public static <T extends Comparable<? super T> >void run(T[] x){
        //构建最大堆
        buildheap(x);
        //依次从堆中弹出最大值放在数组后面完成排序
        for (int i=x.length-1;i>0;i--){
            swap(x,0,i);
            perlatedown(x, 0,i);
        }
    }

    private static < T extends Comparable<? super T> > void perlatedown(T[] x, int i,int l) {
        T temp=x[i];
        int parent,child;

        for(parent=i;parent*2+1<l;parent=child){
           child=2*parent+1;
           if(child+1<l&&x[child].compareTo(x[child+1])<0)
               child++;
           if(temp.compareTo(x[child])>0)
               break;
           else
                x[parent]=x[child];
        }
        x[parent]=temp;
    }

    private static <T> void swap(T[] x, int i, int j) {
        T tem=x[i];
        x[i]=x[j];
        x[j]=tem;
    }

    private static <T extends Comparable<? super T> >void buildheap(T[] x) {
        for(int i=x.length/2-1;i>=0;i--){
            perlatedown(x,i,x.length);
        }
    }
public static void main(String[] xx){
        Integer[] m={15,5,32,654,65,32,45,66,32,10};
        System.out.println(Arrays.toString(m));
        run(m);
        System.out.println(Arrays.toString(m));
}

}
