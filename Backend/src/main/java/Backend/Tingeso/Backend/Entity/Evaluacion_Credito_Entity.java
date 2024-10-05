package Backend.Tingeso.Backend.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Evaluacion_Credito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion_Credito_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evaluacion_credito;

    //Relacion cuota ingreso
    private boolean R1;
    //Historial crediticio del cliente
    private boolean R2;
    //Antiguedad laboral
    private boolean R3;
    //Relacion deuda/ingreso
    private boolean R4;
    //Monto maximo financiamiento
    private boolean R5;
    //Edad del solicitante
    private boolean R6;
    //Capacidad de ahorro
    private boolean R7;

    //Enlaze real a R7
    private int id_Capacidad_Ahorro;
}
