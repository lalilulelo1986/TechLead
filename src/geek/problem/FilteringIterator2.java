package geek.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.Predicate;

class FilteringIterator2<T> implements Iterator<T> {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 5, 7, 9, 11, 12, 14);
        Predicate<Integer> pred = (Integer it) -> it % 2 == 0;
        Iterator<Integer> iterator = integers.iterator();
        FilteringIterator<Integer> filteringIterator = new FilteringIterator<>(iterator, pred);

        while (filteringIterator.hasNext()) {
            System.out.println(filteringIterator.next());
        }
    }

    private Predicate<T> predicate;
    private Iterator<T> source;

    private List<T> targetList = new ArrayList();
    private ListIterator<T> targetIterator;
    private T current = null;

    public FilteringIterator2(Iterator<T> source, Predicate<T> predicate) {
        this.source = source;
        this.predicate = predicate;
        while (source.hasNext()) {
            current = source.next();
            if (predicate.test(current)) {
                targetList.add(current);
            }
        }
        targetIterator = targetList.listIterator();

        Set sd = new HashSet<Integer>();

    }

    @Override
    public boolean hasNext() {
        return targetIterator.hasNext();
    }

    @Override
    public T next() {
        targetIterator.remove();
        return targetIterator.next();
    }
}