package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Seguimiento_Solicitud_Entity;
import Backend.Tingeso.Backend.Service.Seguimiento_Solicitud_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguimiento_solicitud/")
@CrossOrigin("*")
public class Seguimiento_Solicitud_Controller {

    @Autowired
    private Seguimiento_Solicitud_Service seguimiento_Solicitud_Service;

    @PostMapping("nuevo")
    private ResponseEntity<Seguimiento_Solicitud_Entity> nuevoSeguimiento_Solicitude(@RequestBody Seguimiento_Solicitud_Entity seguimiento_Solicitud) {
        Seguimiento_Solicitud_Entity nuevo = seguimiento_Solicitud_Service.newSeguimiento_Solicitud(seguimiento_Solicitud);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    private ResponseEntity<List<Seguimiento_Solicitud_Entity>> getAllSeguimiento_Solicitud() {
        List<Seguimiento_Solicitud_Entity> seguimientos = seguimiento_Solicitud_Service.getAllSeguimiento_Solicitud();
        return ResponseEntity.ok(seguimientos);
    }

    @GetMapping("{id}")
    private ResponseEntity<Seguimiento_Solicitud_Entity> obtenerSeguimiento_Solicitud(@PathVariable int id) {
        Seguimiento_Solicitud_Entity seguimieto = seguimiento_Solicitud_Service.getSeguimiento_Solicitud(id);
        return ResponseEntity.ok(seguimieto);
    }

    @PutMapping("update")
    public ResponseEntity<Seguimiento_Solicitud_Entity> updateSeguimiento_Solicitud(@RequestBody Seguimiento_Solicitud_Entity seguimiento_Solicitud) {
        Seguimiento_Solicitud_Entity update = seguimiento_Solicitud_Service.updateSeguimiento_Solicitud(seguimiento_Solicitud);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> eliminarSeguimiento_Solicitud(@PathVariable int id) {
        String delete = seguimiento_Solicitud_Service.deleteSeguimiento_Solicitud(id);
        return ResponseEntity.ok(delete);
    }

}
