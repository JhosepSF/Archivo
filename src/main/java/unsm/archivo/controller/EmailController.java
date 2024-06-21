package unsm.archivo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.mail.username}")
    private String mailFrom;

  
    @PostMapping("/enviarcorreo")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request ){
    	request.setMailFrom(mailFrom);
        request.setSubject("Cambio de Contraseña");
        UUID uuid = UUID.randomUUID();
        String codigo = uuid.toString();
        request.setCodigo(codigo);
        emailService.sendEmail(request);
        return new ResponseEntity<String>("Correo con plantilla enviado", HttpStatus.OK);
    }
}
