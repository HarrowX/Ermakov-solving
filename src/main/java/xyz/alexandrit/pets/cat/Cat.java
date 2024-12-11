package xyz.alexandrit.pets.cat;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Cat implements Meowing {
    @NonNull
    private String name;

    @Override
    public void meow() {
        System.out.println("meow");
    }
}
