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
            return keywords.equalsIgnoreCase(patient.getBirthdate().toString());
        case "email":
            return keywords.equalsIgnoreCase(patient.getEmail().toString());
        case "phone":
            return keywords.equalsIgnoreCase(patient.getPhone().toString());
        case "tags":
            return keywords.equalsIgnoreCase(patient.getTags().toString());
        case "name":
            return keywords.equalsIgnoreCase(patient.getName().toString());
        case "remark":
            return keywords.equalsIgnoreCase(patient.getRemark().toString());
        case "service":
            return keywords.equalsIgnoreCase(patient.getService().toString());
        case "address":
            return keywords.equalsIgnoreCase(patient.getAddress().toString());
        default:
            return false;
        }
    }
}
