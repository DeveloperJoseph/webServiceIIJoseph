package com.developer.joseph.idat.example.webServiceII.interfaces;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.developer.joseph.idat.example.webServiceII.models.Contact;

public interface IContactDAO 
extends JpaRepository<Contact, Long>{//second

	
	/*
	  
	 * @Query(value = "from Persona persona where persona.idPersona =:id_persona")
	List<Persona> listPersonasQueryJPA( @Param("id_persona") Long id);
	
	//native query SQL 
	@Query(value = "SELECT id_persona, nombres from tblPersona",nativeQuery = true)
	List<Object[]> listPersonasNativeQuery();

	@Query(value = "exec dbo.sp_getPersonaByID ?",nativeQuery = true)
	List<Object[]> listPersonasQueryStoreProcedure(Long id);
	
	@Query(value = "exec dbo.sp_getPersonaByOnlyID ?", nativeQuery = true)
	List<Object[]> listLastNamePersonasQueryStoreProcedure(Long id);
	
	 * */
}
