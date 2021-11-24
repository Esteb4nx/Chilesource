package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.repository.RoleRepository;
import com.chilesource.Forowebspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService extends GenericService<User, Integer> implements UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);

        // Aqui implementar lógica de obtener permisos de la base de datos (Esto es harcode)
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                authorities
        );
    }

    public User findByUserName(String name) {
        return ((UserRepository) repository).findByUserName(name);
    }

}
