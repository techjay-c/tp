package seedu.address.model;

import java.util.function.Predicate;

import seedu.address.model.person.patients.Patient;

/**
 * A predicate to filter patients based on a specified attribute and keywords.
 *
 * This class implements the Predicate interface for filtering Patient objects.
 * It allows you to specify an attribute and a set of keywords, and then it checks if
 * the specified attribute of a Patient matches the given keywords.
 *
 * The available attributes for filtering include: gender, birthday, email, phone,
 * tags, name, remark, service, and address.
 *
 */
public class AttributeContainsKeywordsPredicate implements Predicate<Patient> {
    private final String attribute;
    private final String keywords;

    /**
     * Constructs an AttributeContainsKeywordsPredicate.
     *
     * @param attribute The attribute to filter by (e.g., gender, birthday, email).
     * @param keywords The keywords to search for within the specified attribute.
     */
    public AttributeContainsKeywordsPredicate(String attribute, String keywords) {
        this.attribute = attribute;
        this.keywords = keywords;
    }

    /**
     * Tests if a Patient object satisfies the predicate condition.
     *
     * @param patient The Patient object to be tested.
     * @return true if the specified attribute of the patient matches the keywords;
     *         false otherwise.
     */
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
