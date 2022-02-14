package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClassRunner {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("one");
        List il = l;
        il.add(2);
        System.out.println(l);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
    }
}

//    @Test
//    fun kek() {
//        val list = mutableListOf<String>()
//        val ints = list as MutableList<Int>
//                ints.add(1)
//        val strs = ints as MutableList<String>
//                strs.add("two")
//        val s0 = list[0]
//        print(s0)
//        val s1 = list[1]
//        print(s1)
//    }
