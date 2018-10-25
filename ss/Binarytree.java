package ss;

//二叉查找树
//插入和删除操作有些费解，全是由于java对象”引用“使用起来像是引用，事实上和c++指针还更贴近，
//c++中代码采用引用的话代码容易理解
@NotThreadSafe
public class Binarytree<T extends Comparable<? super T>>{
    //基本操作
    public void insert(T data){
        root=insert(data,root);
    }

    public void delete(T data){
        root=delete(data,root);
    }

    public void print(){
        print(root);
        System.out.print("\n");
    }

    public boolean find(T data){
        return find(root,data);
    }

    public T findmin(){
        return findmin(root);
    }
    public Binarytree(){
        root=null;
        size=0;
    }
    //节点
    private static class Node<U> {

            public Node<U> left;
            public Node<U> right;
            public U data;

        public Node(Node<U> left, Node<U> right, U data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    //真正的树根
    private Node<T> root;
    //大小
    private int size;
    //递归插入，由于java对象引用按值传递，所以采用：
    //插入到一棵树中并返回插入的树的引用。这样避免传递父节点。
    private Node<T> insert(T data, Node<T> node) {
        if(node==null)
            return new Node<>(null,null,data);
        int result=data.compareTo(node.data);
        if(result>0)
            node.right=insert(data,node.right);
        else if (result<0)
            node.left=insert(data,node.left);
        else
            System.out.println("重复:"+data);
        return node;
    }
    //同insert，也是递归删除并返回新树的过程

    private Node<T> delete(T data, Node<T> node) {
        if(node==null)
            return node;
        int result=data.compareTo(node.data);
        if (result>0)
            node.right=delete(data,node.right);
        else if (result<0)
            node.left=delete(data,node.left);
        else {
            if (node.left!=null&&node.right!=null){
                //删除带有两个节点的节点，找到右子树最小值替换
                T x=findmin(node.right);
                node.right=delete(x,node.right);
                node.data=x;
            }
            else {
                Node<T> s=node.left==null?node.right:node.left;
                node=s;
            }
            System.out.println("已删除:"+data);
        }

        return node;
    }

    private T findmin(Node<T> node) {
        Node<T> temp = node;
        while (temp.left!=null)
            temp=temp.left;
        return temp.data;
    }

    private void print(Node<T> node) {
        if(node!=null){
            print(node.left);
            System.out.print(node.data+" ");
            print(node.right);
        }
    }
    private boolean find(Node<T> node, T data) {
        if(node==null)
            return false;
        int result=data.compareTo(node.data);
        if(result>0)
            return find(node.right,data);
        else if (result<0)
            return find(node.left,data);
        else
            return true;
    }
    public static void main(String[] s){
        //Binarytree<String> tree=new Binarytree<>();
        Binarytree<Integer> tree=new Binarytree<>();
        String[] strings={"sd","sda","ddss"};
        Integer[] ints={1,5,65,65,88,45,2,3,89,46,2,34,74,5,6};
        foreach(tree, ints);
        tree.print();
        tree.delete(2);
        tree.print();
    }

    public  static <TT extends Comparable<? super TT>> void foreach(Binarytree<TT> tree, TT[] arrys) {
        for(TT ss: arrys)
            tree.insert(ss);
    }
}
