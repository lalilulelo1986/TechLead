package geek.problem;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class FilteringIterator<T> implements Iterator<T> {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 5, 7, 9, 11, 12, 14);
        Predicate<Integer> pred = (Integer it) -> it % 2 == 0;
        Iterator<Integer> iterator = integers.iterator();
        FilteringIterator<Integer> filteringIterator = new FilteringIterator<>(iterator, pred);
//        System.out.println("filter: " + filteringIterator.next());
//        System.out.println(iterator.next());
//        System.out.println("filter: " +  filteringIterator.next());
//        System.out.println("filter: " +  filteringIterator.next());

        while (filteringIterator.hasNext()) {
            System.out.println(filteringIterator.next());
        }
    }

    private Predicate<T> predicate;
    private Iterator<T> source;

    public FilteringIterator(Iterator<T> source, Predicate<T> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    private final Object begin = new Object();
    private final Object end = new Object();
    private Object current = begin;

    @Override
    public boolean hasNext() {
        if (current == begin)
            moveToNextEvaluated();
        return current != end;
    }

    private void moveToNextEvaluated() {
        while (source.hasNext()) {
            current = source.next();
            if (predicate.test((T) current))
                return;
        }
        current = end;
    }

    @Override
    public T next() {
        if (hasNext()) {
            Object result = current;
            moveToNextEvaluated();
            return (T) result;
        }
        return source.next();
    }

    public void remove() {

    }
}