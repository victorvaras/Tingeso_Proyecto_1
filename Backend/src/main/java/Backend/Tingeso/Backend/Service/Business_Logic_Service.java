package Backend.Tingeso.Backend.Service;

import Backend.Tingeso.Backend.Entity.Evaluacion_Credito_Entity;
import Backend.Tingeso.Backend.Entity.Simulacion_Credito_Entity;
import Backend.Tingeso.Backend.Entity.Solicitud_Credito_Entity;
import Backend.Tingeso.Backend.Entity.Tipo_Prestamo_Entity;
import Backend.Tingeso.Backend.Repository.Evaluacion_Credito_Repository;
import Backend.Tingeso.Backend.Repository.Simulacion_Credito_Repository;
import Backend.Tingeso.Backend.Repository.Solicitud_Credito_Repository;
import Backend.Tingeso.Backend.Repository.Tipo_Prestamo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business_Logic_Service {

    @Autowired
    Simulacion_Credito_Repository simulacion_credito_repository;

    @Autowired
    Tipo_Prestamo_Repository tipo_prestamo_repository;

    @Autowired
    Tipo_Prestamo_Service tipo_prestamo_service;

    @Autowired
    Solicitud_Credito_Repository solicitud_credito_repository;

    @Autowired
    Evaluacion_Credito_Repository evaluacion_credito_repository;

    //Calcular cuota mensual de credito hipotecario             //tasa se ingrese en porcentaje ej: 4.5% es 4.5
    public int monthly_fee_calculation(Simulacion_Credito_Entity simulacion){

        Tipo_Prestamo_Entity tipoPrestamo = tipo_prestamo_repository.getById(simulacion.getId_Tipo_Prestamo());
        int monto_deseado = simulacion.getMonto_deseado();
        double tasa_anual= tipoPrestamo.getTasa_anual();
        int anios= simulacion.getPlazo_deseado();

        double tasa_mensual = tasa_anual/12/100;
        int plazo = anios * 12;

        double monto = (monto_deseado * tasa_mensual * Math.pow((1 + tasa_mensual), plazo)) /
                        (Math.pow((1 + tasa_mensual), plazo) - 1);
        return (int) monto;
    }


    //Validacion de Cuota ingreso
    public boolean validate_R1(int ingresos_cliente, int id_solicitud_Credito){

        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        int monto_deseado = solicitud.getMonto_deseado();
        double tasa_anual = tipo_prestamo_service.getTipo_prestamo(solicitud.getId_Tipo_Prestamo()).getTasa_anual();

        double tasa_mensual = tasa_anual/12/100;
        int plazo = solicitud.getPlazo_deseado();

        int cuota_mensual = (int) ((monto_deseado * tasa_mensual * Math.pow((1 + tasa_mensual), plazo)) /
                (Math.pow((1 + tasa_mensual), plazo) - 1));

        solicitud.setCuota_mensual(cuota_mensual);
        solicitud_credito_repository.save(solicitud);

        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        int relacion =  ((cuota_mensual * 100) / ingresos_cliente);

        if(relacion <= 35){
            evaluacion.setR1(true);
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }else{
            return false;
        }
    }

    public boolean validate_R2(int id_solicitud_Credito, boolean requisito){
        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        evaluacion.setR2(requisito);
        if(requisito){
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validate_R3(int id_solicitud_Credito, boolean requisito){
        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        evaluacion.setR3(requisito);
        if(requisito){
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validate_R4(int id_solicitud_Credito,int ingresos_cliente ,int deuda_total){
        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        int valor_cuota = solicitud.getCuota_mensual();

        int relacion = ((deuda_total + valor_cuota) * 100) / ingresos_cliente;
        if(relacion <= 50){
            evaluacion.setR4(true);
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }else{
            return false;
        }
    }


    public boolean validate_R5(int id_solicitud_Credito, int valor_propiedad){
        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        Tipo_Prestamo_Entity prestamo = tipo_prestamo_repository.findById(solicitud.getId_Tipo_Prestamo()).get();
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        int monto_deseado = solicitud.getMonto_deseado();
        int porcentaje_maximo_financiamiento = prestamo.getPorcentaje_maximo_financiamiento();

        int porcentaje_financiamiento = (monto_deseado * 100) / valor_propiedad;

        if(porcentaje_financiamiento <= porcentaje_maximo_financiamiento){
            evaluacion.setR5(true);
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validate_R6(int id_solicitud_Credito,int edad_cliente){
        Solicitud_Credito_Entity solicitud = solicitud_credito_repository.findById(id_solicitud_Credito);
        Evaluacion_Credito_Entity evaluacion = evaluacion_credito_repository.findById(solicitud.getId_evaluacion_credito()).get();

        int plazo_deseado = solicitud.getPlazo_deseado();

        int edad_final = edad_cliente + plazo_deseado;
        if(edad_final <=70){
            evaluacion.setR6(true);
            evaluacion_credito_repository.save(evaluacion);
            return true;
        }
        else{
            return false;
        }
    }

    public String validate_R7(boolean R71,boolean R72,boolean R73,boolean R74, boolean R75){
        int contador = 0;
        if (R71){
            contador++;
        }
        if (R72){
            contador++;
        }
        if (R73){
            contador++;
        }
        if (R74){
            contador++;
        }
        if (R75){
            contador++;
        }

        if (contador == 5){
            return "solida";
        }
        else if (contador == 4 || contador == 3) {
            return "moderada";
        }
        else {
            return "insuficiente";
        }
    }

    public boolean validate_R71(int monto_solicitado, int saldo_cuenta){
        int relacion = (saldo_cuenta * 100) / monto_solicitado;
        if(relacion >= 10){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validate_R72(int saldo, int mes_1, int mes_2, int mes_3, int mes_4, int mes_5, int mes_6,
                                int mes_7, int mes_8, int mes_9, int mes_10, int mes_11, int mes_12) {

        // Verificar que el saldo haya sido positivo en todos los meses
        if (mes_1 <= 0 || mes_2 <= 0 || mes_3 <= 0 || mes_4 <= 0 || mes_5 <= 0 || mes_6 <= 0 ||
                mes_7 <= 0 || mes_8 <= 0 || mes_9 <= 0 || mes_10 <= 0 || mes_11 <= 0 || mes_12 <= 0) {
            return false; // Si algún mes el saldo fue cero o negativo, retorna false
        }

        // Verificar si hubo retiros significativos (> 50% del saldo)
        if (mes_1 < saldo * 0.5 || mes_2 < saldo * 0.5 || mes_3 < saldo * 0.5 || mes_4 < saldo * 0.5 ||
                mes_5 < saldo * 0.5 || mes_6 < saldo * 0.5 || mes_7 < saldo * 0.5 || mes_8 < saldo * 0.5 ||
                mes_9 < saldo * 0.5 || mes_10 < saldo * 0.5 || mes_11 < saldo * 0.5 || mes_12 < saldo * 0.5) {
            return false; // Si algún mes hubo un retiro significativo, retorna false
        }

        return true; // Si pasa todas las validaciones, retorna true
    }

    public boolean validate_R73(int ingreso_mensual, int mes_1, int mes_2, int mes_3, int mes_4, int mes_5,
                                int mes_6,int mes_7, int mes_8, int mes_9, int mes_10, int mes_11, int mes_12){

        double montoMinimo = (ingreso_mensual * 0.05);

        //Se valida si todos los meses se deposito a lo menos un 5% de ingresos mensuales
        if (mes_1 >= montoMinimo && mes_2 >= montoMinimo && mes_3 >= montoMinimo && mes_4 >= montoMinimo &&
                mes_5 >= montoMinimo && mes_6 >= montoMinimo && mes_7 >= montoMinimo && mes_8 >= montoMinimo &&
                mes_9 >= montoMinimo && mes_10 >= montoMinimo && mes_11 >= montoMinimo && mes_12 >= montoMinimo) {
            return true;  // Si todos los meses cumplen con el monto mínimo, retorna true
        }
        //Se verifica si por cada trimestre, se a ingresado el 5% de ingreso mensual
        else if ((mes_1 + mes_2 + mes_3) >= montoMinimo &&
                (mes_4 + mes_5 + mes_6) >= montoMinimo &&
                (mes_7 + mes_8 + mes_9) >= montoMinimo &&
                (mes_10 + mes_11 + mes_12) >= montoMinimo) {

            return true;
        }
        //Si no se cumple ninguna de lo anterior falla
        else {
            return false;
        }
    }

    public boolean validate_R74(int antiguedad_cliente, int saldo_cuenta ,int monto_solicitado){

        int porcentaje_saldo_requerido = (saldo_cuenta * 100) / monto_solicitado;
        if(antiguedad_cliente <= 2 ){
            if (porcentaje_saldo_requerido >= 20) {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (porcentaje_saldo_requerido >= 10) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    public boolean validate_R75(int saldo_cuenta, int mes_7, int mes_8, int mes_9, int mes_10,
                                int mes_11, int mes_12) {

        double max_retiro = saldo_cuenta * 0.3;

        if( mes_7 <= max_retiro && mes_8 <= max_retiro && mes_9 <= max_retiro &&
                mes_10 <= max_retiro && mes_11 <= max_retiro && mes_12 <= max_retiro){
            return true;
        }
        else{
            return false;
        }
    }

}
