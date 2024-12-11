package xyz.alexandrit.animals;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CatWithCount implements Meowable {
    @Getter
    int countMeow = 0;
    @NonNull
    Meowable meowable;

    @Override
    public void meow() {
        meowable.meow();
        countMeow++;
    }
}
