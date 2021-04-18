package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addFirst(2);
        assertEquals( 2,  (int)d1.get(0));
        d1.addFirst(1);
        assertEquals( 1,  (int)d1.get(0));
        assertEquals( 2,  d1.size());
    }

    @Test
    public void addLastTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        assertEquals( 1,  (int)d1.get(0));
        d1.addLast(2);
        assertEquals( 2,  (int)d1.get(1));
        assertEquals( 2,  d1.size());
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        assertEquals( true,  d1.isEmpty());
        d1.addLast(2);
        assertEquals( false,  d1.isEmpty());
    }

    @Test
    public void sizeTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        assertEquals( 0,  d1.size());
        d1.addLast(2);
        assertEquals( 1,  d1.size());
    }

    @Test
    public void printDequeTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        d1.addLast(4);
        d1.printDeque();
    }



    @Test
    public void resizeTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        d1.addLast(4);
        d1.addLast(5);
        d1.addLast(6);
        d1.addLast(7);
        d1.addLast(8);
        d1.addLast(9);
        d1.addLast(10);
        d1.addLast(11);
        d1.printDeque();

        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        for(int i =11; i>=0; i--){
            d2.addFirst(i);
        }
        d2.printDeque();

        ArrayDeque<Integer> d3 = new ArrayDeque<>();
        for(int i =7; i>=0; i--){
            d3.addFirst(i);
            d3.addLast(i);
        }
        d3.removeFirst();
        d3.removeLast();
        d3.removeFirst();
        d3.removeLast();

        d3.printDeque();

        ArrayDeque<Integer> d4 = new ArrayDeque<>();
        for(int i =0;i<16;i++){
            d4.addLast(i);
        }
        for(int i =0;i<14;i++){
            d4.removeFirst();
        }
        d4.printDeque();
        assertEquals("14 15", d4.toString());
    }


    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        d1.addLast(4);
        d1.removeFirst();
        assertEquals( 2,  (int)d1.get(0));
        assertNull(d1.get(5));
        assertEquals( true,  d1.get(5)== null);
        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        d1.removeFirst();


        ArrayDeque<Integer> d3 = new ArrayDeque<>();
        d3.addLast(1);
        d3.removeFirst();
        assertEquals( null,  d3.get(0));

        d3.addFirst(1);
        d3.removeFirst();

        assertEquals( null,  d3.get(0));
        assertEquals( null,  d3.get(1));


    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        d1.addLast(4);
        d1.printDeque();

        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        d2.addFirst(1);
        d2.removeLast();

        d2.printDeque();
        assertEquals( null,  d2.get(0));

        d2.addLast(1);
        d2.removeLast();
        assertEquals( null,  d2.get(0));
        assertEquals( null,  d2.get(1));
    }

    @Test
    public void equalsTest(){
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        ArrayDeque<String> d2 = new ArrayDeque<>();
        ArrayDeque<Integer> d3 = new ArrayDeque<>();

        assertEquals(true, d1.equals(d2));
        assertEquals(true, d1.equals(d3));

        d1.addLast(1);
        d2.addLast("a");
        assertEquals(false, d1.equals(d2));

        d3.addLast(1);

        assertEquals(true, d1.equals(d3));

        d1.addLast(2);
        d3.addLast(2);

        assertEquals(true, d1.equals(d3));

        d3.addLast(2);
        assertEquals(false, d1.equals(d3));

        ArrayDeque<Integer> d4 = new ArrayDeque<>();
        assertEquals(false, d3.equals(d4));

        ArrayDeque<Integer> d5 = new ArrayDeque<>();
        ArrayDeque<Integer> d6 = new ArrayDeque<>();

        d5.addLast(1);
        d5.addLast(1);

        d6.addLast(1);
        assertEquals(false, d5.equals(d6));






    }

   
}
