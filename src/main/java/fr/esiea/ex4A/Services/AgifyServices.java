package fr.esiea.ex4A.Services;

import fr.esiea.ex4A.Agify.Agify;
import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Storage.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyServices {
    private final AgifyClient client;
    private final UserRepository repository;

    public AgifyServices(AgifyClient client, UserRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Agify getAgeFromNameAndCountry(String name, String countryCode) throws IOException {
        Agify user = (Agify) client.getAge(name, countryCode).execute().body();
        return user;
    }

    public ArrayList<Match> getMatchFromAge(int userAge) throws IOException {
        ArrayList<Match> matchList = new ArrayList<Match>();
        for (User match : repository.getUsers()){
            if (match.getuName() != null) {
                int matchAge = getAgeFromNameAndCountry(match.getuName(), match.getuCountry()).getAge();
                int ageDiff = (userAge - matchAge);
                if (ageDiff <= 4 && ageDiff >= -4) {
                    Match newMatch = new Match(match.getuName(), match.getuTweeter());
                    matchList.add(newMatch);
                }
            }
        }
        return matchList;
    }
}
