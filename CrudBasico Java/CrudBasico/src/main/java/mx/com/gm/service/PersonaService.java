/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Persona;

/**
 *
 * @author aleja
 */
public interface PersonaService{
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona buscarPersona(Persona persona);
    
}
