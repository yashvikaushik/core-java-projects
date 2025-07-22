package movieTicketsBookingSystem.service;

import movieTicketsBookingSystem.dal.UserDAO;
import movieTicketsBookingSystem.model.User;

public class UserService {
    static UserDAO userDao =new UserDAO();

    public boolean registerUser(User user){
        return userDao.registerUser(user);

    }

    public static User loginUser(String email,String password){
        return userDao.validateLogin(email,password);
    }
    
}
