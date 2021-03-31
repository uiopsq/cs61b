public class LinkedListDeque<T>{
    private int size;
    private Node sentinel;
    private class Node{
        T item;
        Node prev;
        Node next;

        Node(T i,Node p,Node n){
            item=i;
            prev=p;
            next=n;
        }
    }
    public LinkedListDeque(T i){
        sentinel=new Node(null,null,null);
        sentinel.next=new Node(i,sentinel,sentinel);
        sentinel.prev=sentinel.next;
        size=1;
    }

    public LinkedListDeque(){
        sentinel=new Node(null,sentinel,sentinel);
        size=0;
    }

    public T get(int index){
        Node p=sentinel;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return p.item;
    }

    public void addLast(T item){
        if (isEmpty()){
            Node p=new Node(item,sentinel,sentinel);
            sentinel.next=p;
            sentinel.prev=p;
        }
        else{
            sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
            size = size + 1;
            sentinel.prev=sentinel.prev.next;
        }
    }
    public void addFirst(T item){
        if (isEmpty()){
            Node p=new Node(item,sentinel,sentinel);
            sentinel.next=p;
            sentinel.prev=p;
        }
        else  {
            sentinel.next = new Node(item, sentinel, sentinel.next);
        }

    }

    public T removeLast(){
        if(isEmpty()){return null;}
        else{
        T t=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size=size-1;
        return t;
        }
    }

    public T removeFirst(){
        if(isEmpty()){return null;}
        else {
        T t=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        return t;
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (sentinel.next==sentinel){return true;}
        else{
            return false;
        }
    }
    public void printDeque(){
        Node q=sentinel.next;
        while(q!=sentinel){
            System.out.print(q.item +" ");
            q=q.next;
        }
    }

    public T getRecursive(int index){
        if (isEmpty()){return null;}
        else{
            Node p=sentinel;
            return getRecursive(index,p);
        }
    }

    private T getRecursive(int index,Node p){
        if (index==0){
            return p.next.item;
        }
        else{
            return getRecursive(index-1,p.next);
        }
    }
}