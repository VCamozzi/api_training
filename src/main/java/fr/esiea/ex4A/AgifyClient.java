package fr.esiea.ex4A;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<Agify> getAge(@Query("name") String names, @Query("country_id") String country);
}
