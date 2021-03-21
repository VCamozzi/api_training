package fr.esiea.ex4A.Storage;

import fr.esiea.ex4A.Services.HelloData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Repository
public class HelloRepository {
    final List<String> names = List.of(
            "Jaguabyss",
            "Coyolax",
            "Gazena",
            "Chickig",
            "Gladiabat",
            "Gladiafly",
            "Steeleen",
            "Marsharak",
            "Berriot",
            "Penguine"
    );
    private final Random random = new Random();

    public HelloData randomHello() {
        return new HelloData(names.get(random.nextInt(names.size())));
    }

    public HelloData getHelloFor(String name) {
        int letterIndex = name.toLowerCase(Locale.ROOT).charAt(0) - 'a';
        return new HelloData((name + " ").repeat(1 + letterIndex).trim());
    }
}
