package com.developer.joseph.idat.example.webServiceII.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.developer.joseph.idat.example.webServiceII.models.Contact;


public interface IContactService {//third

   //Register a contact
	Contact registerContact(Contact contact);
	
	//Update a contact
	Contact updateContact(Contact contact);
	
	Boolean deleteContact(Long id);
	
  //list all contacts
  List<Contact> listAllContact();
  
  //list by id contacts
  Contact listByID(Long id);
  
  
  //list information page able of contacts
  Page<Contact> listPageable(Pageable pageable);
 
  
  
  /*List<Persona> listarPersonasNativeQuery();
	
	List<Persona> getPersonasByIdQueryJPA(Long id);
	
	List<Persona> listarPersonaByIdQueryStoreProcedure(Long id);
	
	List<Persona> listarLastNamePersonaByIdQueryStoreProcedure(Long id);*/
}
