package com.cultivation.javaBasic.showYourIntelligence;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private Map<Integer, E> distinctElement = new HashMap<>();
    private int currentInd = 0;

    DistinctIterator(Iterator<E> iterator) {
        while (iterator.hasNext()) {
            distinctElement.put(currentInd, iterator.next());
        }

        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return currentInd < distinctElement.size();
    }

    @Override
    public E next() {
        return distinctElement.get(currentInd++);
    }
    // --end->
}