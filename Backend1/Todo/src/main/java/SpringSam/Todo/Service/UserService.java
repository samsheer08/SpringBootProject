package SpringSam.Todo.Service;

import SpringSam.Todo.Repository.UserRepository;
import SpringSam.Todo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }

}
