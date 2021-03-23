package fr.esiea.ex4A.Services;

import fr.esiea.ex4A.Agify.Agify;
import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Storage.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AgifyServices {
    private final AgifyClient client;
    private final UserRepository repository;
    private final Map<String,Integer> cache = new HashMap<>();

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
                int matchAge = IsInCache(match);
                int ageDiff = (userAge - matchAge);
                if (ageDiff <= 4 && ageDiff >= -4) {
                    Match newMatch = new Match(match.getuName(), match.getuTweeter());
                    matchList.add(newMatch);
                }
            }
        }
        return matchList;
    }

    public int IsInCache(User user) throws IOException {
        int value;
        if (cache.containsKey(user.getuName() + user.getuCountry())){
            value = cache.get(user.getuName() + user.getuCountry());
            System.out.println("récupération du chache : " + value + " - " + user.getuName());
        }else{
            Agify agifyUser = getAgeFromNameAndCountry(user.getuName(), user.getuCountry());
            cache.put(user.getuName() + user.getuCountry(), agifyUser.getAge());
            value = agifyUser.getAge();
            System.out.println("mise en cache : " + user.getuName() + " - " + user.getuCountry() + " - " + value);
        }
        return value;
    }
}
