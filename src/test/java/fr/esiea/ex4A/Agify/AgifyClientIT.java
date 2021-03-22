package fr.esiea.ex4A.Agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class AgifyClientIT {

    @Test
    void requestAgifyTest() throws Exception{
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Agify> userTest = client.getAge("Valentin", "FR");
        Agify user = userTest.execute().body();
        Assertions.assertEquals(26, user.getAge());
        Assertions.assertEquals("FR", user.getCountryId());
        Assertions.assertEquals("Valentin", user.getName());
    }

}

