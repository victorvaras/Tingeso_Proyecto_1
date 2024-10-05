package Backend.Tingeso.Backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Solicitud_Credito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud_Credito_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud_credito;

    //Para saber que tipo prestamo se va solicitar
    private int id_Tipo_Prestamo;

    private int id_cliente;
    private int id_ejecutivo;
    private int id_evaluacion_credito;
    private int id_seguimiento_solicitud;

    //Documentacion
    private String comprobante_ingresos;
    private String certificado_avaluo;


}
