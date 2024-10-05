package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Ejecutivo_Entity;
import Backend.Tingeso.Backend.Repository.Cliente_Repository;
import Backend.Tingeso.Backend.Repository.Ejecutivo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ejecutivo_Service {

    @Autowired
    private Ejecutivo_Repository ejecutivo_repository;
    @Autowired
    private Cliente_Repository cliente_Repository;

    public List<Ejecutivo_Entity> getAllEjecutivo(){
        return ejecutivo_repository.findAll();
    }

    public Ejecutivo_Entity getEjecutivoByRut(int rut){
        return ejecutivo_repository.findByRut(rut);
    }

    public Ejecutivo_Entity newEjecutivo(Ejecutivo_Entity ejecutivo){
        return ejecutivo_repository.save(ejecutivo);
    }

    public Ejecutivo_Entity updateEjecutivo(Ejecutivo_Entity ejecutivo){
        return ejecutivo_repository.save(ejecutivo);
    }

    public String deleteEjecutivo(int id){

        if(ejecutivo_repository.existsById(id)){
            try {
                cliente_Repository.deleteById(id);
                return "Ejecutivo removido con exito";
            }
            catch(Exception e){
                return "Error al remover el Ejecutivo";
            }
        }
        else {
            return "El Ejecutivo no existe";
        }
    }


}
