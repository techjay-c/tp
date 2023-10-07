package seedu.address.logic.commands;

    import static java.util.Objects.requireNonNull;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_BIRTHDATE;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE;
    import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

    import seedu.address.commons.util.ToStringBuilder;
    import seedu.address.logic.Messages;
    import seedu.address.logic.commands.exceptions.CommandException;
    import seedu.address.model.Model;
    import seedu.address.model.person.Person;
    import seedu.address.model.person.patients.Patient;

/**
 * Adds a person to the address book.
 */
public class AddPatientCommand extends Command {

    public static final String COMMAND_WORD = "add-patient";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
        + "Parameters: "
        + PREFIX_NAME + "NAME "
        + PREFIX_PHONE + "PHONE "
        + PREFIX_BIRTHDATE + "BIRTHDATE "
        + PREFIX_GENDER + "GENDER "
        + PREFIX_APPOINTMENT + "APPOINTMENT "
        + PREFIX_SERVICE + "SERVICE "
        + PREFIX_EMAIL + "EMAIL "
        + PREFIX_ADDRESS + "ADDRESS "
        + "[" + PREFIX_TAG + "TAG]...\n"
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_NAME + "John Tan "
        + PREFIX_PHONE + "90676622 "
        + PREFIX_BIRTHDATE + "06-06-1998 "
        + PREFIX_GENDER + "M "
        + PREFIX_APPOINTMENT + "10-08-2023 "
        + PREFIX_SERVICE + "Cleaning "
        + PREFIX_EMAIL + "johntan@gmail.com "
        + PREFIX_ADDRESS + "60 Jalan Road "
        + PREFIX_TAG + "hello ";

    public static final String MESSAGE_SUCCESS = "New Patient added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This Patient already exists in ToothTracker";

    private final Patient toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddPatientCommand(Patient patient) {
        requireNonNull(patient);
        toAdd = patient;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

//        TODO: Add checks to see if a patient exists or not
//        if (model.hasPerson(toAdd)) {
//            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
//        }


        model.addPatient(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddPatientCommand)) {
            return false;
        }

        AddPatientCommand otherAddCommand = (AddPatientCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("toAdd", toAdd)
            .toString();
    }
}
