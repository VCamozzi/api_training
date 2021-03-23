package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getuName() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("olivier", user.getuName());
    }

    @Test
    void getuMail() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("olivier@et.esiea.fr", user.getuMail());
    }

    @Test
    void getuTweeter() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("oliverte", user.getuTweeter());
    }

    @Test
    void getuCountry() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("FR", user.getuTweeter());
    }

    @Test
    void getuSex() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("M", user.getuSex());
    }

    @Test
    void getuSexPref() {
        User user = new User("olivier", "olivier@et.esiea.fr", "oliverte", "FR", "M", "F");
        Assertions.assertEquals("F", user.getuSexPref());
    }
}
