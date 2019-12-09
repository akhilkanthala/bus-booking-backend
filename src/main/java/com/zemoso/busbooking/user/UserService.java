package com.zemoso.busbooking.user;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

  //  public User getUser(UUID id);

    public User addUser(UserDTO userDTO);// throws IncompleteFieldsException;

     public User updateUser(Integer id, UserDTO userDTO);

    public User deleteUser(Integer id);

   public User findUser(String email);
}
