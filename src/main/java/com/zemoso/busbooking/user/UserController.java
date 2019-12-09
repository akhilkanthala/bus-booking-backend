package com.zemoso.busbooking.user;

import com.zemoso.busbooking.exception.IncompleteFieldsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{email}")
    public ResponseEntity<User> findUser(@PathVariable String email) {
        return new ResponseEntity<>(userService.findUser(email), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody final UserDTO userDTO) {
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);

    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody final UserDTO userDTO, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
        } catch (IncompleteFieldsException e) {
            System.out.println("incomExc");
            throw new IncompleteFieldsException(e.getMessage());
//        return null;
        } catch (Exception e) {
            System.out.println("gern exception");
            return null;
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User marked as deleted", HttpStatus.ACCEPTED);
    }
}
