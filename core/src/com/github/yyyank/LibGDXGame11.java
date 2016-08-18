package com.github.yyyank;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * http://qiita.com/shinsan68k/items/c0a2b596cf2ecf3cc370
 */
public class LibGDXGame11 {


    public static void main(String[] args) {

        LibGDXGame11 main = new LibGDXGame11();
        System.out.println("(∩'-'⊂)arrayListSample(∩'-'⊂)");
        main.arrayListSample();
        System.out.println("(∩'-'⊂)arraySample(∩'-'⊂)");
        main.arraySample();
        System.out.println("(∩'-'⊂)arrayListRemoveSample(∩'-'⊂)");
        main.arrayListRemoveSample();
        System.out.println("(∩'-'⊂)arrayListRemoveSample2(∩'-'⊂)");
        main.arrayListRemoveSample2();
        System.out.println("(∩'-'⊂)arrayRemoveSample((∩'-'⊂)");
        main.arrayRemoveSample();
        System.out.println("(∩'-'⊂)arrayStackSample(∩'-'⊂)");
        main.arrayStackSample();
        System.out.println("(∩'-'⊂)arrayOtherSample(∩'-'⊂)");
        main.arrayOtherSample();

    }


    private void arrayListSample() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().forEach(System.out::println);
    }

    private void arraySample() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.forEach(System.out::println);
    }


    private void arrayListRemoveSample() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        list.remove(Integer.valueOf(2));
        list.stream().forEach(System.out::println);
    }


    private void arrayListRemoveSample2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        list.remove(2);
        list.stream().forEach(System.out::println);
    }


    private void arrayRemoveSample() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        array.removeIndex(2);
        // 第二引数はidentityなので、comparisonが必要なときはtrueだと思う
        array.removeValue(2, false);

        array.forEach(System.out::println);
    }

    private void arrayStackSample() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        // pushなくなった？
        // array.push(123);
        Integer peek = array.peek();
        System.out.println("peek:::::::" + peek);
        array.forEach(System.out::println);
        Integer pop = array.pop();
        System.out.println("pop:::::::" + pop);
        array.forEach(System.out::println);
    }

    private void arrayOtherSample() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        // random
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());
        System.out.println(array.random());


        // reverse
        System.out.println("reverse");
        array.reverse();
        array.forEach(System.out::println);

        // swap 0と1の値を交換
        System.out.println("swap");
        array.swap(0,1);
        array.forEach(System.out::println);

        // shuffle
        System.out.println("shuffle");
        array.shuffle();
        array.forEach(System.out::println);

        // filtering
        System.out.println("select");
        // Iterableインターフェースが返ってくるとは。。。
        Iterable<Integer> result = array.select(it -> it % 2 == 0);
        result.forEach(System.out::println);

    }
}
