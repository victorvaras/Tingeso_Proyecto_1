package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Capacidad_Ahorro_Entity;
import Backend.Tingeso.Backend.Repository.Capacidad_Ahorro_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Capacidad_Ahorro_Service {

    @Autowired
    Capacidad_Ahorro_Repository capacidad_Ahorro_Repository;

    public List<Capacidad_Ahorro_Entity> getAllCapacidad_Ahorro(){
        return capacidad_Ahorro_Repository.findAll();
    }

    public Capacidad_Ahorro_Entity getById(int id){
        return capacidad_Ahorro_Repository.findById(id).get();
    }

    public Capacidad_Ahorro_Entity saveCapacidad_Ahorro(Capacidad_Ahorro_Entity Capacidad_Ahorro){
        return capacidad_Ahorro_Repository.save(Capacidad_Ahorro);
    }

    public Capacidad_Ahorro_Entity update_Capacidad_Ahorro(Capacidad_Ahorro_Entity Capacidad_Ahorro){
        return capacidad_Ahorro_Repository.save(Capacidad_Ahorro);
    }

    public String deleteCapacidad_Ahorro(int id){

        if(capacidad_Ahorro_Repository.existsById(id)){
            try {
                capacidad_Ahorro_Repository.deleteById(id);
                return "Eliminado con exito";
            }
            catch (Exception e) {
                return "Error al eliminar el capacidad Ahorro";
            }
        } else{
            return "No existe el capacidad Ahorro";
        }

    }
}
