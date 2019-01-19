package ua.vadym.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.vadym.sfgpetclinic.model.Pet;
import ua.vadym.sfgpetclinic.model.PetType;
import ua.vadym.sfgpetclinic.model.Visit;
import ua.vadym.sfgpetclinic.services.PetService;
import ua.vadym.sfgpetclinic.services.VisitService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    private PetService petService;

    @Mock
    private VisitService visitService;

    @InjectMocks
    private VisitController visitController;

    private MockMvc mockMvc;

    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = Pet.builder().id(1L).petType(new PetType("Dog")).build();
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        when(petService.findById(1L)).thenReturn(pet);

        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));

        verify(petService).findById(1L);
    }

    @Test
    void processNewVisitForm() throws Exception {
        when(petService.findById(1L)).thenReturn(pet);

        mockMvc.perform(post("/owners/1/pets/1/visits/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).findById(1L);
        verify(visitService).save(any(Visit.class));
    }
}
