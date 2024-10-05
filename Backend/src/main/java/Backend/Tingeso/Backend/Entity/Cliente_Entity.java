package Backend.Tingeso.Backend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
public class Cliente_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    private int rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String contrasenia;

    //Documentacion
    private String identificacion;
    private String comprobante_ingresos;

    public Cliente_Entity(int rut, String nombre, String apellido, String correo, String telefono, String contrasenia, String identificacion, String comprobante_ingresos) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.identificacion = identificacion;
        this.comprobante_ingresos = comprobante_ingresos;
    }
}
