package com.progra3.petstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;

@RestController
@RequestMapping("/Pet")
public class PetController {
	
	@Autowired
	PetService service;
	
	@GetMapping()
	@Validated
	public List<Pet> findAll(){
		
		return service.listAll();
	}
	
	@GetMapping(value = "/{id}")
	@Validated
	public Pet findPet(@PathVariable Long id) {
		
		return service.findById(id);
	}
	
	@PostMapping()
	@Validated
	public Pet createPet(@RequestBody Pet pet) {
		pet.setId(null);
		
		return service.createPet(pet);
	}
	
	@PutMapping(value = "/{id}")
	@Validated
	public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		
		return service.updatePet(id, pet);
	}
	
	@DeleteMapping(value = "/{id}")
	@Validated
	public void deletePet(@PathVariable Long id) {
		
		service.deletePet(id);
	}

}
