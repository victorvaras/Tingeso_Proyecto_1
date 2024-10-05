package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Capacidad_Ahorro_Entity;
import Backend.Tingeso.Backend.Service.Capacidad_Ahorro_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capacidad_ahorro/")
@CrossOrigin("*")
public class Capacidad_Ahorro_Controller {

    @Autowired
    private Capacidad_Ahorro_Service capacidad_ahorro_service;

    @PostMapping("nuevo")
    public ResponseEntity<Capacidad_Ahorro_Entity> saveCapacidadAhorro(@RequestBody Capacidad_Ahorro_Entity capacidad_ahorro){
        Capacidad_Ahorro_Entity nuevo = capacidad_ahorro_service.saveCapacidad_Ahorro(capacidad_ahorro);

        return ResponseEntity.ok(nuevo);
    }


    @GetMapping
    public ResponseEntity<List<Capacidad_Ahorro_Entity>> getAllCapacidadAhorro(){

        List<Capacidad_Ahorro_Entity> empleados= capacidad_ahorro_service.getAllCapacidad_Ahorro();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("{id}")
    public ResponseEntity<Capacidad_Ahorro_Entity> getCapacidadAhorroById(@PathVariable("id") int id){
        Capacidad_Ahorro_Entity capacidadAhorroEntity = capacidad_ahorro_service.getById(id);
        return ResponseEntity.ok(capacidadAhorroEntity);
    }

    @PutMapping("update")
    public ResponseEntity<Capacidad_Ahorro_Entity> updateCapacidadAhorro(@RequestBody Capacidad_Ahorro_Entity capacidadAhorro){
        Capacidad_Ahorro_Entity updatate_Capacidad = capacidad_ahorro_service.update_Capacidad_Ahorro(capacidadAhorro);
        return ResponseEntity.ok(updatate_Capacidad);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCapacidadAhorro(@PathVariable("id") int id){
        String delete =capacidad_ahorro_service.deleteCapacidad_Ahorro(id);
        return ResponseEntity.ok(delete);
    }


}
