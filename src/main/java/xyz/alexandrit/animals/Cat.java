package xyz.alexandrit.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Cat implements Meowable {
    @NonNull
    String name;
    @Override
    public void meow() {
        System.out.println("meow");
    }
}
