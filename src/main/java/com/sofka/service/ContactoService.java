
package com.sofka.service;

import com.sofka.dao.ContactoDao;
import com.sofka.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 *  La clase ContactoService es la encargada de resolver la logica de 
 * la aplicación implementando la interfaz IContactoService
 * @author maicol
 */
@Service
public class ContactoService implements IContactoService {

    @Autowired // es para inyectar el ContactoDao
    private ContactoDao contactoDao;
    
    // Estos son Los métodos implementados en el controlador
    @Override
    @Transactional (readOnly = true)
    public List<Contacto> list() {
        return (List<Contacto>) contactoDao.findAll();
    }

    @Override
    @Transactional
    public Contacto save(Contacto contacto) {
        return contactoDao.save(contacto);
    }

    @Override
    @Transactional
    public Contacto update(Long id, Contacto contacto) {
       contacto.setId(id);
        return contactoDao.save(contacto);
               
    }
    
    @Transactional
    public void updateNombre(Long id, Contacto contacto){
        contactoDao.updateNombre(id, contacto.getNombre());
    }
    
    @Transactional
    public void updateCorreo(Long id, Contacto contacto){
        contactoDao.updateCorreo(id, contacto.getCorreo());
    }
    
    @Transactional
    public void updateTelefono(Long id, Contacto contacto){
        contactoDao.updateTelefono(id, contacto.getTelefono());
    }
    
    
    @Transactional
    public void updateFechaNacimiento(Long id, Contacto contacto){
        contactoDao.updateFechaNacimiento(id, contacto.getFechaNacimiento());
    }

    
    @Transactional
    public void updateActivo(Long id, Contacto contacto){
        contactoDao.updateActivo(id, contacto.getActivo());
    }
    
    
    @Override
    @Transactional
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contacto> findContact(Contacto contacto) {
        return contactoDao.findById(contacto.getId());
       
    }
  
}
