package fr.esiea.ex4A.Controllers;

import fr.esiea.ex4A.Storage.UserRepository;
import fr.esiea.ex4A.User;
    import org.springframework.http.MediaType;
    import org.springframework.web.bind.annotation.*;
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
}
