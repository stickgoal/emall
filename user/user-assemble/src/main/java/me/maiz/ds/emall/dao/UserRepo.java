package me.maiz.ds.emall.dao;

import me.maiz.ds.emall.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);

}
