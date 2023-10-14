package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Birthdate;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Service;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.dentist.Specialization;
import seedu.address.model.person.dentist.Yoe;
import seedu.address.model.person.patients.Patient;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(new Name("Alex Yeoh"), new Phone("87438807"),
                new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"))
        };
    }

    public static Patient[] getSamplePatients() {
        return new Patient[]{
            new Patient(new Name("Alex Yeohh"), new Phone("87438807"), new Birthdate("03-02-1999"),
                new Gender("F"), new AppointmentDate("yes"), new Service("Cleaning"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                new Email("alexyeoh@example.com"),
                getTagSet("friends"))
        };
    }

    public static Dentist[] getSampleDentist() {
        return new Dentist[]{
            new Dentist(new Name("Alex Yeoh"), new Phone("87438807"),
                new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Specialization("Orthodintics"),
                new Yoe("6"), getTagSet("friends")),
            new Dentist(new Name("Bernice Yu"), new Phone("99272758"),
                new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new Specialization("Whitening"),
                new Yoe("5"), getTagSet("colleagues", "friends"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        sampleAb.setPatientId(1);
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        for (Patient samplePatients : getSamplePatients()) {
            sampleAb.addPatient(samplePatients);
        }

        for (Dentist sampleDentist : getSampleDentist()) {
            sampleAb.addDentist(sampleDentist);
        }

        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
            .map(Tag::new)
            .collect(Collectors.toSet());
    }

}
