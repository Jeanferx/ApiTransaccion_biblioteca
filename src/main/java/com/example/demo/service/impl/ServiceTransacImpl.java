package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.DaoTransac;
import com.example.demo.exception.UserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.ModelTransac;
import com.example.demo.service.ServiceTransac;

@Service
public class ServiceTransacImpl implements ServiceTransac {

    @Autowired
    private DaoTransac dao;
    @Autowired
    private RestTemplate restTemplate;

    // URL base de tu API de usuario
    private final String USER_API_URL = "http://localhost:8082/users/";
    /*private final String USER_API_URL = "https://localhost:7146/api/Usuario"; para C#*/

    @Override
    public ModelTransac getTransac(String id) {
        return dao.getTransac(id);
    }

    @Override
    public ModelTransac postTransac(ModelTransac model) {
        try {
        	Map<String, Object>response=restTemplate.getForObject(USER_API_URL+model.getIdUser(), Map.class);
        	
            // Validar existencia del usuario en la API de usuarios
            if (response == null || response.isEmpty()) {
                // Lanzamos excepción personalizada con mensaje
                throw new UserNotFoundException("El usuario con ID '" + model.getIdUser() + "' no es válido.");
            }
            String rol=(String)response.get("rol");
            if (!"ADMIN".equalsIgnoreCase(rol)) {
                throw new UserException("El usuario no tiene permisos de administrador.");
            }
        } catch (UserNotFoundException e) {
            // Re-lanzamos la excepción para que ControllerAdvice la maneje
            throw e;
        } catch (Exception e) {
            throw new UserException("No se pudo validar el usuario: " + e.getMessage());
        }

        // Si todo está bien, guardamos la transacción
        return dao.postTransac(model);
    }

    @Override
    public ModelTransac putTransac(String id, ModelTransac model) {
    	try {
            // Validar existencia del usuario en la API de usuarios
            Map<String, Object> response = restTemplate.getForObject(USER_API_URL + model.getIdUser(), Map.class);

            if (response == null || response.isEmpty()) {
                // Lanzamos excepción personalizada con mensaje
                throw new UserNotFoundException("El usuario con ID '" + model.getIdUser() + "' no es válido.");
            }
            String rol = (String) response.get("rol");
            if (!"ADMIN".equalsIgnoreCase(rol)) {
                throw new UserException("El usuario no tiene permisos de administrador.");
            }
        } catch (UserNotFoundException e) {
            // Re-lanzamos la excepción para que ControllerAdvice la maneje
            throw e;
        } catch (Exception e) {
            throw new UserException("No se pudo validar el usuario: " + e.getMessage());
        }
        return dao.putTransac(id, model);
    }

    @Override
    public ModelTransac deleteTransac(String id) {
        return dao.deleteTransac(id);
    }
    
}
