package com.picpaysimplificado.services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.domain.users.User;

@Service
public class AuthorizationService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.authorizationApi}")
    private String authApiUrl;

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        try {
            // Comente temporariamente este trecho de código para simplificar a lógica
            /*
            ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(this.authApiUrl, Map.class);

            if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
                String message = (String) authorizationResponse.getBody().get("message");
                return "Autorizado".equalsIgnoreCase(message);
            } else {
                return false;
            }
            */
            
            // Temporariamente retornamos true para permitir todas as transações sem autenticação
            return true;
        } catch (Exception e) {
            // Logar a exceção ou lidar com ela de acordo com a necessidade do seu aplicativo
            e.printStackTrace();
            return false;
        }
    }
}

