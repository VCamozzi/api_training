package fr.esiea.ex4A.Agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;

class AgifyTest {

    @Test
    Agify createAgifyUser() throws Exception {
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Map<String, String>> userTest = client.getAge("Valentin", "FR");
        Map<String, String> userFinal = userTest.execute().body();
        return new Agify(userFinal.get("name"), Integer.parseInt(userFinal.get("age")),Integer.parseInt(userFinal.get("count")),userFinal.get("country_id"));
    }

    @Test
    void getName() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals("Valentin", user.getName());
    }

    @Test
    void getAge() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals(26, user.getAge());
    }

    @Test
    void getCount() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals(8413, user.getCount());
    }

    @Test
    void getCountryId() throws Exception {
        Agify user = createAgifyUser();
        Assertions.assertEquals("FR", user.getCountryId());
    }
}
