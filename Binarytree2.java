public class Binarytree2<T extends Comparable<? super T>>{
    //基本操作
    public void insert(T data){
        root=insert(data,root);
    }

    public void delete(T data){
        root=delete(data,root);
    }

    public void print(){
        print(root);
    }

    public T find(T data){
        return find(root,data);
    }

    public T findmin(){
        return findmin(root);
    }
    public Binarytree2(){
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
    //
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
                T x=findmin(node.right);
                node.right=delete(x,node.right);
                node.data=x;
            }
            else {
                Node<T> s=node.left==null?node.right:node.left;
                node=s;
            }
        }
        return node;
    }

    private T findmin(Node<T> node) {
    }

    private void print(Node<T> node) {
    }
    private T find(Node<T> node,T data) {
    }
}
