package seedu.address.model.person.dentist;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
//import seedu.address.model.person.patient.Patient;
import seedu.address.model.tag.Tag;
/**
 * Represents a Dentist in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Dentist extends Person {
    // Identity fields
    private final Specialization specialization;
    private final String yoe;

    /**
     * Initializes {@code Dentist} object without {@code patients}.
     * Every field must be present and not null.
     */
    public Dentist(Name name, Phone phone, Email email, Address address,
                   Specialization specialization, String yoe, Set<Tag> tags) {
        super(name, phone, email, address, tags);
        requireAllNonNull(name, phone, email, address, specialization, yoe, tags);
        this.specialization = specialization;
        this.yoe = yoe;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public String getYoe() {
        return yoe;
    }

    /**
     * Returns true if both dentists have the same name.
     */
    public boolean isSameDentist(Dentist otherDentist) {
        if (otherDentist == this) {
            return true;
        }

        return otherDentist != null
                && otherDentist.getName().equals(getName());
    }

    /**
     * Returns true if both dentists have all identical data fields.
     * This defines a stronger notion of equality between two dentists.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Dentist)) {
            return false;
        }

        Dentist otherDentist = (Dentist) other;
        return otherDentist.getName().equals(getName())
                && otherDentist.getPhone().equals(getPhone())
                && otherDentist.getEmail().equals(getEmail())
                && otherDentist.getSpecialization().equals(getSpecialization())
                && otherDentist.getYoe().equals(getYoe())
                && otherDentist.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(getName(), getPhone(), getEmail(), getSpecialization(), getYoe(), getTags());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Specialization: ")
                .append(getSpecialization())
                .append("; Years Of Experience: ")
                .append(getYoe());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        return builder.toString();
    }
}