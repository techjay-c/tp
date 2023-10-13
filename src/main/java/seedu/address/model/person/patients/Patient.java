package seedu.address.model.person.patients;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Address;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Birthdate;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Service;
import seedu.address.model.tag.Tag;

/**
 * Represents a Patient in the address book. Guarantees: details are present and not null, field
 * values are validated, immutable.
 */

public class Patient extends Person {

    private final Gender gender;
    private final Birthdate birthdate;
    private final AppointmentDate appointmentdate;

    private final Service service;

    private long id;

    /**
     * A class which represents a patient
     *
     * @param name        name of patient
     * @param phone       phone number of patient
     * @param birthdate   patients birthday
     * @param gender      patients gender
     * @param appointment patients dental appointment date
     * @param service     dental service that the patients needs
     * @param address     address of patient
     * @param email       email of patient
     * @param tags        tags
     */
    public Patient(Name name, Phone phone, Birthdate birthdate, Gender gender,
        AppointmentDate appointment, Service service, Address address, Email email, Set<Tag> tags
    ) {
        super(name, phone, email, address, tags);
        requireAllNonNull(name, phone, birthdate, gender, appointment, service, address, email,
            tags);

        this.gender = gender;
        this.birthdate = birthdate;
        this.appointmentdate = appointment;
        this.service = service;
        this.id = -1;

    }

    /**
     * A class which represents a patient
     *
     * @param name        name of patient
     * @param phone       phone number of patient
     * @param birthdate   patients birthday
     * @param gender      patients gender
     * @param appointment patients dental appointment date
     * @param service     dental service that the patients needs
     * @param address     address of patient
     * @param email       email of patient
     * @param id          id of patient
     * @param tags        tags
     */
    public Patient(Name name, Phone phone, Birthdate birthdate, Gender gender,
        AppointmentDate appointment, Service service, Address address, Email email, long id,
        Set<Tag> tags
    ) {
        super(name, phone, email, address, tags);
        requireAllNonNull(name, phone, birthdate, gender, appointment, service, address, email,
            tags,id);

        this.gender = gender;
        this.birthdate = birthdate;
        this.appointmentdate = appointment;
        this.service = service;
        this.id = id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public Birthdate getBirthdate() {
        return birthdate;
    }

    public AppointmentDate getAppointmentdate() {
        return appointmentdate;
    }

    public Service getService() {
        return service;
    }


    /**
     * Returns true if both patients have the same name. This defines a weaker notion of equality
     * between two persons.
     */
    public boolean isSamePatient(Patient otherPatient) {
        if (otherPatient == this) {
            return true;
        }

        return otherPatient != null
            && otherPatient.getName().equals(getName());
    }

    /**
     * Returns true if both patients have the same identity and data fields. This defines a stronger
     * notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPerson = (Patient) other;
        return super.getName().equals(otherPerson.getName())
            && super.getPhone().equals(otherPerson.getPhone())
            && super.getEmail().equals(otherPerson.getEmail())
            && super.getAddress().equals(otherPerson.getAddress())
            && super.getTags().equals(otherPerson.getTags())
            && getGender().equals(otherPerson.getGender())
            && getBirthdate().equals(otherPerson.getBirthdate())
            && getAppointmentdate().equals(otherPerson.getAppointmentdate())
            && getService().equals(otherPerson.getService())
            && id == otherPerson.getId();
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(super.getName(), super.getPhone(), super.getEmail(), super.getAddress(),
            super.getTags(), getGender(), getBirthdate(), getAppointmentdate(), getService(), id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", super.getName())
            .add("phone", super.getPhone())
            .add("birthday", getBirthdate())
            .add("gender", getGender())
            .add("appointment", getAppointmentdate())
            .add("service", getService())
            .add("address", super.getAddress())
            .add("email", super.getEmail())
            .add("id", id)
            .add("tags", super.getTags())
            .toString();
    }


}

