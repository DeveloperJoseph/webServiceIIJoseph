package com.developer.joseph.idat.example.webServiceII.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.developer.joseph.idat.example.webServiceII.interfaces.IContactDAO;
import com.developer.joseph.idat.example.webServiceII.interfaces.IContactService;
import com.developer.joseph.idat.example.webServiceII.models.Contact;


@Service
public class ContactService implements IContactService{

	@Autowired
	private IContactDAO contacDAO;
	
	@Override
	public List<Contact> listAllContact() {
		// return all list contacts from database
		return contacDAO.findAll();
	}

	@Override
	public Contact listByID(Long id) {
		// return list by id contact from database
	    return contacDAO.findById(id).orElse(null);
	}

	@Override
	public Page<Contact> listPageable(Pageable pageable) {
		// return all list contacts  from database , with information page able
		return contacDAO.findAll(pageable);
	}

	@Override
	public Contact registerContact(Contact contact) {
       //register contact JPA
		return contacDAO.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		// update contact with JPA
		return contacDAO.save(contact);
	}

	@Override
	public Boolean deleteContact(Long id) {
		//find a contact
		Contact contact =  contacDAO.findById(id).orElse(null);
		if(contact != null) {
			//delete contact
			contacDAO.deleteById(id);
			return true;
		}
		return false;
	}

	
	/*
	 * 
	 * 	@Override
	public List<Persona> getPersonasByIdQueryJPA(Long id) {
		return personaDao.listPersonasQueryJPA(id);
	}

	
	@Override
	public List<Persona> listarPersonaByIdQueryStoreProcedure(Long id) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		List<Object[]> listaQuery = personaDao.listPersonasQueryStoreProcedure(id);
		for(Object[] objPersona: listaQuery) {
			Persona persona = new Persona();
			persona.setIdPersona(Long.valueOf(objPersona[0].toString()));
			persona.setNombres(objPersona[1].toString());
			persona.setApellidos(objPersona[2].toString());
			listaPersonas.add(persona);
		}
		return listaPersonas;
	}

	@Override
	public List<Persona> listarLastNamePersonaByIdQueryStoreProcedure(Long id) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		List<Object[]> listaQuery = personaDao.listLastNamePersonasQueryStoreProcedure(id);
		for(Object[] objPersona: listaQuery) {
			Persona persona = new Persona();
			persona.setNombres(objPersona[0].toString());
			persona.setIdPersona(Long.valueOf(objPersona[1].toString()));
			persona.setApellidos(objPersona[2].toString());
			listaPersonas.add(persona);
		}
		return listaPersonas;
	}
	 * */
}
