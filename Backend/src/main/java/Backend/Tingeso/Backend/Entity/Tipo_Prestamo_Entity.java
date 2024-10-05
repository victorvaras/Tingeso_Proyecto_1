package Backend.Tingeso.Backend.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tipo_Prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_Prestamo_Entity {

    @Id
    private int id_Tipo_Prestamo;
    private String nombreTipo_Prestamo;
    private int plazo_maximo;
    private int tasa_anual;
    private int porcentaje_maximo_financiamiento;



}
