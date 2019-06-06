package com.company;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cont<E> implements Iterable, Serializable {
    private final int INT_VAl =16;
    public String[] MAS = new String[INT_VAl];
    public int size =0;
    public int cursor;


    @Override
    public Iterator<String> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<String>{
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public String next() {
//            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            String [] arra = Cont.this.MAS;
            if (i >= arra.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (String) arra[lastRet = i];
        }


        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
//            checkForComodification();

            try {
                Cont.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        /*final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }*/
    }



    // Метод для повернення елемента за індексом
    public String set(int index){
        checkIndex(index);//для перевірки індексу
        return MAS[index];
    }

    //Медод який перевіряє чи входить цей індекс в наш масив
    private void checkIndex(int index){
        if (index>=size || index<0)
            throw new IllegalArgumentException();//якщо ні викидує помилку
    }

    //Додаємо елемент за індексом
    public void add(int index, String valua){
        if (index>MAS.length){//якщо індекс більший за зараз існуючий то збільшуємо масив
            addSize();
        }
        MAS[index]=valua;//записуємо значення за даним елементом
        if (index>size) {
            size++;//збільшуємо зміну розмір лише тоді коли індекс був поза даного масиву(інакше він просто перезаписується)
        }
    }
    //Додаємо елемент до кінця списку
    public void add(String string){
        if (size>MAS.length){//якщо індекс більший за зараз існуючий то збільшуємо масив
            addSize();
        }
        MAS[size]=string;//записуємо значення в кінець
        size++;//збільшуємо зміну розмір
    }
    //Збільшує масив в 2 рази
    private void addSize(){
        String[] MAS_1 =new String[MAS.length*2];//створює масив для копії головного , але збільшує його
        System.arraycopy(MAS,0,MAS_1,0,size-1);//копіює всі елементи з першого в другий масив
        MAS = MAS_1;//копіюєм масив 2 в масив 1
    }

    //видаляємо всі елементи
    public  void clear(){
        for (int i =0;i<size;i++){
            MAS[i]=null;
        }
        size=0;
    }

    //Метод для видалення елемента по його значені
    //дописати зменшення розміру масиву(а можна і не записувати)
    public boolean remove(String string){
        int index=-1;//початковий індекс
        for (int i =0;i<size;i++){//шукаємо елемент
            if (string.equals(MAS[i])){
                index=i;//записуємо номер елемента
                break;
            }
        }
        if (index==-1) //якщо не було співпадінь
            return false;

        for (int i =index;i<size;i++)//перезаписуємо
            MAS[i]=MAS[i+1];

        MAS[size-1]=null;//забираємо останій зайвий
        size--;
        return true;
    }

    public String remove(int i) {
        if (MAS[i] != null) {
            MAS[i] = null;
            System.out.println("Item with index: " + i + " removed!!!");
            size--;
        }
        return (String) MAS[i];
    }

    public Object[] toArray(){
        return MAS;
    }


}
