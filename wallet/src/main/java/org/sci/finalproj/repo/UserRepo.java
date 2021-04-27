package org.sci.finalproj.repo;

import org.sci.finalproj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    //findBy equivalent to SELECT WHERE *
    public List<User> findByName(String name);
    public User findByUserName(String userName);

//    @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//    public User customQuery(String userName, String name);
//
//    @Query("SELECT u FROM User u WHERE jmn.userName = :#{#user.userName}")
//    public User customQuery1(@Param("jmn") User user);

//    public boolean deleteByUserName(String userName);
//    public boolean updateByUserName(String userName);


//    public void createUser() {
//
//    }
//
//    public void updateUser() {
//
//    }
//
//    public void getUser() {
//
//    }
//
//
//    public void deleteUser() {
//
//    }


}
