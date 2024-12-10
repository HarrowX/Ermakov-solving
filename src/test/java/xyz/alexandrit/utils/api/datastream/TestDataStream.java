package xyz.alexandrit.utils.api.datastream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDataStream {
    @Test
    void check_reduce() {
        assertEquals(
                Optional.of(6),
                DataStream.of(List.of(1, 2, 3))
                        .reduce(Integer::sum)
        );
    }

    @Test
    void check_reduce_2() {
        assertEquals(
                Optional.of(3),
                DataStream.of(List.of(1, 2))
                        .reduce(Integer::sum)
        );

    }

    @Test
    void check_reduce_3() {
        assertEquals(
                Optional.of(1),
                DataStream.of(List.of(1))
                        .reduce(Integer::sum)
        );
    }

    @Test
    void check_reduce_4() {
        assertEquals(
                Optional.empty(),
                DataStream.of(new ArrayList<Integer>())
                        .reduce(Integer::sum)
        );
    }

    @Test
    void check_collect() {
        var out = DataStream
                .of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .collect(() -> {
                    List<List<Integer>> collectedList = new ArrayList<>(2);
                    collectedList.add(new ArrayList<>());
                    collectedList.add(new ArrayList<>());
                    return collectedList;
                }, (collectedList, el) -> collectedList.get((el % 2 + 1) % 2).add(el));
        List<List<Integer>> expectedList = List.of(List.of(1, 3, 5, 7, 9), List.of(2, 4, 6, 8, 10));
        assertEquals(expectedList, out);
    }

    @Test
    void check_filter_collect() {
        var out = DataStream
                .of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filter(x -> x >= 5)
                .toList();
        assertEquals(List.of(5, 6, 7, 8, 9, 10), out);
    }

    @Test
    void check_filter_filter_collect() {
        var out = DataStream
                .of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filter(x -> x < 7)
                .filter(x -> x > 3)
                .toList();
        assertEquals(List.of(4, 5, 6), out);
    }

    @Test
    void check_filter_filter_filter_collect() {
        var out = DataStream
                .of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filter(x -> x < 7)
                .filter(x -> x != 5)
                .filter(x -> x > 3)
                .toList();
        assertEquals(List.of(4, 6), out);
    }

    @Test
    void check_mapped_collect() {
        assertEquals(
            List.of(1, 4, 9, 16, 25),
            DataStream.of(List.of(1, 2, 3, 4, 5))
                    .map(x -> x * x)
                    .toList()
        );
    }

    @Test
    void check_mapped_mapped_collect() {
        assertEquals(
                List.of(2, 5, 10, 17, 26),
                DataStream.of(List.of(1, 2, 3, 4, 5))
                        .map(x -> x * x)
                        .map(x->x+1)
                        .toList()
        );
    }

    @Test
    void check_filer_mapped_collect() {
        assertEquals(
                List.of(16, 25),
                DataStream.of(List.of(1, 2, 3, 4, 5))
                        .filter(x->x>3)
                        .map(x ->  x * x)
                        .toList()
        );
    }

    @Test
    void check_gc_mapped_collect() {
        var list = List.of(1, 2, 3, 4, 5);
        var stream = DataStream.of(list).map(x->x*2);
        System.gc();
        var out = stream.toList();
        assertEquals(
                List.of(2, 4, 6, 8, 10),
                out
        );
    }
    @Test
    void check_absence_npe() {
        var stream = DataStream.of(null);
        var list = stream.toList();
        assertEquals(new ArrayList<>(), list);
    }

    @Test
    void check_gc_mapped_mapped_collect() {
        var list = List.of(1, 2, 3, 4, 5);
        var stream = DataStream.of(list)
                .map(x->x*2)
                .map(x->x+1);
        System.gc();
        var out = stream.toList();
        assertEquals(
                List.of(3, 5, 7, 9, 11),
                out
        );
    }
    @Test
    void check_gc_mapped_mapped_timer_collect() {
        var list = List.of(1, 2, 3, 4, 5);
        var stream = DataStream.of(list)
                .map(x->x*2)
                .map(x->x+1);
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var out = stream.toList();
        assertEquals(
                List.of(3, 5, 7, 9, 11),
                out
        );
    }
}
