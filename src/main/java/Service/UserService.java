package Service;

import bean.User;

import java.util.List;

public interface UserService {
    User saveUsers(User userObj);
    User updateUsers(User userObj);
    User deleteUsers(User userObj);
    List<User> listAllUsers();
    User getUserId(User userObj);
}
