package com.developer.joseph.idat.example.webServiceII.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.joseph.idat.example.webServiceII.models.Factura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/examen")
@Api(value = "Servicio REST de Examenes IDAT")
public class ExamenController {

	//database List 
    static List<Factura> listaFacturas = new ArrayList<Factura>();
    
    @GetMapping("/facturas")
    public List<Factura> getAllFacturas() {return listaFacturas;}

    @PostMapping("newFactura/{numero}")
    @ApiOperation("Add new facturas")
    public String saveFactura (@PathVariable("numero") String numero,
    		@RequestParam Double subtotal, @RequestParam Double descuento,
            @RequestParam Double impuesto ) {
    	
    	listaFacturas.add(new Factura(numero,subtotal,descuento,impuesto));
    	return "[W] Factura generated with number:  "+numero;
    }
	
    
    @GetMapping("resultNumeroFacturasAndMontotal/{name}")
    @ApiOperation("Result numero de facturas y monto total")
    public String resultNumeroFacturasAndMontotal(
    		@PathVariable("name") String name) {
    	
    	//get view date time consult and formatter date time
    	LocalDateTime dateTimeConsult =  LocalDateTime.now();
    	DateTimeFormatter formatterDateTimeConsult =
    			DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
    	String obteniendoHorayFechaConsult = dateTimeConsult.format
    			(formatterDateTimeConsult);//format
    	
    	//get results
    	Double montoTotal=0.0, impuestoTotal=0.0;
    	for(int i=0;i<listaFacturas.size();i++)
    	{
    		impuestoTotal += listaFacturas.get(i).getImpuesto();
    		montoTotal += listaFacturas.get(i).getTotal();
    	}
    	
    	String cantFacturasGenerated = String.valueOf(listaFacturas.size());//size
    	String resultFinalExamen1 = String.
    			format("[#] Hola %s \n"
    					+ "- Cantidad de facturas generadas: %s\n"
    					+ "- Monto total de facturas es S/.%s y el impuesto total generado es S/.%s \n"
    					+ "- Fecha de consulta: %s ",name, cantFacturasGenerated,String.valueOf(montoTotal),
    					String.valueOf(impuestoTotal), obteniendoHorayFechaConsult);
    	
    	return resultFinalExamen1;
    }

}
