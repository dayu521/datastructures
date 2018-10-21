import java.util.Arrays;

//测设使用
//减少重复代码
interface lol{
    <T extends Comparable<? super T>> void run(T[] x);
}
public class tools {
    public static void tests(lol x,String s){
        System.out.println(s);
        Integer[] m={15,5,32,654,65,32,45,66,32,10};
        System.out.println(Arrays.toString(m));
        x.run(m);
        System.out.println(Arrays.toString(m));
    }
}
