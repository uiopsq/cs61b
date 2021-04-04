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
//    public LinkedListDeque(T i){
//        sentinel=new Node(null,sentinel,sentinel);
//        sentinel.next=new Node(i,sentinel,sentinel);
//        sentinel.prev=sentinel.next;
//        size=1;
//    }

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
            sentinel.prev=sentinel.prev.next;
        }
        size+=1;
    }
    public void addFirst(T item){
        if (isEmpty()){
            Node p=new Node(item,sentinel,sentinel);
            sentinel.next=p;
            sentinel.prev=p;
        }
        else  {
            Node p=new Node(item, sentinel, sentinel.next);
            sentinel.next.prev=p;
            sentinel.next =p;
        }
        size+=1;
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
        size-=1;
        return t;
        }
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if (sentinel.next==sentinel || sentinel.prev==sentinel||size==0){return true;}
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


//    public static void main(String[] args){
//        LinkedListDeque<Integer> d1=new LinkedListDeque<>();
//
//
//
//        System.out.println(d1.sentinel.prev==null);
//
//
//
//
//        d1.addFirst(0);
//
//        d1.addLast(1);
//
//        d1.get(0);
//        d1.removeFirst();
//        d1.removeLast();
//
//        d1.addFirst(5);
//        System.out.println(d1.get(0));
//        d1.addFirst(6);
//        System.out.println(d1.get(0));
//        d1.removeLast();
//        System.out.println(d1.get(0));
//        d1.addLast(8);
//        System.out.println(d1.get(0));
//
//










        //System.out.println(d1.removeLast());
        //System.out.println(d1.isEmpty());

//        d1.addLast(2);
//        d1.removeLast();
//        d1.removeLast();
//        d1.removeLast();
//        System.out.println(d1.isEmpty());
//        d1.addFirst(1024);
//        d1.addFirst(1025);
//        d1.addFirst(1026);
//        d1.printDeque();
//        System.out.println(d1.size());
//        System.out.println(d1.get(1));

//        for(int i=1;i<5;i++){
//            d1.addLast(i);
//        }
//        d1.printDeque();
//        System.out.println();
//        d1.addLast(12312312);
//        d1.printDeque();
//        System.out.println();
//        d1.removeLast();
//        d1.printDeque();
//        System.out.println();
//        d1.removeFirst();
//        System.out.println();
//        d1.printDeque();
//        System.out.println(d1.size());
//        System.out.println(d1.getRecursive(3));
//        System.out.println(d1.get(3));
//    }
}
