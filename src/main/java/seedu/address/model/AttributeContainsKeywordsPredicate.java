package seedu.address.model;

import seedu.address.model.person.patients.Patient;

import java.util.List;
import java.util.function.Predicate;

public class AttributeContainsKeywordsPredicate implements Predicate<Patient> {
    private final String attribute;
    private final String keywords;

    public AttributeContainsKeywordsPredicate(String attribute, String keywords) {
        this.attribute = attribute;
        this.keywords = keywords;
    }

    @Override
    public boolean test(Patient patient) {

        switch (attribute.toLowerCase()) {
        case "gender":
            return keywords.equalsIgnoreCase(patient.getGender().toString());
        case "birthday":
            return keywords.equals(patient.getBirthdate().toString());
        case "email":
            return keywords.equalsIgnoreCase(patient.getEmail().toString());
        case "phone":
            return keywords.equals(patient.getPhone().toString());
        case "tags":
            return keywords.equals(patient.getTags().toString());
        case "name":
            return keywords.equals(patient.getName().toString());
        default:
            return false;
        }
    }
}



