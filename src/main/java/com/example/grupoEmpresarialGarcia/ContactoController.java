package com.example.grupoEmpresarialGarcia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @PostMapping
    public ResponseEntity<Contacto> createContacto(@RequestBody Contacto contacto) {
        contacto.setFecha(new Date());
        Contacto savedContacto = contactoRepository.save(contacto);
        return ResponseEntity.ok(savedContacto);
    }
}