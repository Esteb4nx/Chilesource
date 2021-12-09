package com.chilesource.Forowebspring;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @DisplayName("Buscar usuario por nombre de usuario.")
    @ParameterizedTest
    @ValueSource(strings = {".--.","Esteban123"})
    public void findByUserNameTest(String username){
        User usuarioObtenido = userService.findByUserName(username);

        // Caso usuario inexistente
        if(usuarioObtenido == null){
            Assertions.assertTrue(true);
            System.out.println("El usuario "+username+" no fue encontrado.");

        }

        //Caso usuario existente
        if(usuarioObtenido != null){
            Assertions.assertNotNull(usuarioObtenido);
            System.out.println("El usuario "+username+" fue encontrado.");

            Assertions.assertEquals("Esteban123", usuarioObtenido.getUserName());
            Assertions.assertEquals(4,usuarioObtenido.getId());
            Assertions.assertEquals("estebanesparza00@gmail.com", usuarioObtenido.getEmail());

            System.out.println("Los valores coinciden correctamente.");
            System.out.println("ID: "+usuarioObtenido.getId()+"\nUsername: "+usuarioObtenido.getUserName()+"\nEmail: "+usuarioObtenido.getEmail());
        }

    }

    @DisplayName("Cargar objeto UserDetails a partir del nombre de usuario")
    @ParameterizedTest
    @ValueSource(strings = {".--.","Esteban123", "Esteban","Jorge", "lll"})
    public void loadUserByUserNameTest(String username){
        UserDetails userDetails = null;

        try {
            userDetails = userService.loadUserByUsername(username);

            Assertions.assertNotNull(userDetails);
            System.out.println("El usuario "+username+" fue encontrado.");

            Assertions.assertTrue(userDetails.isEnabled());
            Assertions.assertEquals(username, userDetails.getUsername());
            System.out.println("Objeto Details cargado correctamente.\n Username: "+userDetails.getUsername()+"\nHabilitado: "+userDetails.isEnabled());

        }catch(UsernameNotFoundException e){
            Assertions.assertNull(userDetails);
            System.out.println("El usuario "+username+" no fue encontrado. \nInicio de sesión fallido");
        }


    }



}
