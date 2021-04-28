package se.lexicon.pet_clinic.service;

@Service
public class PetServiceImpl  implements PetService {

    PetRepository petRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PetDto save(PetDto dto) {
        if (dto == null) throw new IllegalArgumentException("PetDto object should not be null");
        if (dto.getId() != null) throw new IllegalArgumentException("Id should be null");
        Pet petEntity = modelMapper.map(dto, Pet.class);
        Pet savedPetEntity = petRepository.save(petEntity);
        PetDto convertEntityToDto = modelMapper.map(savedPetEntity, PetDto.class);
        return convertEntityToDto;
    }

    @Override
    public PetDto update(PetDto dto) throws DataNotFoundException {
        if (dto == null) throw new IllegalArgumentException("PetDto object should not be null");
        if (dto.getId() == null) throw new IllegalArgumentException("Id should not be null");
        Optional<Pet> optionalPet = petRepository.findById(dto.getId());
        if (optionalPet.isPresent()) {
            return modelMapper.map(petRepository.save(modelMapper.map(dto, Pet.class)), PetDto.class);
        } else {
            throw new DataNotFoundException("PetDto not found");
        }

    }

    @Override
    public PetDto findById(String id) throws DataNotFoundException {
        if (id == null) throw new IllegalArgumentException("Id should not be null");
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            PetDto convertedData = modelMapper.map(optionalPet.get(), PetDto.class);
            return convertedData;
        } else {
            throw new DataNotFoundException("PetDto not found");
        }
    }

    @Override
    public List<PetDto> getAll() {
        List<Pet> petList = new ArrayList<>();
        petRepository.findAll().iterator().forEachRemaining(petList::add);
        List<PetDto> petDtoList = petList.stream()
                .map(pet -> modelMapper.map(pet, PetDto.class))
                .collect(Collectors.toList());
        return petDtoList;
    }
}





