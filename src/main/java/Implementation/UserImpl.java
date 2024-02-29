package Implementation;

import Dao.UserDao;
import bean.User;
import Service.UserService;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserImpl implements UserService {
    UserDao dao =new UserDao();
    public UserImpl(SessionFactory sessionFactory)
    {

    }
    @Override
    public User saveUsers(User userObj) {
        return  dao.saveUser(userObj);
    }

    @Override
    public User updateUsers(User userObj) {
        return dao.UpdateUser(userObj);
    }

    @Override
    public User deleteUsers(User userObj) {
        return dao.DeleteUser(userObj);
    }

    @Override
    public List<User> listAllUsers() {
        return dao.allUsers();
    }

    @Override
    public User getUserId(User userObj) {
        return dao.Search(userObj);
    }
}
