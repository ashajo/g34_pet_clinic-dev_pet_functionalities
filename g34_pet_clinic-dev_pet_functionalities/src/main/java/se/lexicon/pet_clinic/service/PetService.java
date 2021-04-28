package se.lexicon.pet_clinic.service;

public interface PetService {
PetDto save(PetDto dto);
PetDto update(PetDto dto);
List<PetDto>findAll();
PetDto findById(String id);
PetDto findByName(String name);
PetDto findByPetTypeName(String name);

    // todo: define SAVE, UPDATE, DELETE, Find All, FIND BY ID, find By Name, find By PetTypeName, find By OwnerFirstNameAndLastName, find By OwnerTelephone

}
