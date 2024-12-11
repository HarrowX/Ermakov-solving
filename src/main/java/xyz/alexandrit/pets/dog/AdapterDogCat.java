package xyz.alexandrit.pets.dog;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import xyz.alexandrit.pets.cat.Meowing;

@RequiredArgsConstructor
public class AdapterDogCat implements Meowing {
    @NonNull
    Barking dog;
    @Override
    public void meow() {
        dog.bark();
    }
}
