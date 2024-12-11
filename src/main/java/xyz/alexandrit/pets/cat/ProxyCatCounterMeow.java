package xyz.alexandrit.pets.cat;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyCatCounterMeow implements Meowing {
    @NonNull
    Meowing meowing;
    @Getter
    int counter = 0;

    @Override
    public void meow() {
        counter++;
        meowing.meow();
    }
}
