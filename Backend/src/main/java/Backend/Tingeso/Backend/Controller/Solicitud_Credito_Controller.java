package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Solicitud_Credito_Entity;
import Backend.Tingeso.Backend.Service.Solicitud_Credito_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud_credito/")
@CrossOrigin
public class Solicitud_Credito_Controller {

    @Autowired
    private Solicitud_Credito_Service solicitud_credito_service;

    @PostMapping("nuevo")
    public ResponseEntity<Solicitud_Credito_Entity> nuevoSolicitude(@RequestBody Solicitud_Credito_Entity solicitud_credito) {
        Solicitud_Credito_Entity nuevo = solicitud_credito_service.nuevaSolicitud_Credito(solicitud_credito);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Solicitud_Credito_Entity>> getAllSolicitudes(){
        List<Solicitud_Credito_Entity> solicitudes = solicitud_credito_service.getAllSolicitud_Credito();
        return ResponseEntity.ok(solicitudes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Solicitud_Credito_Entity> getSolicitudeById(@PathVariable int id){
        Solicitud_Credito_Entity solicitud = solicitud_credito_service.getSolicitud_Credito(id);
        return ResponseEntity.ok(solicitud);
    }

    @PutMapping("update")
    public ResponseEntity<Solicitud_Credito_Entity> updateSolicitude(@RequestBody Solicitud_Credito_Entity solicitud){
        Solicitud_Credito_Entity update = solicitud_credito_service.updateSolicitud_Credito(solicitud);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSolicitude(@PathVariable int id){
        String delete = solicitud_credito_service.deleteSolicitud_Credito(id);
        return ResponseEntity.ok(delete);
    }
}
