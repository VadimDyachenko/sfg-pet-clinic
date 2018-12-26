package ua.vadym.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.vadym.sfgpetclinic.model.Owner;
import ua.vadym.sfgpetclinic.services.OwnerService;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerMapServiceTest {

    private OwnerService service;
    private final Long ownerId = 1L;
    private final String lastName = "Qwerty";

    @BeforeEach
    void setUp() {
        service = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        service.save(Owner.builder().identifier(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = service.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = service.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().identifier(2L).build();
        Owner savedOwner = service.save(owner);

        Set<Owner> owners = service.findAll();

        assertEquals(2, owners.size());
        assertThat(savedOwner, is(owner));
    }

    @Test
    void saveNoId() {
        Owner savedOwner = service.save(Owner.builder().build());

        Set<Owner> owners = service.findAll();

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        service.delete(service.findById(ownerId));
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = service.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = service.findByLastName("Last Name");
        assertNull(owner);
    }
}