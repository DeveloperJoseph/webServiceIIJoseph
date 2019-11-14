package com.developer.joseph.idat.example.webServiceII.controller;



import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.joseph.idat.example.webServiceII.interfaces.IContactService;
import com.developer.joseph.idat.example.webServiceII.models.Contact;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private IContactService myService;
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() throws IOException{
		List<Contact> listContacts = myService.listAllContact();
		return new ResponseEntity<List<Contact>>(listContacts,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "list/{id}")
	public ResponseEntity<Contact> getContactsById(
			@PathVariable("id")Long id)throws IOException{
		Contact contact = myService.listByID(id);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "pageable")
	public ResponseEntity<Page<Contact>> getContactsPageable(Pageable pageable)
	{
		Page<Contact> contacts;
		contacts = myService.listPageable(pageable);
		return new ResponseEntity<Page<Contact>>(contacts, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "create")
	public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact)
	{
		Contact newContact = myService.registerContact(contact);
		if(newContact.equals(null)) {
			return new ResponseEntity<Contact>(HttpStatus.BAD_REQUEST);
		}
		//print saved  contact 
		System.out.println(contact.toString());
		return new ResponseEntity<Contact>(newContact,HttpStatus.CREATED);
	}

	
	@PutMapping(value = "update")
	public ResponseEntity<Contact> updateContact(@Valid @RequestBody Contact contact)
	{
		Contact updateContact = myService.updateContact(contact);
		if(updateContact.equals(null)) {
			return new ResponseEntity<Contact>(HttpStatus.BAD_REQUEST);
		}
		//print saved  contact to string result front end
		System.out.println(contact.toString());			
		return new ResponseEntity<Contact>(updateContact,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteContact(@PathVariable("id") Long id) {
		return myService.deleteContact(id);
	}
	
	
	/*@GetMapping(value = "listpersonsnativequery")
	public ResponseEntity<List<Persona>> getPersonasNativeQuery(){
		
		List<Persona> listaPersona =  service.listarPersonasNativeQuery();
		if(listaPersona.equals(null)) {
			listaPersona = new ArrayList<Persona>();
		}
		return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "listpersonbyidqueryjpa/{id}")
	public ResponseEntity<List<Persona>> getPersonaById(@PathVariable("id") Long id){
		
		List<Persona> listaPersona =  service.getPersonasByIdQueryJPA(id);
		
		if(listaPersona.equals(null)) {
			listaPersona = new ArrayList<Persona>();
		}
		return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "listpersonbyidquerystoreprocedure")
	public ResponseEntity<List<Persona>> getPersonasQueryStoreProcedure(Long id){
		
		List<Persona> listaPersona =  service.listarPersonaByIdQueryStoreProcedure(id);
		if(listaPersona.equals(null)) {
			listaPersona = new ArrayList<Persona>();
		}
		return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
	}
	
	*/
}
