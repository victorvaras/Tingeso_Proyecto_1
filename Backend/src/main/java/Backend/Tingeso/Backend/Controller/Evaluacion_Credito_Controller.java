package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Evaluacion_Credito_Entity;
import Backend.Tingeso.Backend.Service.Evaluacion_Credito_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluacion_credito/")
@CrossOrigin
public class Evaluacion_Credito_Controller {

    @Autowired
    Evaluacion_Credito_service evaluacion_credito_service;


    @PostMapping("nuevo")
    public ResponseEntity<Evaluacion_Credito_Entity> nuevoEvaluacionCredito() {
        Evaluacion_Credito_Entity nuevo = evaluacion_credito_service.createEvaluacion_Credito();
        return ResponseEntity.ok(nuevo);
    }


    @GetMapping
    public ResponseEntity<List<Evaluacion_Credito_Entity>> listEvaluacionCredito() {
        List<Evaluacion_Credito_Entity> evaluaciones = evaluacion_credito_service.getAllEvaluacion_Credito();
        return ResponseEntity.ok(evaluaciones);
    }

    @GetMapping("{id}")
    public ResponseEntity<Evaluacion_Credito_Entity> getEvaluacionCredito(@PathVariable int id) {
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_service.getEvaluacion_Credito(id);
        return ResponseEntity.ok(evaluacion);
    }

    @PutMapping("update")
    public ResponseEntity<Evaluacion_Credito_Entity> updateEvaluacionCredito(@RequestBody Evaluacion_Credito_Entity evaluacion_credito) {
        Evaluacion_Credito_Entity update = evaluacion_credito_service.updateEvaluacion_Credito(evaluacion_credito);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEvaluacionCredito(@PathVariable int id) {
        String delete = evaluacion_credito_service.deleteEvaluacion_Credito(id);
        return ResponseEntity.ok(delete);
    }


}
