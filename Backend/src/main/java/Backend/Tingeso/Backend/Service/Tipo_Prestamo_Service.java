package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Tipo_Prestamo_Entity;
import Backend.Tingeso.Backend.Repository.Tipo_Prestamo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_Prestamo_Service {

    @Autowired
    Tipo_Prestamo_Repository tipo_prestamo_repository;

    public List<Tipo_Prestamo_Entity> getAllTipo_prestamo() {
        return tipo_prestamo_repository.findAll();
    }

    public Tipo_Prestamo_Entity getTipo_prestamo(int id) {
        return tipo_prestamo_repository.findById(id).get();
    }

    public Tipo_Prestamo_Entity createTipo_prestamo(Tipo_Prestamo_Entity tipo_prestamo) {
        return tipo_prestamo_repository.save(tipo_prestamo);
    }

    public Tipo_Prestamo_Entity updateTipo_prestamo(Tipo_Prestamo_Entity tipo_prestamo) {
        return tipo_prestamo_repository.save(tipo_prestamo);
    }

    public String deleteTipo_prestamo(int id) {

        if (tipo_prestamo_repository.existsById(id)) {
            try {
                tipo_prestamo_repository.deleteById(id);
                return "Tipo de prestamo removido com exito";
            }
            catch (Exception e) {
                return "Tipo de prestamo no removido";
            }
        }else{
            return "Tipo de prestamo no encontrado";
        }
    }
}
