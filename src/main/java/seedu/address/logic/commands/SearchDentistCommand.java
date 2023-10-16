package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Represents a command to search for dentists whose names contain specified keywords.
 * The search is case-insensitive, and the matching dentists are displayed as a list
 * with index numbers.
 */
public class SearchDentistCommand extends Command {

    public static final String COMMAND_WORD = "search-dentist";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all dentists whose names contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
        + "Example: " + COMMAND_WORD + " John Tan";

    private final NameContainsKeywordsPredicate predicate;

    /**
     * Constructs a SearchDentistCommand with the specified predicate.
     *
     * @param predicate The predicate used for searching dentists.
     */
    public SearchDentistCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the search operation on the provided model.
     *
     * @param model The model containing the dentist data.
     * @return A CommandResult containing the search result message.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredDentistList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredDentistList().size()));
    }

    /**
     * Checks if this SearchDentistCommand is equal to another object.
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
        if (!(other instanceof SearchDentistCommand)) {
            return false;
        }

        SearchDentistCommand otherSearchDentistCommand = (SearchDentistCommand) other;
        return predicate.equals(otherSearchDentistCommand.predicate);
    }

    /**
     * Returns a string representation of this SearchDentistCommand.
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
