package com.developer.joseph.idat.example.webServiceII.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.joseph.idat.example.webServiceII.dto.WomenAndUbicationsDTO;
import com.developer.joseph.idat.example.webServiceII.models.Properties;
import com.developer.joseph.idat.example.webServiceII.models.Ubications;
import com.developer.joseph.idat.example.webServiceII.models.Women;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/womens")
@Api(value = "Servicio de informacion de mujeres")
public class WomenController {

	
	//private final Logger getLOGS = Logger.getLogger(WomenController.class);
	
	@Autowired
	private Properties properties;


	@GetMapping(value = "/listWomens")
	public List<Women> listarWomens(){
	  
	    List<Women> listaWomen = new ArrayList<Women>();
		listaWomen.add(new Women(1, "Amelia", "Kala", 19, 1, properties.getCompanyNameMain()));
		listaWomen.add(new Women(2, "Briseida", "Guerrero", 20, 2, properties.getCompanyNameSecondMain()));
		listaWomen.add(new Women(3, "Karen", "Ayala", 18, 3, properties.getCompanyNameSecondMain()));
	
		return listaWomen;
	}
	

	@GetMapping(value = "/listWomensDTO")
	public List<WomenAndUbicationsDTO> listarWomensDTO(){
		//implement log info
	
		List<WomenAndUbicationsDTO> listaWomenDTO =  new ArrayList<WomenAndUbicationsDTO>();
		
		
		List<Women> listaWomen = new ArrayList<Women>();
		
		listaWomen.add(new Women(1, "Amelia", "Kala", 19, 1, properties.getCompanyNameMain()));
		listaWomen.add(new Women(2, "Briseida", "Guerrero", 20, 2, properties.getCompanyNameSecondMain()));
		listaWomen.add(new Women(3, "Karen", "Ayala", 18, 3, properties.getCompanyNameSecondMain()));
		
		for(Women women : listaWomen) {
			WomenAndUbicationsDTO womenDTO = new WomenAndUbicationsDTO(
					women.getNameWomen()+" "+women.getLastNameWomen(),women.getEdad(),
					getNameUbication(women.getUbicationID()));
			listaWomenDTO.add(womenDTO);
		}
	
		return listaWomenDTO;
	}
	
	
	
	
	String getNameUbication(Integer ubicationID) {
		
		List<Ubications> listUbications = new ArrayList<Ubications>();
		listUbications.add(new Ubications(1, "Mifaflores (Parque Kenedy)"));
		listUbications.add(new Ubications(2, "San Borja (Pentagonito)"));
		listUbications.add(new Ubications(3, "Cercado Lima (Parque de la Exposicion)"));	
		
		String descriptionUbication = "Ubication no definida";
		for(Ubications ubication : listUbications) {
			if(ubication.getUbicationID()==ubicationID) {
				descriptionUbication = ubication.getDescriptionUbication();//get description
			}
		}
			
		return descriptionUbication;
	}
}
