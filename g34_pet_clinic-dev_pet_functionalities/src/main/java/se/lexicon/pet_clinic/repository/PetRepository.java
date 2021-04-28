package se.lexicon.pet_clinic.repository;


public interface PetRepository  extends CrudRepository <Pet,String>{
    Optional<Pet> findByNameIgnoreCase(String name);
    List<Pet> findAll();
    List<Owner>findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
    List<Owner>findByTelephone(String telephone);


    // todo: implement basic CRUD

    //todo: select pet by name
    //todo: select pet by pet type name
    //todo: select pet by owner first name and last name
    //todo: select pet by owner telephone
}
