package com.zemoso.busbooking.user;


import com.zemoso.busbooking.exception.BadRequestException;
import com.zemoso.busbooking.exception.IncompleteFieldsException;
import com.zemoso.busbooking.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Component
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAllByDeleted(false);
    }

    public User addUser(UserDTO userDTO) {
        User user = new User();

        if (userDTO.getUserName() != null) {
            String userName = userDTO.getUserName();
            user.setUserName(userName);
        } else {
            throw new IncompleteFieldsException("Please fill the required fields");
        }


        if (userDTO.getEmail() != null) {
            String email = userDTO.getEmail();
            if (userRepository.existsByEmail(email)) {
                throw new ResourceAlreadyExistsException("Email Id Already Exists");
            }
            user.setEmail(email);
        } else {
            throw new IncompleteFieldsException("Please fill the required fields");
        }
        return userRepository.save(user);
    }

public User findUser(String email){
        User user=userRepository.getOneByEmailAndDeleted(email,false);
        return user;
}
    public User updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.getOneByIdAndDeleted(id, false);

        if (Objects.isNull(user)) {
            throw new BadRequestException("User id is invalid");
        }
        String userName = userDTO.getUserName();//.ifPresent(firstName->{
        user.setUserName(userName);
        // });


//        String lastName = userDTO.getLastName();//.ifPresent(lastName->{
//        user.setLastName(lastName);
//        });

        String email = userDTO.getEmail();//.ifPresent(email->{
//            if(userRepository.existsByEmail(email)){
//                throw new ResourceAlreadyExistsException("Email Id Already Exist");
//            }
        user.setEmail(email);
        // });
        return userRepository.save(user);
    }

    public User deleteUser(Integer id) {
        User user = userRepository.getOneByIdAndDeleted(id, false);
        if (Objects.isNull(user)) {
            throw new BadRequestException("User id is invalid");
        }
        user.setDeleted(true);
        userRepository.save(user);
        return user;
    }
}
