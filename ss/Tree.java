package ss;

public interface Tree<T extends Comparable<? super T>> {
    private static void waring(){
        System.out.println("请实现");
    }
     default void insert(T x){waring();}
     default void remove(T x){waring();}
     default void print(){waring();}
}
