package ua.vadym.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vadym.sfgpetclinic.model.Owner;
import ua.vadym.sfgpetclinic.model.Vet;
import ua.vadym.sfgpetclinic.services.OwnerService;
import ua.vadym.sfgpetclinic.services.VetService;
import ua.vadym.sfgpetclinic.services.map.OwnerServiceMap;
import ua.vadym.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner firstOwner = new Owner();
        firstOwner.setId(1L);
        firstOwner.setFirstName("Jim");
        firstOwner.setLastName("Lovell");

        Owner secondOwner = new Owner();
        secondOwner.setId(2L);
        secondOwner.setFirstName("Ken");
        secondOwner.setLastName("Mattingly");

        ownerService.save(firstOwner);
        ownerService.save(secondOwner);

        System.out.println("Loaded owners...");

        Vet firstVet = new Vet();
        firstVet.setId(1L);
        firstVet.setFirstName("Sam");
        firstVet.setLastName("Smith");

        Vet secondVet = new Vet();
        secondVet.setId(2L);
        secondVet.setFirstName("Fred");
        secondVet.setLastName("Haise");

        vetService.save(firstVet);
        vetService.save(secondVet);

        System.out.println("Loaded vets...");
    }
}
