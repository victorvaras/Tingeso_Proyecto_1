package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Service.Business_Logic_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/business_logic/")
@CrossOrigin("*")
public class business_Logic_Controller {

    @Autowired
    private Business_Logic_Service business_LogicService;

    /*
    @GetMapping("monthly/{capital}/{tasa}/{anios}")
    public double monthly_fee_calculation(@PathVariable int capital, @PathVariable double tasa, @PathVariable int anios){
        double monto = business_LogicService.monthly_fee_calculation(capital, tasa,anios);
        return monto;
    }
    */

    @GetMapping("validate_r1/{ingreso_cliente}/{id_solicitud_Credito}")
    public boolean validate_R1(@PathVariable int ingreso_cliente, @PathVariable int id_solicitud_Credito){
        boolean R1 = business_LogicService.validate_R1(ingreso_cliente,id_solicitud_Credito);
        return business_LogicService.validate_R1(ingreso_cliente,id_solicitud_Credito);
    }

    @GetMapping("validate_r2/{id_solicitud_Credito}/{requisito}")
    public boolean validate_R2(@PathVariable int id_solicitud_Credito, @PathVariable boolean requisito){
        return business_LogicService.validate_R2(id_solicitud_Credito,requisito);
    }

    @GetMapping("validate_r3/{id_solicitud_Credito}/{requisito}")
    public boolean validate_R3(@PathVariable int id_solicitud_Credito, @PathVariable boolean requisito){
        return business_LogicService.validate_R3(id_solicitud_Credito,requisito);
    }

    @GetMapping("validate_r4/{id_solicitud_Credito}/{ingresos_cliente}/{deuda_total}")
    public boolean validate_R4(@PathVariable int id_solicitud_Credito,@PathVariable int ingresos_cliente ,@PathVariable int deuda_total){
        return business_LogicService.validate_R4(id_solicitud_Credito,ingresos_cliente,deuda_total);
    }

    @GetMapping("validate_r5/{id_solicitud_Credito}/{valor_propiedad}")
    public boolean validate_R5(@PathVariable int id_solicitud_Credito, @PathVariable int valor_propiedad){
        return business_LogicService.validate_R5(id_solicitud_Credito, valor_propiedad);
    }

    @GetMapping("validate_r6/{id_solicitud_Credito}/{edad_cliente}")
    public boolean validate_R6(@PathVariable int id_solicitud_Credito, @PathVariable int edad_cliente){
        return business_LogicService.validate_R6(id_solicitud_Credito,edad_cliente);
    }

    @GetMapping("validate_r7/{r71}/{r72}/{r73}/{r74}/{r75}")
    public String validate_R7(@PathVariable boolean r71, @PathVariable boolean r72, @PathVariable boolean r73, @PathVariable boolean r74, @PathVariable boolean r75){
        return business_LogicService.validate_R7(r71,r72,r73,r74,r75);
    }

    @GetMapping("validate_r71/{monto_solicitado}/{saldo_cuenta}")
    public boolean validate_R71(@PathVariable int monto_solicitado, @PathVariable int saldo_cuenta){
        return business_LogicService.validate_R71(monto_solicitado,saldo_cuenta);
    }
}
