package com.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.domain.users.User;
import com.picpaysimplificado.dtos.NotificationDTO;

@Service
public class NotificationService {
	
	@Autowired
	private RestTemplate restTemplate;

	public void sendNotification(User user, String message) throws Exception {
	    String email = user.getEmail();
	    NotificationDTO notificationRequest = new NotificationDTO(email, message);

	    try {
	        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);
	        
	        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
	            throw new Exception("Serviço de notificação está fora do ar");
	        }
	    } catch (HttpClientErrorException | HttpServerErrorException e) {
	        throw new Exception("Erro ao enviar notificação", e);
	    }
	}


}
