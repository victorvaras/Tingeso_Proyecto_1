package Backend.Tingeso.Backend.Entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Seguimiento_Solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguimiento_Solicitud_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_seguimiento_solicitud;
    private String nombre_seguimiento_solicitud;
    private String descripcion_seguimiento_solicitud;
}
