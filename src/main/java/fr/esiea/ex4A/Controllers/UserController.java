package fr.esiea.ex4A.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.Agify.Agify;
import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Services.AgifyServices;
import fr.esiea.ex4A.Storage.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
class UserController {

    private final UserRepository userRepository;
    private final AgifyClient client;
    private final AgifyServices services;

    UserController(UserRepository userRepository, AgifyClient client, AgifyServices services) {
        this.userRepository = userRepository;
        this.client = client;
        this.services = services;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String addUser(@RequestBody Map<String,String> body){
        User user = new User(body.get("userName"), body.get("userMail"), body.get("userTwitter"), body.get("userCountry"), body.get("userSex"), body.get("userSexPref"));
        userRepository.addUser(user);
        return "OK";
    }

    @GetMapping(path="/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String matchSearch(@RequestParam(name="userName", required=true) String userName,
                       @RequestParam(name="userCountry", required=true) String userCountry) throws IOException{

        //on recupère l'age de l'utilisateur
        Agify user = services.getAgeFromNameAndCountry(userName, userCountry);
        //on recupère la list de ses match
        List<Match> matchList = services.getMatchFromAge(user.getAge());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(matchList);
    }
}
