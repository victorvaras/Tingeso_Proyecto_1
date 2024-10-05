package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Entity.Cliente_Entity;
import Backend.Tingeso.Backend.Repository.Cliente_Repository;
import Backend.Tingeso.Backend.Service.Cliente_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente/")
@CrossOrigin
public class Cliente_Controller {

    @Autowired
    Cliente_service cliente_service;

    @PostMapping("nuevo")
    public ResponseEntity<Cliente_Entity> newCliente(@RequestBody Cliente_Entity cliente) {
        Cliente_Entity nuevo = cliente_service.createCliente(cliente);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente_Entity>> getAllClientes() {
        List<Cliente_Entity> clientes = cliente_service.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{rut}")
    public ResponseEntity<Cliente_Entity> getClienteById(@PathVariable int rut) {
        Cliente_Entity cliente = cliente_service.getClienteByRut(rut);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("update")
    public ResponseEntity<Cliente_Entity> updateCliente(@RequestBody Cliente_Entity cliente) {
        Cliente_Entity update= cliente_service.updateCliente(cliente);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id) {
        String delete = cliente_service.deleteCliente(id);
        return ResponseEntity.ok(delete);
    }


}
