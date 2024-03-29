package com.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.domain.users.User;
import com.picpaysimplificado.dtos.NotificationDTO;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        //ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

        //if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            //System.out.println("erro ao enviar notificacao");
        //throw new Exception("Serviço de notificação está fora do ar");
        //}

        System.out.println("Notificacao enviada para o o usuario");
    }
}