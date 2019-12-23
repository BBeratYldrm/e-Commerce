package com.berat.inventory.data.repository;

import com.berat.inventory.data.entity.User;
import java.util.List;

public interface UserRepository {

    public User registerUser(User user);

    public User findUser(long userId);

    public User loginControl(String username, String email);

    public void removeUser(long userId);

    public List<User> findAllUsers();

}
