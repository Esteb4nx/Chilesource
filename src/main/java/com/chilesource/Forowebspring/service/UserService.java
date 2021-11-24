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

/**
 * Servicio correspondiente al modelo User
 * **/


@Service
public class UserService extends GenericService<User, Integer> implements UserDetailsService {

    /**
     * Instancia del repositorio de Role pra sus uso en los metodos siguientes
     * **/
    @Autowired
    private RoleRepository roleRepository;


    /**
     * Instancia del servicio User
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public UserService(UserRepository repository) {
        super(repository);
    }


    /**s
     * Implementación propia de Cargar usuarios por Username
     * @param username nombre de usuario del usuario a cargar
     * @return Devuelve objeto UserDetails de Spring Security
     * **/
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

    /**
     * Metodo buscar Usuario por Username
     * @param name Nombre del usuario a buscar
     * @return Resultado de la operación en el respositorio (Objeto User)
     * **/

    public User findByUserName(String name) {
        return ((UserRepository) repository).findByUserName(name);
    }

}
