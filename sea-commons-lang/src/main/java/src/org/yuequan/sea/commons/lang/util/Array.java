package org.yuequan.sea.commons.lang.util;

/**
 * 这是一个对数据的封装工具类，目的是更加方便的使用数组且支持扩容
 * @author yuequan
 */
public class Array<E> {
    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public Array(){
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 获取数组当前元素数量
     * @return 元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取当前数组容量
     * @return 当前数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 根据索引位置添加数组元素
     * @param index 要将数组元素添加到的索引位置
     * @param e 需要添加到索引位置的元素
     * @throws IllegalArgumentException 当传入的索引位置为负数或大于数组的size时跑出
     */
    public void add(int index, E e){
        checkIndexIsArrayOutOfBound(index);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 从数组末端添加一个数组元素
     * @param e 要添加到数组中的元素
     */
    public void add(E e){
        data[size] = e;
        size ++;
    }

    /**
     * 在数组的第0个位置添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 替换{@code index}处的值
     * @param index 要替换值的数组下标
     * @param e 要替代数组下标中的元素
     * @throws IllegalArgumentException 当传入的索引位置为负数或大于数组的size时跑出
     */
    public void set(int index, E e){
        checkIndexIsArrayOutOfBound(index);
        data[index] = e;
    }

    /**
     * 从数组中获取一个元素
     * @param index 要获取值的数组下标
     * @return 获取到的元素 {@code e}
     * @throws IllegalArgumentException 当传入的索引位置为负数或大于数组的size时跑出
     */
    public E get(int index){
        checkIndexIsArrayOutOfBound(index);
        return data[index];
    }

    /**
     * 删除数组中的一个元素
     * @param index 要删除的元素的数组下标
     * @throws IllegalArgumentException 当传入的索引位置为负数或大于数组的size时跑出
     */
    public void remove(int index){
        checkIndexIsArrayOutOfBound(index);
        if(size > 0){
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            data[size - 1] = null;
            size --;
        }
    }

    private void checkIndexIsArrayOutOfBound(int index){
        if(index < 0 || (index > size - 1 && size != 0)){
            throw new IllegalArgumentException("索引位置不能是负数或在大于数组的size！");
        }
    }
}
