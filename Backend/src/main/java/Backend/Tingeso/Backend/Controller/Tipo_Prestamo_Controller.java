package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Tipo_Prestamo_Entity;
import Backend.Tingeso.Backend.Service.Tipo_Prestamo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_prestamo/")
@CrossOrigin
public class Tipo_Prestamo_Controller {

    @Autowired
    private Tipo_Prestamo_Service tipo_prestamo_service;

    @PostMapping("nuevo")
    public ResponseEntity<Tipo_Prestamo_Entity> nuevoTipoPrestamo(@RequestBody Tipo_Prestamo_Entity tipo_prestamo) {
        Tipo_Prestamo_Entity nuevo = tipo_prestamo_service.createTipo_prestamo(tipo_prestamo);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Tipo_Prestamo_Entity>> getAllTipoPrestamo() {
        List<Tipo_Prestamo_Entity> tipos = tipo_prestamo_service.getAllTipo_prestamo();
        return ResponseEntity.ok(tipos);

    }

    @GetMapping("{id}")
    public ResponseEntity<Tipo_Prestamo_Entity> getTipoPrestamoById(@PathVariable int id) {
        Tipo_Prestamo_Entity tipo = tipo_prestamo_service.getTipo_prestamo(id);
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("update")
    public ResponseEntity<Tipo_Prestamo_Entity> updateTipoPrestamo(@RequestBody Tipo_Prestamo_Entity tipo_prestamo) {
        Tipo_Prestamo_Entity update = tipo_prestamo_service.updateTipo_prestamo(tipo_prestamo);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTipoPrestamo(@PathVariable int id) {
        String delete = tipo_prestamo_service.deleteTipo_prestamo(id);
        return ResponseEntity.ok(delete);
    }
}
