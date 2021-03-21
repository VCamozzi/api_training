package fr.esiea.ex4A.Storage;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<User>();

    public UserRepository() {
        User user1 = new User("camozzi", "camozzi@et.esiea.fr", "@Val0u1", "FR", "M", "F");
        userList.add(user1);
        User user2 = new User("tchiasso", "tchiasso@et.esiea.fr", "@tontonarmel", "FR", "F", "M");
        userList.add(user2);
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
