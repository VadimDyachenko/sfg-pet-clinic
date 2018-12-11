package ua.vadym.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vadym.sfgpetclinic.model.Owner;
import ua.vadym.sfgpetclinic.model.Vet;
import ua.vadym.sfgpetclinic.services.OwnerService;
import ua.vadym.sfgpetclinic.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner firstOwner = new Owner();
        firstOwner.setFirstName("Jim");
        firstOwner.setLastName("Lovell");

        Owner secondOwner = new Owner();
        secondOwner.setFirstName("Ken");
        secondOwner.setLastName("Mattingly");

        ownerService.save(firstOwner);
        ownerService.save(secondOwner);

        System.out.println("Loaded owners...");

        Vet firstVet = new Vet();
        firstVet.setFirstName("Sam");
        firstVet.setLastName("Smith");

        Vet secondVet = new Vet();
        secondVet.setFirstName("Fred");
        secondVet.setLastName("Haise");

        vetService.save(firstVet);
        vetService.save(secondVet);

        System.out.println("Loaded vets...");
    }
}
