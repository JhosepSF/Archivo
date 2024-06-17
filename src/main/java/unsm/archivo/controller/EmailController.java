package unsm.archivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unsm.archivo.DTO.EmailRequest;


@RestController
@RequestMapping("/change-password")
public class EmailController {
    
    @Autowired
    unsm.archivo.services.EmailService emailService;

  
    @PostMapping("/enviarcorreo")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request ){
    	
        emailService.sendEmail(request);
        return new ResponseEntity<String>("Correo con plantilla enviado", HttpStatus.OK);
    }
}
