package fr.esiea.ex4A.Services;

import fr.esiea.ex4A.Agify.Agify;
import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Storage.UserRepository;

public class AgifyServices {
    private final AgifyClient client;
    private final UserRepository repository;

    public AgifyServices(AgifyClient client, UserRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Agify getAgeFromNameAndCountry(String name, String countryCode){
        Agify user = (Agify) client.getAge(name, countryCode);
        return user;
    }




}
