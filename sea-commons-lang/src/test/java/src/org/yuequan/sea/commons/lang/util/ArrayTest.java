package org.yuequan.sea.commons.lang.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void getSize() {
        Array<Integer> array = new Array<>();
        assertEquals(0, array.getSize());
        array.add(1);
        assertEquals(1, array.getSize());
        array.add(0, 0);
        assertEquals(2, array.getSize());

        //TODO： 删除元素
    }

    @Test
    void getCapacity() {
        int capacity = 16;
        Array<Integer> array = new Array<>(capacity);
        assertEquals(capacity, array.getCapacity());
    }

    @Test
    void add() {
        //[]
        Array<Integer> array = new Array<>();
        assertEquals(0, array.getSize());

        //[1]
        array.add(1);
        assertEquals(1, array.getSize());
        assertTrue(1 == array.get(0));

        //[0,1]
        array.add(0, 0);
        assertEquals(2, array.getSize());
        assertTrue(0 == array.get(0));


        //[0,3,1]
        array.add(array.getSize() - 1, 3);
        assertEquals(3, array.getSize());
        assertTrue(3 == array.get(1));

        //[0,3,2,1]
        array.add(2, 2);
        assertEquals(4, array.getSize());
        assertTrue(2 == array.get(2));
    }

    @Test
    void addFirst() {
        Array<Integer> array = new Array<>();
        array.addFirst(0);
        assertTrue(0 == array.get(0));
    }

    @Test
    void set(){
        Array<Integer> array = new Array<>();
        array.addFirst(0);
        array.set(0, 1);
        assertTrue(1 == array.get(0));
    }

    @Test
    void get() {
        Array<Integer> array = new Array<>();
        array.add(0);
        assertTrue(0 == array.get(0));
    }

    @Test
    void remove(){
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        array.remove(0);
        assertEquals(4, array.getSize());
        assertTrue(array.get(0) == 2);

        array.remove(3);
        assertEquals(3, array.getSize());
        assertTrue(array.get(2) == 4);

    }
}