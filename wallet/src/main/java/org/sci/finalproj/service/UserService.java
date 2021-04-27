package org.sci.finalproj.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sci.finalproj.model.User;
import org.sci.finalproj.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    // services can implement multiple repos
    @Autowired
    private UserRepo userRepo;

    public void register(User user){
        userRepo.save(user);
        LOGGER.info("User has been registered");
    }

    public boolean login(User user) {
        User loginUser = userRepo.findByUserName(user.getUserName());
        if (loginUser == null) {
            LOGGER.info("User has not been found");
            return false;
        }
        if (user.getPassword().equals(loginUser.getPassword())){
            LOGGER.info("User has been logged in");
           return true;
        }

        LOGGER.info("Should not get here");
        return false;

    }

    public boolean updateUser(User oldUser, User newUser) {
    User foundUser = userRepo.findByUserName(oldUser.getUserName());
    if (newUser.getUserName().equals(foundUser.getUserName())){
        userRepo.delete(oldUser);
        userRepo.save(newUser);
        LOGGER.info("User has been updated");
        return true;
        }
        return false;
    }

    public void deleteAccount(User userToDelete) {
        userRepo.delete(userToDelete);
        LOGGER.info("User has been deleted");
        }

 //   UpdateUser
  //  DeleteAccount
}

