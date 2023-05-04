package web.springbootmvc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.springbootmvc.models.User;
import web.springbootmvc.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(int id) {
        try {
            return repository.getReferenceById(id);
        } catch (EntityNotFoundException ENFex) {
            return null;
        }
    }
    public List<User> getUsers() {
        return repository.findAll();
    }
    @Transactional
    public void updateUser(User updatedUser, int id) {
        updatedUser.setId(id);
        repository.save(updatedUser);
    }
    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }
    @Transactional
    public void deleteUserById(int id) {
        repository.deleteById(id);
    }

}
