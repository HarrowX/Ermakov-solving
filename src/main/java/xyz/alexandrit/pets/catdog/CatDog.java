package xyz.alexandrit.pets.catdog;

import xyz.alexandrit.pets.cat.Cat;
import xyz.alexandrit.pets.cat.Meowing;
import xyz.alexandrit.pets.dog.Barking;
import xyz.alexandrit.pets.dog.Dog;

public class CatDog implements Meowing, Barking {
    Meowing meowing;
    Barking barking;

    public CatDog(String name) {
        meowing = new Cat(name);
        barking = new Dog(name);
    }

    @Override
    public void meow() {
        meowing.meow();
    }

    @Override
    public void bark() {
        barking.bark();
    }
}
