package service;

import model.User;

public class UserService {
    User[] users = new User[10];
    int count = 0;

    public int addUser(User user){
        if(hasUsername(user.username)){
            return -1;
        }
        users[count++] = user;
        return 1;
    }

    public User login(String username, String password){
        for (User user : users) {
            if(user != null) {
                if (user.username.equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }

    public boolean hasUsername(String username) {
        for (User user : users) {
            if(user != null) {
                if (user.username.equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if(user != null) {
                if (user.username.equalsIgnoreCase(username)) {
                    return user;
                }
            }
        }
        return null;
    }

    public User[] getAllUsers() {
        return users;
    }
}
