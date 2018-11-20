package ss;

public class AVLtree<T extends Comparable<? super T>> {
    public void insert(T x){
        root=insert(root,x);
    }
    public void remove(T x){
        root=remove(root,x);
    }
    public void print(){
        print(root);
    }
    public AVLtree(){
        root=null;
    }
    private static class Node<U>{
        public Node<U> left;
        public Node<U> right;
        public U item;
        public int height;
        public Node(U item){
            this.left=null;
            this.right=null;
            height=0;
            this.item=item;
        }
    }
    private Node<T> root;

    private Node<T> insert(Node<T> node, T x) {
        if(node==null)
            return new Node<>(x);
        int compareresult=x.compareTo(node.item);
        if(compareresult>0)
            node.right=insert(node.right,x);
        else if(compareresult<0)
            node.left=insert(node.left,x);
        else
            System.out.println("重复"+node.item);
        return balance(node);
    }
    private Node<T> remove(Node<T> node, T x) {
        if(node==null)
            return null;
        int compareresult=x.compareTo(node.item);
        if(compareresult>0)
            node.right=remove(node.right,x);
        else if(compareresult<0)
            node.left=remove(node.left,x);
        else
        {
            if(node.left!=null&&node.right!=null) {
                T min = findmin(node.right);
                node.item=min;
                remove(node.right,min);
            }
            else{
                node=node.left==null?node.right:node.left;
            }
        }
        return balance(node);
    }

    private Node<T> balance(Node<T> node) {
        if(node==null)
            return null;
        if(height(node.left)-height(node.right)>1)
            //等于可以把相等高度作为单旋转
            if(height(node.left.left)>=height(node.left.right))
                node=rotatewithleft(node);
            else
                node=doublerotatewithleft(node);
        else if(height(node.right)-height(node.left)>1)
            if(height(node.right.right)>=height(node.right.left))
                node=rotatewithright(node);
            else
                node=doublerotatewithright(node);

        int leftheight=height(node.left);
        int rightheight=height(node.right);
        node.height=leftheight>rightheight?leftheight+1:
                rightheight+1;
        return node;
    }
    private Node<T> doublerotatewithleft(Node<T> node) {
        node.left=rotatewithright(node.left);
        return rotatewithleft(node);
    }

    private Node<T> rotatewithleft(Node<T> node) {
        Node<T> tem=node.left;
        node.left=tem.right;
        tem.right=node;
        node.height=max(height(node.left),height(node.right))+1;
        tem.height=max(height(tem.left),height(tem.right))+1;
        return tem;
    }

    private Node<T> doublerotatewithright(Node<T> node) {
        node.right=rotatewithleft(node.right);
        return rotatewithright(node);
    }

    private Node<T> rotatewithright(Node<T> node) {
        Node<T> tem=node.right;
        node.right=tem.left;
        tem.left=node;
        node.height=max(height(node.left),height(node.right))+1;
        tem.height=max(height(tem.left),height(tem.right))+1;
        return tem;
    }

    private int max(int a,int b){
        return a>b?a:b;
    }

    private void print(Node<T> node) {
        if(node!=null){
            print(node.left);
            System.out.print(node.item+"("+node.height+")");
            print(node.right);
        }
    }

    private int height(Node<T> node){
        if(node!=null)
            return node.height;
        return -1;
    }
    private T findmin(Node<T> node){
        if(node==null)
            return null;
        while (node.left!=null)
            node=node.left;
        return node.item;
    }
    public static void main(String[] s){
        //Binarytree<String> tree=new Binarytree<>();
        AVLtree<Integer> tree=new AVLtree<>();
        String[] strings={"sd","sda","ddss"};
        Integer[] ints={1,5,65,65,88,45,2,3,89,46,2,34,74,5,6};
        foreach(tree, ints);
        tree.print();
//        tree.remove(2);
//        tree.print();
        //System.out.println(tree.houji(4));
    }

    public  static <TT extends Comparable<? super TT>> void foreach(AVLtree<TT> tree, TT[] arrys) {
        for(TT ss: arrys)
            tree.insert(ss);
    }
}
