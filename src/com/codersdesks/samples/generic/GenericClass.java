package com.codersdesks.samples.generic;

public class GenericClass {

    public static void main(String[] args) {
        var list = new MyList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.print();
        list.remove(0);
        list.print();
        System.out.println("");
        System.out.println(list.size());
        list.add(40);
        list.print();
        System.out.println(list.size());

    }

}


class MyList<T>{
  private final Object [] data;
   private int currentIndex = 0;
   private int size = 0;
    public MyList(){
        int defaultSize = 10;
        data =  new  Object[defaultSize];
    }
    public void add(T t){
       data[currentIndex++] = t;
        size = currentIndex;
    }
    public void remove(int index){
        data[index] = null;
        moveElements(data, index);
        size = --currentIndex;
    }

    private void moveElements(Object[] data, int index) {
        for (int i = index+1; i < data.length; i++){
            data[index++] = data[i];
        }
    }

    public T get(int index){
       return (T) data[index];
    }

    public void print(){
        System.out.println("");
        System.out.print("data: ");
        for (Object t : data){
            System.out.print(t +" ");
        }
    }

    public int size(){
        return this.size;
    }
}