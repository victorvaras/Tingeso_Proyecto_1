package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Simulacion_Credito_Entity;
import Backend.Tingeso.Backend.Repository.Simulacion_Credito_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Simulacion_Credito_Service {

    @Autowired
    private Simulacion_Credito_Repository simulacion_credito_repository;

    @Autowired
    private Business_Logic_Service business_logic_service;

    public List<Simulacion_Credito_Entity> getAllSimulacionCredito() {
        return simulacion_credito_repository.findAll();
    }

    public Simulacion_Credito_Entity getSimulacionCreditoById(int id) {
        return simulacion_credito_repository.findById(id).get();
    }

    public Simulacion_Credito_Entity newSimulacionCredito(Simulacion_Credito_Entity simulacion_credito) {
        int valor_cuota = business_logic_service.monthly_fee_calculation(simulacion_credito);
        simulacion_credito.setValor_cuota(valor_cuota);
        return simulacion_credito_repository.save(simulacion_credito);
    }

    public Simulacion_Credito_Entity updateSimulacionCredito(Simulacion_Credito_Entity simulacion_credito) {
        return simulacion_credito_repository.save(simulacion_credito);
    }

    public String deleteSimulacionCredito(int id) {
        if (simulacion_credito_repository.existsById(id)) {
            try {
                simulacion_credito_repository.deleteById(id);
                return "Se elimino con exito";
            }
            catch (Exception e) {
                return "No se elimino con exito";
            }
        }
        else{
            return "Simulacion no encontrada";
        }
    }
}
