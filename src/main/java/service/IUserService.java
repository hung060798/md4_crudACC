package service;

import model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IUserService {
    User save(User user);
    User findById(int id);
    ArrayList<User> findAll();
    ArrayList<User> findAllByName(String name);
    Page<User> findAll(Pageable pageable);
    void delete(User user);
    void edit(User user);
}