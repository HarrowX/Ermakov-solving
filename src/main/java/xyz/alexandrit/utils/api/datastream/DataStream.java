package xyz.alexandrit.utils.api.datastream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class DataStream<T> {
    Supplier<List<T>> supplierList;

    DataStream(List<T> list) {
        this(() -> list != null ? list : List.of());
    }

    DataStream(Supplier<List<T>> supplier) {
        supplierList = supplier;
    }

    public static <V> DataStream<V> of(List<V> list) {
        return new DataStream<>(list);
    }

    public <R> DataStream<R> map(Function<T, R> mapper) {
        Supplier<List<R>> supplierMappedList = () -> {
            List<T> list = supplierList.get();
            List<R> mappedList = new ArrayList<>(list.size());
            for (T el : list) {
                mappedList.add(mapper.apply(el));
            }
            return mappedList;
        };
        return new DataStream<>(supplierMappedList);
    }

    public DataStream<T> filter(Predicate<T> predicate) {
        Supplier<List<T>> supplierFilteredList = () -> {
            List<T> list = supplierList.get();
            List<T> filteredList = new ArrayList<>(list.size());
            for (T el : list) {
                if (predicate.test(el))
                    filteredList.add(el);
            }
            return filteredList;
        };
        return new DataStream<>(supplierFilteredList);
    }

    public Optional<T> reduce(BinaryOperator<T> operator) {
        List<T> list = supplierList.get();
        if (list.isEmpty())
            return Optional.empty();

        Iterator<T> iterator = list.iterator();
        T reducingValue = iterator.next();

        while (iterator.hasNext()) {
            reducingValue = operator.apply(reducingValue, iterator.next());
        }

        return Optional.ofNullable(reducingValue);
    }

    public <P> P collect(Supplier<P> supplier, BiConsumer<P, T> accumulator) {
        List<T> list = supplierList.get();
        P collectedList = supplier.get();

        if (list.isEmpty()) return collectedList;

        for (var element : list) {
            accumulator.accept(collectedList, element);
        }

        return collectedList;
    }

    public List<T> toList() {
        return collect(ArrayList::new, ArrayList::add);
    }
}


