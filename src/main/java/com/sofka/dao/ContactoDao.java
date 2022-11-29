package com.sofka.dao;

import com.sofka.domain.Contacto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *  Creación de Interfaz del DAO la cual es la que tiene la conexión con nuestra data en la BD 
 *  Extendiendo de CrudRepository<>
 * @author Michael Arango
 */
public interface ContactoDao extends CrudRepository<Contacto, Long> {

    /**
     *  Query personalizada para la actualización del nombre en la BD contacto
     * @param id
     * @param nombre 
     */
    @Modifying
    @Query("update Contacto contact set contact.nombre = :nombre where contact.id = :id")
    public void updateNombre(
            @Param(value = "id") Long id,
            @Param(value = "nombre") String nombre
    );
       
    /**
     * Query personalizada para la actualización del correo en la BD contacto
     * @param id
     * @param correo 
     */
    @Modifying
    @Query("update Contacto contact set contact.correo = :correo where contact.id = :id")
    public void updateCorreo(
            @Param(value = "id") Long id,
            @Param(value = "correo") String correo
    );
      
    /**
     * Query personalizada para la actualización del teléfono en la BD contacto
     * @param id
     * @param correo 
     */
    @Modifying
    @Query("update Contacto contact set contact.telefono = :telefono where contact.id = :id")
    public void updateTelefono(
            @Param(value = "id") Long id,
            @Param(value = "telefono") String telefono
    );

    /**
     * Query personalizada para la actualización de la FechaNacimiento en la BD contacto
     * @param id
     * @param correo 
     */
    @Modifying
    @Query("update Contacto contact set contact.fechaNacimiento = :fechaNacimiento where contact.id = :id")
    public void updateFechaNacimiento(
            @Param(value = "id") Long id,
            @Param(value = "fechaNacimiento") String fechaNacimiento
    );
    
    /**
     * Query personalizada para la actualización del campo activo en la BD contacto
     * (este campo maneja el borrado logico implementado)
     * @param id
     * @param correo 
     */
    @Modifying
    @Query("update Contacto contact set contact.activo= :activo where contact.id = :id")
    public void updateActivo(
            @Param(value = "id") Long id,
            @Param(value = "activo") String activo
    );
}
