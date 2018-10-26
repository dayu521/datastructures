package ss;

public class merge_sort {
    public static <T extends Comparable<? super T> >void run(T[] x){
        run(x,(T[]) new Comparable[x.length],0,x.length-1);
    }

    private static <T extends Comparable<? super T> >
    void run(T[] x, T[] objects, int i, int i1) {
        if(i<i1){
            int k=(i+i1)/2;
            run(x,objects,i,k);
            run(x,objects,k+1,i1);
            merge(x,objects,i,k,k+1,i1);
        }
    }

    private static <T extends Comparable<? super T> >
    void merge(T[] x, T[] objects, int a1, int a2, int b1, int b2) {
        int i=a1,j=b2;
        int temp=a1;
        while (a1<=a2&&b1<=b2){
            if(x[a1].compareTo(x[b1])<0)
                objects[temp++]=x[a1++];
            else
                objects[temp++]=x[b1++];
        }
        if(a1>a2)
            while (b1<=b2)
                objects[temp++]=x[b1++];
        else if(b1>b2)
            while (a1<=a2)
                objects[temp++]=x[a1++];
        for(;i<=j;i++)
            x[i]= objects[i];
    }
    public static void main(String[] x){
        tools.testsort(merge_sort::run,"归并排序");
    }
}
