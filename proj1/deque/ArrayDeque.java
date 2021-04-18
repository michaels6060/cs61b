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

    public int incrIndex(int value){
        value++;
        if(value >= items.length){
            value =0;
        }
        return value;
    }
    public int decrIndex(int value){
        value--;
        if(value <0){
            value = items.length-1;
        }
        return value;
    }

    public void getNextFirst(){
        nextFirst--;
        if(nextFirst <0){
            nextFirst = items.length-1;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        nextFirst = incrIndex(nextFirst);
        nextLast = decrIndex(nextLast);

//        int start = nextFirst+1;
//        int end = nextLast-1;
//        if(start>=items.length){
//            start = 0;
//        }
//        if(end<0){
//            end = items.length-1;
//        }
        T[] newArray = (T[]) new Object[capacity];
        if(nextLast > nextFirst){
            System.arraycopy(items, nextFirst, newArray, 0, nextLast-nextFirst+1);
            nextLast = nextLast-nextFirst;
            items =newArray;
            nextFirst = items.length-1;
        }
        else{
            System.arraycopy(items, nextFirst, newArray, 0, items.length-nextFirst);
            System.arraycopy(items, 0, newArray, items.length-nextFirst, nextFirst);
            nextLast = items.length;
            items =newArray;
            nextFirst = items.length-1;
        }
    }


    public void addFirst(T x){
        if (size >= items.length) {
            resize(size*2);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst = decrIndex(nextFirst);
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size >= items.length) {
            resize(size*2);
        }
        items[nextLast] = x;
        size += 1;
        nextLast = incrIndex(nextLast);
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public int size() {
        return size;
    }

    public void printDeque(){
//        int start = nextFirst+1;
//        for(int i =0;i<size;i++){
//            if(start>=items.length){
//                start=0;
//            }
//            System.out.print(items[start] + " ");
//            start++;
//        }
//        System.out.println();
        System.out.println(toString());
    }

    @Override
    public String toString(){
        int start = nextFirst+1;
        String output = "";
        for(int i =0;i<size;i++){
            if(start>=items.length){
                start=0;
            }
            output+= items[start] + " ";
            start++;
        }
        return output.trim();
    }

    public T get(int index){
        int target = getIndex(index);
        if(target == -1){
            return null;
        }
        return items[target];
    }

    public int getIndex(int index){
        if(index>=size){
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
//        nextFirst++;
//        if(nextFirst >= items.length){
//            nextFirst =0;
//        }
        nextFirst = incrIndex(nextFirst);
        T x = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;

        if(size < 0.25*items.length && items.length>startCapacity){
            resize(items.length/2);
        }
        return x;
    }


    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
//        nextLast--;
//        if(nextLast <0){
//            nextLast = items.length-1;
//        }
        nextLast= decrIndex(nextLast);

        T x = items[nextLast];
        items[nextLast] = null;
        size = size - 1;

        if(size < 0.25*items.length && items.length>startCapacity){
            resize(items.length/2);
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
                while (i<size) {
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