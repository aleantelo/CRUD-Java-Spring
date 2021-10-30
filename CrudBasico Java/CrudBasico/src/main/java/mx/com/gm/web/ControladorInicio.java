package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired // Usando esta anotacion Spring inyecta una instancia que implemente la interface - En este caso la instancia de PersonaServiceImpl  
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    
    //Al pasar un objeto tipo persona por parametro hacemos que Spring lo inyecte de manera automatica
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    //En este caso al ya tener un objeto persona en memoria Spring va a inyectar este objeto persona con los valores del formulario
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){ //Se pone @Valid para mensionar que la persona se va a validar y Errors para manejar los erroes
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    //Spring no solo va a verificar que haya un objeto persona en memoria sino que tambien va a asociar el idPersona
    //que se indica en el getMapping
    public String editar(Persona persona, Model model){
        persona = personaService.buscarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar (Persona persona){
        personaService.eliminar(persona);
        
        return "redirect:/";
    }
}

