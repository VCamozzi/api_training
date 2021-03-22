package fr.esiea.ex4A.Agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class AgifyTest {

    @Test
    Agify createAgifyUser() throws Exception {
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Agify> userTest = client.getAge("Valentin", "FR");
        Agify user = userTest.execute().body();
        return user;
    }

    @Test
    void getName() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals("Valentin", user.getName());
    }

    @Test
    void setName() throws Exception {
        Agify user = createAgifyUser();
        user.setName("Camozzi");
        Assertions.assertEquals("Camozzi", user.getName());
    }

    @Test
    void getAge() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals(26, user.getAge());
    }

    @Test
    void setAge() throws Exception {
        Agify user = createAgifyUser();
        user.setAge(30);
        Assertions.assertEquals(30, user.getAge());
    }

    @Test
    void getCount() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals(8413, user.getCount());
    }

    @Test
    void setCount() throws Exception {
        Agify user = createAgifyUser();
        user.setCount(667);
        Assertions.assertEquals(667, user.getCount());
    }

    @Test
    void getCountryId() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals("FR", user.getCountryId());
    }

    @Test
    void setCountryId() throws Exception {
        Agify user = createAgifyUser();
        user.setCountryId("US");
        Assertions.assertEquals("US", user.getCountryId());
    }
}
