package com.developer.joseph.idat.example.webServiceII.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.developer.joseph.idat.example.webServiceII.models.Persona;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/personas")
@Api(value = "Service Rest de la clase personas")
public class PersonaController {
	
	static List<Persona> personas = new ArrayList<Persona>();
	
	
	
	@GetMapping
	@ApiOperation("Retorna lista de Personas")
	public List<Persona> getAllPersonas(){
		return personas;
	}
	
	
	@PostMapping("Crear/{id}")
	@ApiOperation("Crear una nueva persona")
	public String addPersona(@PathVariable("id")Integer id,
			@RequestParam String name,
			@RequestParam String apellido)
	{
		personas.add(new Persona(id,name,apellido));
		String resultToString = "id: "+ String.valueOf(id)+" name: "+name+" lastname: "+apellido;
		return "[*] Registrado "+resultToString;
	}
	
	
	@GetMapping(value = "/{id}")
	public Persona getPersonaById(@PathVariable("id")Integer id) {
		Predicate<Persona> byId =  persona -> persona.getIdPersona().equals(id);
		return getAllPersonas().stream()
				.filter(byId).findFirst().orElse(null);
	}
	
	
	@PutMapping(value = "/{id}")
	@ApiOperation("Actualizar Registro Personas....")
	public Persona  updatePersona(@PathVariable("id")Integer id, @Valid @RequestBody Persona data)
	{
	          data.setIdPersona(id);
	          data.setNamePersona("Modificado..");
	          data.setLastNamePersona("Modificado..");
		
		
		if(id==1 || id == 2 || id ==3) { 
			System.out.println(data.getNamePersona());
			System.out.println(data.getLastNamePersona());
			System.out.println(data.toString() + " update succesfully..");
		}else {
			System.out.println(data.toString() + "created succesfully");
	     }
		
		return data;
	}
	
	
	
	
	
	
	
	

	
}
