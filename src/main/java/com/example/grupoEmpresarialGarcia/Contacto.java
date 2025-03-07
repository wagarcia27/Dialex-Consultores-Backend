package com.example.grupoEmpresarialGarcia;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correoElectronico;

    @Column(nullable = false)
    private Long telefono;

    @Column(nullable = false)
    private String asunto;

    private String mensaje;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    // Constructor vacío (obligatorio para JPA)
    public Contacto() {}

    // Constructor con parámetros
    public Contacto(String nombre, String correoElectronico, Long telefono, String asunto, String mensaje, Date fecha) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public Long getTelefono() { return telefono; }
    public void setTelefono(Long telefono) { this.telefono = telefono; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}
