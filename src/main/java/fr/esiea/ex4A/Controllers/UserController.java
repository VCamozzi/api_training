package fr.esiea.ex4A.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Storage.UserRepository;
import fr.esiea.ex4A.User;
    import org.springframework.http.MediaType;
    import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    User addUser(@RequestBody Map<String,String> body){
        User user = new User(body.get("userName"), body.get("userMail"), body.get("userTwitter"), body.get("userCountry"), body.get("userSex"), body.get("userSexPref"));
        userRepository.addUser(user);
        for (User userInList : userRepository.getUsers()){
            System.out.println(userInList.getuName());
        }
        return user;
    }

    @GetMapping(path="/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String matchSearch(@RequestParam(name="userName", required=true) String userName, @RequestParam(name="userCountry", required=true) String userCountry)  throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Match match = new Match("toto", "totodu26");
        Match match2 = new Match("tata", "tatadu77");

        List<Match> matchList = new ArrayList<>();
        matchList.add(match);
        matchList.add(match2);
        String result = mapper.writeValueAsString(matchList);

        return result;
    }


}
