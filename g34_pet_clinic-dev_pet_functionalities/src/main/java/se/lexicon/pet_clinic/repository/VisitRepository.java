package se.lexicon.pet_clinic.repository;

public interface VisitRepository extends CrudRepository<Visit,String> {
    // todo: implement basic CRUD
Visit findVisitByPetName(String name);
Visit findVisitByPetTypeName(String petTypeName);
    //todo: select visit by pet name
    //todo: select visit by pet type name
}
