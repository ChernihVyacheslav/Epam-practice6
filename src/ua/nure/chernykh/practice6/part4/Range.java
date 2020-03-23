package ua.nure.chernykh.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int[] rangeArr;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int n, int m, boolean reverse) {
        this.rangeArr = new int[m - n + 1];
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        if (reverse) {
            for (int i = 0; i < rangeArr.length; i++) {
                rangeArr[i] = m--;
            }
        } else {
            for (int i = 0; i < rangeArr.length; i++) {
                rangeArr[i] = n++;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new RangeIteratorImpl();
    }

    private class RangeIteratorImpl implements Iterator<Integer> {

        private int currIndex;

        public RangeIteratorImpl() {
            currIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return currIndex + 1 < rangeArr.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                currIndex++;
            }
            return rangeArr[currIndex];
        }
    }

}
