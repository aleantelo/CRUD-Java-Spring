package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty //Anotacion para validar que el nombre no sea null ni una cadena vacia
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String telefono;
}
