package ua.nure.chernykh.practice6.part2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    public static long removeByIterator(Collection<Integer> list, int k) {
        long start = System.currentTimeMillis();
        Iterator it = list.iterator();
        int count = 0;
        while (list.size() > 1) {
            while (it.hasNext() && list.size() > 1) {
                it.next();
                count++;
                if (count == k) {
                    it.remove();
                    count = 0;
                }
                if (list.size() < k && !it.hasNext()) {
                    it = list.iterator();
                }
            }
            it = list.iterator();
        }
        return System.currentTimeMillis() - start;
    }

    public static long removeByIndex(List<Integer> list, int k) {
        long start = System.currentTimeMillis();
        int count = 1;
        int index = 0;
        while (list.size() > 1) {
            if (count == k) {
                list.remove(index);
                count = 0;
            } else {
                index++;
            }
            if (index >= list.size()) {
                index = 0;
            }
            count++;
        }
//        while(list.size() > 1) {
//            if ((k - 1) < list.size()) {
//                list.remove(k - 1);
//            } else {
//                list.remove((k - 1) % list.size());
//            }
//        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, 4) + "ms");
        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, 4) + "ms");
        arrayList.clear();
        linkedList.clear();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, 4) + "ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, 4) + "ms");

    }
}
