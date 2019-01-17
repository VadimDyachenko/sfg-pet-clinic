package ua.vadym.sfgpetclinic.formatters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ua.vadym.sfgpetclinic.model.PetType;
import ua.vadym.sfgpetclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();

        return petTypes.stream()
                .filter(t -> t.getName().equals(text))
                .findFirst()
                .orElseThrow(() -> new ParseException("Type not found: " + text, 0));
    }
}
