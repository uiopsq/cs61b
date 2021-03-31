class ArrayDeque<T>{
    private int size;
    private T[] items;
    public ArrayDeque(){
        items=(T[])new Object[100];
        size=0;
    }
    private void resize(int capacity){
        T[] a=(T[])new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }

    public void addFirst(T item){
        if (size==items.length){
            resize(size*2);
        }
        for(int i=size-1;i>=0;i--){
            items[i+1]=items[i];
        }
        items[0]=item;
        size=size+1;
    }
    public void addLast(T item){
        if (size==items.length){
            resize(size*2);
        }
        items[size]=item;
        size+=1;
    }

    public T get(int index){
        return items[index];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return items[0]==null;

    }
    public T removeLast(){
        double R = size / items.length;
        if(R < 0.25){
            resize(items.length/2);
        }
        T t=items[size-1];
        items[size-1]=null;
        size-=1;
        return t;
    }
    public T removeFirst(){
        double R = size/items.length;
        if(R < 0.25){
            resize(items.length/2);
        }
        T t=items[0];

        for(int i=0;i<size;i++){
            items[i]=items[i+1];
        }
        size=size-1;
        return t;
    }
    public void printDeque(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+" ");
        }
    }
//    public static void main(String[] args){
//
//        ArrayDeque<Integer> d1=new ArrayDeque<Integer>();
//        d1.addFirst(0);
//        d1.addFirst(1);
//        d1.addLast(2);
//        d1.removeLast();
//        d1.removeLast();
//        d1.removeLast();
//        System.out.println(d1.isEmpty());
//        d1.addFirst(1024);
//        d1.addFirst(1025);
//        d1.addFirst(1026);
//        d1.printDeque();
//        d1.removeFirst();
//        System.out.println(d1.size());
//        System.out.println(d1.get(1));
//    }
}