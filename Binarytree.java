public class Binarytree<T extends Comparable<? super T>>{
    //基本操作
    public Boolean insert(T data){
        return insert(data,head);
    }

    public Boolean delete(T data){
        return delete(data,head);
    }

    public void print(){
        print(head);
    }

    public T find(){
        return find(head);
    }

    public Binarytree(){
        head.right=root=null;
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
    //右节点指向树根的头节点
    private Node<T> head;
    //真正的树根
    private Node<T> root;
    //大小
    private int size;

    private Boolean insert(T data, Node<T> node) {
        if(node.right==null) {
            node = new Node<T>(null, null, data);
            return true;
        }
        else if (data.compareTo(node.data)>0){
            return insert(data,node.right);
        }
        else if (data.compareTo(node.data)<0){
            return insert(data,node.left);
        }
        else
            return false;

    }
    private Boolean delete(T data, Node<T> node) {

    }
    private void print(Node<T> node) {
    }
    private T find(Node<T> node) {
    }
}
