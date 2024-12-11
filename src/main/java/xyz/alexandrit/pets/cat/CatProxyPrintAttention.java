package xyz.alexandrit.pets.cat;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CatProxyPrintAttention implements Meowing {
    @NonNull Meowing meowing;

    @Override
    public void meow() {
        System.out.println("АХТУНГ");
        meowing.meow();
    }
}
