package Backend.Tingeso.Backend.Controller;

import Backend.Tingeso.Backend.Service.Business_Logic_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/business_logic/")
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

    @GetMapping("validate_r1/{cuota_mensual}/{ingreso_cliente}")
    public boolean validate_R1(@PathVariable int cuota_mensual, @PathVariable int ingreso_cliente){
        boolean R1 = business_LogicService.validate_R1(cuota_mensual,ingreso_cliente);
        return business_LogicService.validate_R1(cuota_mensual,ingreso_cliente);
    }

    @GetMapping("validate_r4/{deuda_total}/{ingreso_cliente}")
    public boolean validate_R4(@PathVariable int deuda_total, @PathVariable int ingreso_cliente){
        return business_LogicService.validate_R4(deuda_total,ingreso_cliente);
    }

    @GetMapping("validate_r5/{valor_propiedad}/{monto_deseado}/{porcentaje_maximo}")
    public boolean validate_R5(@PathVariable int valor_propiedad, @PathVariable int monto_deseado, @PathVariable int porcentaje_maximo){
        return business_LogicService.validate_R5(valor_propiedad,monto_deseado,porcentaje_maximo);
    }

    @GetMapping("validate_r6/{edad_cliente}/{plazo_deseado}")
    public boolean validate_R6(@PathVariable int edad_cliente, @PathVariable int plazo_deseado){
        return business_LogicService.validate_R6(edad_cliente,plazo_deseado);
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
