package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Seguimiento_Solicitud_Entity;
import Backend.Tingeso.Backend.Repository.Seguimiento_Solicitud_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Seguimiento_Solicitud_Service {

    @Autowired
    Seguimiento_Solicitud_Repository seguimiento_Solicitud_Repository;

    public List<Seguimiento_Solicitud_Entity> getAllSeguimiento_Solicitud(){
        return seguimiento_Solicitud_Repository.findAll();
    }

    public Seguimiento_Solicitud_Entity getSeguimiento_Solicitud(int id){
        return seguimiento_Solicitud_Repository.findById(id).get();
    }

    public Seguimiento_Solicitud_Entity newSeguimiento_Solicitud(Seguimiento_Solicitud_Entity entity){
        return seguimiento_Solicitud_Repository.save(entity);
    }

    public Seguimiento_Solicitud_Entity updateSeguimiento_Solicitud(Seguimiento_Solicitud_Entity entity){
        return seguimiento_Solicitud_Repository.save(entity);
    }

    public String deleteSeguimiento_Solicitud(int id){
        if (seguimiento_Solicitud_Repository.existsById(id)){
            try {
                seguimiento_Solicitud_Repository.deleteById(id);
                return "Seguimiento_Solicitud eliminado";
            }
            catch (Exception e){
                return "Error al eliminar el seguimiento solicitud";
            }

        }
        else{
            return "No se puede eliminar el seguimiento";
        }

    }
}
