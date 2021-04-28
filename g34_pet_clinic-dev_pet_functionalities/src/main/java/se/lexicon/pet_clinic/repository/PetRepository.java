package se.lexicon.pet_clinic.repository;


public interface PetRepository  extends CrudRepository <Pet,String>{
    Optional<Pet> findByNameIgnoreCase(String name);
    List<Pet> findAll();
    List<Pet>findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
    List<Pet>findByTelephone(String telephone);
    List<Pet>findByPetTypeNameIgnoreCase(String petTypeName);


    // todo: implement basic CRUD

    //todo: select pet by name
    //todo: select pet by pet type name
    //todo: select pet by owner first name and last name
    //todo: select pet by owner telephone
}
