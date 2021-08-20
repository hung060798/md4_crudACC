package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import repository.IUserRepository;

import java.util.ArrayList;


@Transactional
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public User save(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public ArrayList<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }
}