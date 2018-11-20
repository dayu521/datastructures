package ss;

//堆排序

public class heap_sort {

    public static <T extends Comparable<? super T> >void run(T[] x){
        //构建最大堆
        buildheap(x);
        //依次从堆中弹出最大值放在数组后面完成排序
        for (int i=x.length-1;i>0;i--){
            tools.swap(x,0,i);
            percolatedown(x, 0,i);
        }
    }

    private static < T extends Comparable<? super T> > void percolatedown(T[] x, int i, int l) {
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



    private static <T extends Comparable<? super T> >void buildheap(T[] x) {
        for(int i=x.length/2-1;i>=0;i--){
            percolatedown(x,i,x.length);
        }
    }
public static void main(String[] xx){
    tools.testyuanzhisort(heap_sort::run,"堆排序");
}

}
