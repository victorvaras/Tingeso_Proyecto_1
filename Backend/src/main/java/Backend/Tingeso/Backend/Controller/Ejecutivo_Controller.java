package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Ejecutivo_Entity;
import Backend.Tingeso.Backend.Service.Ejecutivo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejecutivo/")
@CrossOrigin("*")
public class Ejecutivo_Controller {

    @Autowired
    private Ejecutivo_Service ejecutivo_Service;

    @PostMapping("nuevo")
    public ResponseEntity<Ejecutivo_Entity> nuevoEjecutivo(@RequestBody Ejecutivo_Entity ejecutivo_Entity) {
        Ejecutivo_Entity nuevo = ejecutivo_Service.newEjecutivo(ejecutivo_Entity);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Ejecutivo_Entity>> listAllEjecutivo() {
        List<Ejecutivo_Entity> ejecutivos = ejecutivo_Service.getAllEjecutivo();
        return ResponseEntity.ok(ejecutivos);
    }

    @GetMapping("{rut}")
    public ResponseEntity<Ejecutivo_Entity> getEjecutivo(@PathVariable int rut) {
        Ejecutivo_Entity ejecutivo = ejecutivo_Service.getEjecutivoByRut(rut);
        return ResponseEntity.ok(ejecutivo);
    }


}
