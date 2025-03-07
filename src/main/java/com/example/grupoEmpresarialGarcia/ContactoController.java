package com.example.grupoEmpresarialGarcia;

import com.example.grupoEmpresarialGarcia.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Contacto> createContacto(@RequestBody Contacto contacto) {
        contacto.setFecha(new Date());
        Contacto savedContacto = contactoRepository.save(contacto);

        // Enviar correo después de guardar en la base de datos
        String subject = "Nueva solicitud DialexConsultores";
        String body = "Nombre: " + contacto.getNombre() + "\n" +
                      "Correo: " + contacto.getCorreoElectronico() + "\n" +
                      "Teléfono: " + contacto.getTelefono() + "\n" +
                      "Asunto: " + contacto.getAsunto() + "\n" +
                      "Mensaje: " + contacto.getMensaje();

        emailService.sendEmail("fedexcorreos40@gmail.com", subject, body);

        return ResponseEntity.ok(savedContacto);
    }
}
