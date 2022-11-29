package com.sofka.controller;

import com.sofka.domain.Contacto;
import com.sofka.service.ContactoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *  Clase ContactoController que servira como controlador realizado con Springboot la cual nos dara los puntos de acceso para el consumo de APIS
 * @author Michael Arango
 */
@Slf4j
@RestController
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    
    /**
     *  Método para devolver una lista de todos los registros que hay en la BD
     * @return 
     */
    @GetMapping(path = "/contacts")
    public List<Contacto> listado() {

        var contactos = contactoService.list();
        return contactos;

    }

   
    /**
     *  Método para crear un registro en la BD contacto
     * @param contacto recibe todos los parametros para crearlo
     * @return respuesta con el registro creado
     */
    @PostMapping(path = "/contact")
    public ResponseEntity crear(@RequestBody Contacto contacto) {
        log.info("Contacto a crear: {}", contacto);
        contactoService.save(contacto);
        return new ResponseEntity<>(contacto, HttpStatus.CREATED);
    }

    
    /**
     * Método para borrar fisicamente un registro en la BD contacto
     * @param contacto recibe el parametro Id del contacto a eliminar 
     * @return respuesta con el registro eliminado.
     */
    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity borrar(Contacto contacto) {
        log.info("Contacto a borrar: {}", contacto);
        contactoService.delete(contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    
    /**
     * Borrado lógico implementado con un campo llamado "activo" el cual se inicia en ON
     * @param contacto recibe el param "activo" de la BD contacto iniciado en OFF por body
     * @param id  Id del contacto a modificar recibido por url
     * @return respuesta con el registro actualizado a borrado loico.
     */ 
    @PatchMapping(path = "/contact/deleteat/{id}")
    public ResponseEntity borradoLogico(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        contactoService.updateActivo(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

   /**
    *  Método para actualizar todo un registro del a BD contacto
    * @param contacto recibe por body todos los campos del contacto
    * @param id recibe por url el id a actualizar.
    * @return respuesta con el campo del registro ya actualizado.
    */
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity actualizar(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        log.info("Usuario a modificar: {}", contacto);
        contactoService.update(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     *  Método para actualizar solo el campo nombre en la BD contacto
     * @param contacto recibe por body el nombre a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/contact/name/{id}")
    public ResponseEntity actualizarNombre(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        contactoService.updateNombre(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);

    }

    /**
     * Método para actualizar el campo teléfono en la BD contacto
     * @param contacto recibe por body el teléfono a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/contact/phone/{id}")
    public ResponseEntity actualizarTelefono(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        contactoService.updateTelefono(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Método para actualizar el campo correo en la BD contacto
     * @param contacto recibe por body el correo a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/contact/mail/{id}")
    public ResponseEntity actualizarCorreo(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        contactoService.updateCorreo(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

    /**
     * Método para actualizar el campo fechaNacimiento en la BD contacto
     * @param contacto recibe por body el fechaNacimiento a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/contact/date/{id}")
    public ResponseEntity actualizarFechaNacimiento(@RequestBody Contacto contacto, @PathVariable("id") Long id) {
        contactoService.updateFechaNacimiento(id, contacto);
        return new ResponseEntity<>(contacto, HttpStatus.OK);
    }

}
