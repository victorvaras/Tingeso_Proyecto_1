package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Evaluacion_Credito_Entity;
import Backend.Tingeso.Backend.Entity.Seguimiento_Solicitud_Entity;
import Backend.Tingeso.Backend.Entity.Solicitud_Credito_Entity;
import Backend.Tingeso.Backend.Repository.Evaluacion_Credito_Repository;
import Backend.Tingeso.Backend.Repository.Solicitud_Credito_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Solicitud_Credito_Service {

    @Autowired
    private Solicitud_Credito_Repository solicitud_Credito_Repository;

    public List<Solicitud_Credito_Entity> getAllSolicitud_Credito(){
        return solicitud_Credito_Repository.findAll();
    }

    public Solicitud_Credito_Entity getSolicitud_Credito(int id){
        return solicitud_Credito_Repository.findById(id).get();
    }

    @Autowired
    Evaluacion_Credito_service evaluacion_credito_service;

    public Solicitud_Credito_Entity nuevaSolicitud_Credito(Solicitud_Credito_Entity solicitud_Credito){

        Evaluacion_Credito_Entity evaluacionCredito = evaluacion_credito_service.createEvaluacion_Credito();
        int id_evaluacion_credito = evaluacionCredito.getId_evaluacion_credito();

        solicitud_Credito.setId_evaluacion_credito(id_evaluacion_credito);
        solicitud_Credito.setId_seguimiento_solicitud(1);

        return solicitud_Credito_Repository.save(solicitud_Credito);
    }

    public Solicitud_Credito_Entity updateSolicitud_Credito(Solicitud_Credito_Entity solicitud_Credito){
        return solicitud_Credito_Repository.save(solicitud_Credito);
    }

    public String deleteSolicitud_Credito(int id){
        if(solicitud_Credito_Repository.existsById(id)){
            try {
                solicitud_Credito_Repository.deleteById(id);
                return "Solicitud Credito eliminada";
            }
            catch(Exception e){
                return "Solicitud Credito no eliminada";
            }
        }
        else{
            return "Solicitud Credito no encontrado";
        }
    }

}
