package ss;

public class quick_sort {
    public static <T extends Comparable<? super T> >void run(T[] x){
        run(x,0,x.length-1);
    }

    private static <T extends Comparable<? super T>> void run(T[] x, int i, int i1) {
        if (i1-i>10) {
            T temp=sanzhongzhi(x,i,i1);
            int left = i + 1;
            int right = i1-2;
            for (; ; ) {
                while (x[left].compareTo(temp) < 0)
                    left++;
                while (x[right].compareTo(temp) > 0)
                    right--;
                if (left > right)
                    break;
                else
                    tools.swap(x, left, right);
            }
            tools.swap(x, left, right-1);
            run(x, i, left-1);
            run(x, left + 1, i1);
        }
        else
            insert_sort.run(x,i,i1);

    }
    private static <T extends Comparable<? super T>> T sanzhongzhi(T[] x,int begin,int end){
        int mid=(begin+end)/2;
        int left=begin,right=end;
        if (x[left].compareTo(x[right])>0)
            tools.swap(x,left,right);
        if (x[mid].compareTo(x[right])>0)
            tools.swap(x,mid,right);
        if(x[left].compareTo(x[mid])>0)
            tools.swap(x,left,mid);
        tools.swap(x,mid,right-1);
        return x[mid];
    }

    public static void main(String[] x){
        tools.testyuanzhisort(quick_sort::run,"快排");
    }
}
