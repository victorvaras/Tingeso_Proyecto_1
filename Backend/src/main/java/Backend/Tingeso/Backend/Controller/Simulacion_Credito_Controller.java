package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Simulacion_Credito_Entity;
import Backend.Tingeso.Backend.Service.Simulacion_Credito_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulacion_credito/")
@CrossOrigin
public class Simulacion_Credito_Controller {

    @Autowired
    Simulacion_Credito_Service simulacion_credito_service;

    @PostMapping("nuevo")
    public ResponseEntity<Simulacion_Credito_Entity> newSimulacionCredito(@RequestBody Simulacion_Credito_Entity simulacion_credito) {
        Simulacion_Credito_Entity nuevo = simulacion_credito_service.newSimulacionCredito(simulacion_credito);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Simulacion_Credito_Entity>> getAllSimulacionCredito() {
        List<Simulacion_Credito_Entity> simulaciones = simulacion_credito_service.getAllSimulacionCredito();
        return ResponseEntity.ok(simulaciones);
    }

    @GetMapping("{id}")
    public ResponseEntity<Simulacion_Credito_Entity> getSimulacionCreditoById(@PathVariable int id) {
        Simulacion_Credito_Entity simulacion = simulacion_credito_service.getSimulacionCreditoById(id);
        return ResponseEntity.ok(simulacion);
    }

    @PutMapping("update")
    public ResponseEntity<Simulacion_Credito_Entity> updateSimulacionCredito(@RequestBody Simulacion_Credito_Entity simulacion_credito) {
        Simulacion_Credito_Entity update = simulacion_credito_service.updateSimulacionCredito(simulacion_credito);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSimulacionCredito(@PathVariable int id) {
        String simulacion = simulacion_credito_service.deleteSimulacionCredito(id);
        return ResponseEntity.ok(simulacion);
    }


}
