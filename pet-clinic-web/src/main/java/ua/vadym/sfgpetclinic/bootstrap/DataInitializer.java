package ua.vadym.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vadym.sfgpetclinic.model.*;
import ua.vadym.sfgpetclinic.services.OwnerService;
import ua.vadym.sfgpetclinic.services.PetTypeService;
import ua.vadym.sfgpetclinic.services.SpecialityService;
import ua.vadym.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataInitializer(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialityService specialityService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDogPetType = petTypeService.save(dog);
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded specialities...");

        Owner firstOwner = new Owner();
        firstOwner.setFirstName("Jim");
        firstOwner.setLastName("Lovell");
        firstOwner.setAddress("123 First str.");
        firstOwner.setCity("Dream City");
        firstOwner.setTelephone("12341234");

        Pet jimsPet = new Pet();
        jimsPet.setPetType(savedDogPetType);
        jimsPet.setOwner(firstOwner);
        jimsPet.setBirthDate(LocalDate.of(2018, 10,10));
        jimsPet.setName("Tyson");

        firstOwner.getPets().add(jimsPet);

        Owner secondOwner = new Owner();
        secondOwner.setFirstName("Ken");
        secondOwner.setLastName("Mattingly");
        secondOwner.setAddress("15 Second ave.");
        secondOwner.setCity("Dream City");
        secondOwner.setTelephone("55544455");

        Pet kensPet = new Pet();
        kensPet.setPetType(savedCatPetType);
        kensPet.setOwner(secondOwner);
        kensPet.setBirthDate(LocalDate.of(2018, 3, 4));
        kensPet.setName("Superman");

        secondOwner.getPets().add(kensPet);

        ownerService.save(firstOwner);
        ownerService.save(secondOwner);

        System.out.println("Loaded owners...");

        Vet firstVet = new Vet();
        firstVet.setFirstName("Sam");
        firstVet.setLastName("Smith");
        firstVet.getSpecialities().add(savedRadiology);

        Vet secondVet = new Vet();
        secondVet.setFirstName("Fred");
        secondVet.setLastName("Haise");
        secondVet.getSpecialities().add(savedSurgery);

        vetService.save(firstVet);
        vetService.save(secondVet);

        System.out.println("Loaded vets...");
    }
}
