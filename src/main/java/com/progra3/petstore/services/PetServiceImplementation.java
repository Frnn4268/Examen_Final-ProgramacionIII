package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progra3.petstore.DAO.PetDAO;
import com.progra3.petstore.Exceptions.NotFoundException;
import com.progra3.petstore.entities.Pet;

@Service
public class PetServiceImplementation implements PetService{

	@Autowired
	private PetDAO petDao;
	
	@Override
	public List<Pet> listAll() {
		
		return (List<Pet>) petDao.findAll();
		
	}

	@Override
	public Pet findById(Long id) {
		if(petDao.existsById(id)) {
			Optional<Pet> ob = petDao.findById(id);
		
			return ob.get();	
			
		} else throw new NotFoundException("Mascota no encontrada");
		
	}

	@Override
	public Pet createPet(Pet pet) {
		petDao.save(pet);
		
		return pet;
	}
	
	@Override
	public Pet updatePet(Long id, Pet pet) {
		if(petDao.existsById(id)) {
			pet.setId(id);
			petDao.save(pet);
			
		} else throw new NotFoundException("Mascota no encontrada");
		
		return pet;
	}

	@Override
	public void deletePet(Long id) {
	if(petDao.existsById(id)) 
		petDao.deleteById(id);
	
	else throw new NotFoundException("Mascota no encontrada");
		
	}

}
