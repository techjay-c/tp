package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Represents a command to search for patients whose names contain specified keywords.
 * The search is case-insensitive, and the matching patients are displayed as a list
 * with index numbers.
 */
public class SearchPatientCommand extends Command {

    public static final String COMMAND_WORD = "search-patient";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all dentists whose names contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
        + "Example: " + COMMAND_WORD + " John Tan";

    private final NameContainsKeywordsPredicate predicate;

    /**
     * Constructs a SearchPatientCommand with the specified predicate.
     *
     * @param predicate The predicate used for searching patients.
     */
    public SearchPatientCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the search operation on the provided model.
     *
     * @param model The model containing the patient data.
     * @return A CommandResult containing the search result message.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPatientList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_PATIENTS_LISTED_OVERVIEW, model.getFilteredPatientList().size()));
    }

    /**
     * Checks if this SearchPatientCommand is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SearchPatientCommand)) {
            return false;
        }

        SearchPatientCommand otherSearchPatientCommand = (SearchPatientCommand) other;
        return predicate.equals(otherSearchPatientCommand.predicate);
    }

    /**
     * Returns a string representation of this SearchPatientCommand.
     *
     * @return A string containing information about the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("predicate", predicate)
            .toString();
    }
}
