package fr.esiea.ex4A.Storage;

import fr.esiea.ex4A.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    private final UserRepository repository = new UserRepository();


    @Test
    void getUsers() {
        Assertions.assertEquals(6,repository.getUsers().size());
        Assertions.assertEquals("maxime", repository.getUsers().get(0).getuName());
    }

    @Test
    void addUser() {
        Assertions.assertEquals(6,repository.getUsers().size());
        Assertions.assertEquals("chloe", repository.getUsers().get(2).getuName());
        User newUser = new User("emeric", "emeric@et.esiea.fr", "emeric2003", "FR", "M", "F");
        repository.addUser(newUser);
        Assertions.assertEquals(7,repository.getUsers().size());
        Assertions.assertEquals("emeric", repository.getUsers().get(6).getuName());
    }
    @Test
    void addExistingUser(){
        User newUser = new User("amelie", "amelie@et.esiea.fr", "amelie_dlg", "FR", "F", "F");
        repository.addUser(newUser);
        Assertions.assertEquals(7,repository.getUsers().size());
        Assertions.assertFalse(repository.addUser(newUser));

    }
}
