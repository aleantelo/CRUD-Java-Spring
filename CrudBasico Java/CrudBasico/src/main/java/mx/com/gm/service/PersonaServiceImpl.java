/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;
    
    
    @Override
    @Transactional(readOnly=true) //Porque solo leemos datos de la base de datos.
    
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll(); //Devuelve un tipo object y por eso hay que castearla a List
    }

    @Override
    @Transactional // No se utiliza el atributo readOnly ya que se va a modificar la base de datos
    //Se utiliza la anotacion trasactional porque cada vez que uso "personaDao" se hace una transaccion con la base de datos
    //y puede realizarse bien y hacer un commit o un error y se lanza un rollback
    public void guardar(Persona persona) {
        personaDao.save(persona);
        
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional (readOnly = true)
    //Este metodo devuelve un valor Optional, en este caso se tiene que decidir que hacer si no se encuentra el objeto
    public Persona buscarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null); 
    }
    
    
}
