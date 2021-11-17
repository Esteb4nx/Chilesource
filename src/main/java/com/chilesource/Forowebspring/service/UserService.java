/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.repository.RoleRepository;
import com.chilesource.Forowebspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Integer> {

    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository repository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository);
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findByUserName(String name) {
        return ((UserRepository) repository).findByUserName(name);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}
