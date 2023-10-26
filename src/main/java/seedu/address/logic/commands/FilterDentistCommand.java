package seedu.address.logic.commands;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.DentistAttributeContainsKeywordsPredicate;
import seedu.address.model.Model;
import seedu.address.model.person.dentist.Dentist;

/**
 * Filters the list of dentists based on specific criteria and updates the filtered list.
 */
public class FilterDentistCommand extends Command {

    public static final String COMMAND_WORD = "filter-dentist";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters the list of dentists by a specific criteria.\n"
        + "Parameters: a/ (attribute) k/ (keyword)\n"
        + "Example: " + COMMAND_WORD + " a/ gender k/ Male";

    private final String attribute;
    private final String keywords;

    /**
     * Constructs a FilterPatientCommand to filter a patient based on the provided attribute and keywords.
     *
     * @param attribute The predicate by which the patient should be filtered.
     * @param keywords  A list of keywords to match against the specified attribute.
     */
    public FilterDentistCommand(String attribute, String keywords) {
        this.attribute = attribute;
        this.keywords = keywords;
    }

    @Override
    public CommandResult execute(Model model) {
        Predicate<Dentist> predicate = new DentistAttributeContainsKeywordsPredicate(attribute, keywords);
        model.updateFilteredDentistList(predicate);

        if (model.getFilteredDentistList().isEmpty()) {
            String errorMessage = String.format("No dentists found with the %s: %s!", attribute, keywords);
            return new CommandResult(String.format(errorMessage, keywords));
        }

        return new CommandResult("Filtered dentists by " + attribute + " with: "
            + keywords);
    }

    /**
     * Checks if this FilterDentistCommand is equal to another object.
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
        if (!(other instanceof FilterDentistCommand)) {
            return false;
        }

        FilterDentistCommand otherFilterDentistCommand = (FilterDentistCommand) other;
        return attribute.equals(otherFilterDentistCommand.attribute)
            && keywords.equals(otherFilterDentistCommand.keywords);
    }

    /**
     * Returns a string representation of this FilterDentistCommand.
     *
     * @return A string containing information about the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("attribute", attribute)
            .add("keywords", keywords)
            .toString();
    }
}
