package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Cliente_Entity;
import Backend.Tingeso.Backend.Repository.Cliente_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cliente_service {

    @Autowired
    Cliente_Repository cliente_repository;

    public List<Cliente_Entity> getClientes() {
        return cliente_repository.findAll();
    }

    public Cliente_Entity getClienteByRut(int rut) {
        return cliente_repository.findByRut(rut);
    }

    public Cliente_Entity createCliente(Cliente_Entity cliente) {
        return cliente_repository.save(cliente);
    }

    public Cliente_Entity updateCliente(Cliente_Entity cliente) {
        return cliente_repository.save(cliente);
    }

    public String deleteCliente(int id) {

        if(cliente_repository.existsById(id)) {
            try {
                cliente_repository.deleteById(id);
                return "Cliente eliminado con exito";
            }
            catch (Exception e) {
                return "Error al eliminar el cliente";
            }
        }
        else {
            return "Error al eliminar el cliente";
        }
    }


}
