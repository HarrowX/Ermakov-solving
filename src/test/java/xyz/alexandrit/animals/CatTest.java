package xyz.alexandrit.animals;

import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    void cat_count_test() {
        Cat cat = new Cat("Мурзик");
        CatWithCount catWithCount = new CatWithCount(cat);
        sayMeow(catWithCount);
        System.out.println(catWithCount.getCountMeow());
    }

    private void sayMeow(Meowable cat) {
        cat.meow();
        cat.meow();
    }
}
