package fr.esiea.ex4A.Storage;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<User>();

    public UserRepository() {
        userList.add(new User("maxime", "maxime@et.esiea.fr", "maxime_grz", "FR", "M", "F"));
        userList.add(new User("armel", "tchiasso@et.esiea.fr", "tontonarmel", "FR", "F", "M"));
        userList.add(new User("chloe", "chloe@et.esiea.fr", "chloe67", "FR", "F", "M"));
        userList.add(new User("elise", "elise@et.esiea.fr", "elise34", "FR", "F", "M"));
        userList.add(new User("clara", "clara@et.esiea.fr", "clara_frl", "FR", "F", "M"));
        userList.add(new User("herve", "herve@et.esiea.fr", "hervedu67", "FR", "M", "F"));
    }

    public List<User> getUsers(){
        return this.userList;
    }

    public boolean addUser(User userAdd){
        for (User user : userList){
            if (user.getuMail().equals(userAdd.getuMail())){
                return false;
            }
        }
        userList.add(userAdd);
        return true;
    }
}
