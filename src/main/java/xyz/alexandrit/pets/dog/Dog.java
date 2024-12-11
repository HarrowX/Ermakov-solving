package xyz.alexandrit.pets.dog;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Dog implements Barking {
    @NonNull
    private String name;

    @Override
    public void bark() {
        System.out.println("bark");
    }
}

