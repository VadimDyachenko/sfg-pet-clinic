package ua.vadym.sfgpetclinic.formatters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.vadym.sfgpetclinic.model.PetType;
import ua.vadym.sfgpetclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetTypeFormatterTest {

    @Mock
    private PetTypeService petTypeService;

    @InjectMocks
    private PetTypeFormatter formatter;

    @Test
    @DisplayName("Test assert ParseException when Pet type not found")
    void parseUnknownPetType() {
        when(petTypeService.findAll()).thenReturn(Collections.emptySet());
        ParseException exception = assertThrows(
                ParseException.class, () -> formatter.parse("WrongType", Locale.ENGLISH)
        );
        assertEquals("Type not found: WrongType", exception.getMessage());
        verify(petTypeService, times(1)).findAll();
    }

    @Test
    @DisplayName("Test parse Pet type")
    void parse() throws ParseException {
        PetType cat = PetType.builder().id(1L).name("Cat").build();
        PetType dog = PetType.builder().id(2L).name("Dog").build();
        Set<PetType> petTypes = new HashSet<>(Arrays.asList(cat, dog));

        when(petTypeService.findAll()).thenReturn(petTypes);

        assertEquals(dog, formatter.parse("Dog", Locale.ENGLISH));
        verify(petTypeService, times(1)).findAll();
    }

    @Test
    @DisplayName("Test print Pet type")
    void print() {
        PetType cat = PetType.builder().id(1L).name("Cat").build();
        assertEquals("Cat", formatter.print(cat, Locale.ENGLISH));
        verifyZeroInteractions(petTypeService);
    }
}