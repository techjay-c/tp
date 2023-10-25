package seedu.address.model;

import java.util.function.Predicate;

import seedu.address.model.person.dentist.Dentist;

/**
 * A predicate to filter dentists based on a specified attribute and keywords.
 * <p>
 * This class implements the Predicate interface for filtering Dentist objects.
 * It allows you to specify an attribute and a set of keywords, and then it checks if
 * the specified attribute of a Dentist matches the given keywords.
 * <p>
 * The available attributes for filtering include: name, phone, email, address,
 * yoe, specialization and tag.
 */
public class DentistAttributeContainsKeywordsPredicate implements Predicate<Dentist> {
    private final String attribute;
    private final String keywords;

    /**
     * Constructs an AttributeContainsKeywordsPredicate.
     *
     * @param attribute The attribute to filter by (e.g., name, specialization, email).
     * @param keywords  The keywords to search for within the specified attribute.
     */
    public DentistAttributeContainsKeywordsPredicate(String attribute, String keywords) {
        this.attribute = attribute;
        this.keywords = keywords;
    }

    /**
     * Tests if a Dentist object satisfies the predicate condition.
     *
     * @param dentist The Dentist object to be tested.
     * @return true if the specified attribute of the dentist matches the keywords; false otherwise.
     */
    @Override
    public boolean test(Dentist dentist) {

        switch (attribute.toLowerCase()) {
        case "email":
            String email = dentist.getEmail().toString();
            return email.contains(keywords.toLowerCase());
        case "tags":
            String tags = dentist.getTags().toString();
            return tags.contains(keywords.toLowerCase());
        case "phone":
            String phone = dentist.getPhone().toString();
            return phone.contains(keywords.toLowerCase());
        case "name":
            return keywords.equalsIgnoreCase(dentist.getName().toString());
        case "experience":
            String exp = dentist.getYoe().toString();
            return exp.toLowerCase().contains(keywords.toLowerCase());
        case "address":
            String add = dentist.getAddress().toString();
            return add.toLowerCase().contains(keywords.toLowerCase());
        case "specialization":
            String spec = dentist.getSpecialization().toString();
            return spec.toLowerCase().contains(keywords.toLowerCase());
        default:
            return false;
        }
    }
}
