package xyz.alexandrit.pets;

import org.junit.jupiter.api.Test;
import xyz.alexandrit.pets.cat.*;
import xyz.alexandrit.pets.dog.*;
import xyz.alexandrit.pets.catdog.*;


public class PetsTest {
    @Test
    void cat_count_test() {
        Cat cat = new Cat("Мурзик");
        var uniqueCat = new ProxyCatCounterMeow(new CatProxyPrintAttention(cat));
        sayMeow(uniqueCat);
        System.out.println(uniqueCat.getCounter());
    }

    @Test
    void dog_count_test() {
        var dog = new AdapterDogCat(new Dog("Пёсель"));
        var uniqueDog = new ProxyCatCounterMeow(new CatProxyPrintAttention(dog));
        sayMeow(uniqueDog);
        System.out.println(uniqueDog.getCounter());
    }
    @Test
    void catdog_count_test() {
        var catDog = new CatDog("Мурпес");
        var uniqueCatDog = new ProxyCatCounterMeow(new CatProxyPrintAttention(catDog));
        sayMeow(uniqueCatDog);
        System.out.println(uniqueCatDog.getCounter());
    }

    private void sayMeow(Meowing meowing) {
        meowing.meow();
        meowing.meow();
        meowing.meow();
    }
}
