package Backend.Tingeso.Backend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Capacidad_Ahorro")
@Data
@NoArgsConstructor
public class Capacidad_Ahorro_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Capacidad_Ahorro;

    //Saldo minimo requerido
    private boolean R71;
    //Historial de ahorro consistente
    private boolean R72;
    //Deposito periodico
    private boolean R73;
    //Relacion saldo/años antiguedad
    private boolean R74;
    //Retiron recientes


    public Capacidad_Ahorro_Entity(boolean r71, boolean r72, boolean r73, boolean r74) {
        R71 = r71;
        R72 = r72;
        R73 = r73;
        R74 = r74;
    }
}
