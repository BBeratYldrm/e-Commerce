package com.berat.inventory.presentation.faces;

import com.berat.inventory.data.entity.User;
import com.berat.inventory.data.repository.UserRepository;
import com.berat.inventory.data.repository.UserRepositoryImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {

    private User user;

    public UserBean() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String save() {
        System.out.println("Saklanıyor : " + user.getEmail());
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.registerUser(user);
        return "Home";
    }
}
