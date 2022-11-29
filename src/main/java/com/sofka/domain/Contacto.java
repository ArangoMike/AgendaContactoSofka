
package com.sofka.domain;


import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 * Clase Contacto creada con springboot que representa la tabla contacto
 * en POO para poderla implentarla desde Java
 * @author maicol
 */
@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // Declaración de como se manejarán en el entorno de desarrollo cada campo de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre_completo")
    private String nombre;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "correo_electronico")
    private String correo;
    
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento; 
    
    @Column(name = "activo")
    private String activo; 
}
