package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Evaluacion_Credito_Entity;
import Backend.Tingeso.Backend.Repository.Evaluacion_Credito_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Evaluacion_Credito_service {

    @Autowired
    Evaluacion_Credito_Repository evaluacion_credito_repository;

    public List<Evaluacion_Credito_Entity> getAllEvaluacion_Credito(){
        return evaluacion_credito_repository.findAll();
    }

    public Evaluacion_Credito_Entity getEvaluacion_Credito(int id){
        return evaluacion_credito_repository.findById(id).get();
    }

    public Evaluacion_Credito_Entity createEvaluacion_Credito(Evaluacion_Credito_Entity evaluacion_credito){
        return evaluacion_credito_repository.save(evaluacion_credito);
    }


    public Evaluacion_Credito_Entity updateEvaluacion_Credito(Evaluacion_Credito_Entity evaluacion_credito){
        return evaluacion_credito_repository.save(evaluacion_credito);
    }

    public String deleteEvaluacion_Credito(int id){
        if(evaluacion_credito_repository.existsById(id)){
            try{
                evaluacion_credito_repository.deleteById(id);
                return "Evaluacion credito eliminada";
            }
            catch(Exception e){
                return "No se puede eliminar el evaluacion credito";
            }
        }
        else{
            return "Usuario no encontrado";
        }
    }
}
