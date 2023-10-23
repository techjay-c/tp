package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Birthdate;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Service;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Patient objects.
 */
public class PatientBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_GENDER = "F";
    public static final String DEFAULT_BIRTHDATE = "03-02-1999";
    public static final String DEFAULT_APPOINTMENTDATE = "03-11-2023";
    public static final String DEFAULT_SERVICE = "Cleaning";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Gender gender;
    private Birthdate birthdate;
    private AppointmentDate appointmentdate;
    private Service service;
    private Set<Tag> tags;

    /**
     * Creates a {@code PatientBuilder} with the default details.
     */
    public PatientBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        gender = new Gender(DEFAULT_GENDER);
        birthdate = new Birthdate(DEFAULT_BIRTHDATE);
        appointmentdate = new AppointmentDate(DEFAULT_APPOINTMENTDATE);
        service = new Service(DEFAULT_SERVICE);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PatientBuilder with the data of {@code patientToCopy}.
     */
    public PatientBuilder(Patient patientToCopy) {
        name = patientToCopy.getName();
        phone = patientToCopy.getPhone();
        email = patientToCopy.getEmail();
        address = patientToCopy.getAddress();
        gender = patientToCopy.getGender();
        birthdate = patientToCopy.getBirthdate();
        appointmentdate = patientToCopy.getAppointmentdate();
        service = patientToCopy.getService();
        tags = new HashSet<>(patientToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Patient} that we are building.
     */
    public PatientBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Patient} that we are building.
     */
    public PatientBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Patient} that we are building.
     */
    public PatientBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Patient} that we are building.
     */
    public PatientBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Patient} that we are building.
     */
    public PatientBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Gender} of the {@code Patient} that we are building.
     */
    public PatientBuilder withGender(String gender) {
        this.gender = new Gender(gender);
        return this;
    }

    /**
     * Sets the {@code Birthdate} of the {@code Patient} that we are building.
     */
    public PatientBuilder withBirthdate(String birthdate) {
        this.birthdate = new Birthdate(birthdate);
        return this;
    }

    /**
     * Sets the {@code Appointmentdate} of the {@code Patient} that we are building.
     */
    public PatientBuilder withAppointmentdate(String appointmentdate) {
        this.appointmentdate = new AppointmentDate(appointmentdate);
        return this;
    }

    /**
     * Sets the {@code Service} of the {@code Patient} that we are building.
     */
    public PatientBuilder withService(String service) {
        this.service = new Service(service);
        return this;
    }

    public Patient build() {
        return new Patient(name, phone, birthdate, gender, appointmentdate, service, address, email, tags);
    }

}
