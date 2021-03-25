package fr.esiea.ex4A.Agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;

class AgifyClientIT {

    @Test
    void requestAgifyTest() throws Exception{
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Map<String, String>> userTest = client.getAge("Valentin", "FR");
        Map<String, String> userMap = userTest.execute().body();
        Agify user =  new Agify(userMap.get("name"), Integer.parseInt(userMap.get("age")),Integer.parseInt(userMap.get("count")),userMap.get("country_id"));
        Assertions.assertEquals(26, user.getAge());
        Assertions.assertEquals("FR", user.getCountryId());
        Assertions.assertEquals("Valentin", user.getName());
    }

}

