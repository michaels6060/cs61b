package deque;


public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int startCapacity = 8;
    private int nextFirst = 0 ;
    private int nextLast = 1;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[startCapacity];
        size = 0;
    }

    public void getNextLast(){
        nextLast++;
        if(nextLast >= items.length){
            nextLast =0;
        }
    }

    public void getNextFirst(){
        nextFirst--;
        if(nextFirst <0){
            nextFirst = items.length-1;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        int back = size-1 - nextFirst;
        int oldFrontIndex = nextFirst;
        nextFirst = capacity - back;
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, oldFrontIndex, a, nextFirst, size);
        items =a;
    }

    public void addFirst(T x){
        if (size == items.length) {
            resize(size*2);
        }
        items[nextFirst] = x;
        size += 1;
        getNextFirst();
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size*2);
        }
        items[nextLast] = x;
        size += 1;
        getNextLast();
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque(){
        int start = nextFirst+1;
        for(int i =0;i<size;i++){
            if(start>=items.length){
                start=0;
            }
            System.out.print(items[start] + " ");
            start++;
        }
        System.out.println();
    }

    public T get(int index){
        int target = getIndex(index);
        if(target == -1){
            return null;
        }
        return items[target];
    }

    public int getIndex(int index){
        if(index>=items.length){
            return -1;
        }

        int target = index + nextFirst +1;
        if(target>=items.length){
            target = target - items.length;
        }
        return target;
    }


    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T x = this.get(0);
        items[getIndex(0)] = null;
        size = size - 1;
        if(size < 0.25*items.length){
            resize(size/2);
        }
        return x;
    }


    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = this.get(size-1);
        items[getIndex(size-1)] = null;
        size = size - 1;

        if(size < 0.25*items.length){
            resize(size/2);
        }
        return x;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof ArrayDeque){
            ArrayDeque other = (ArrayDeque) o;
            if(other.size() == this.size()){
                int i = 0;
                while (getIndex(i)!= nextLast) {
                    //System.out.println(curr1 + " " + curr2);
                    if(!this.get(i).equals(other.get(i))){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Object[] array = new Object[Integer.MAX_VALUE- 9];
    }
}