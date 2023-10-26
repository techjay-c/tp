package seedu.address.logic.parser;

import seedu.address.logic.commands.DeleteTreatmentCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteTreatmentCommand object
 */
public class DeleteTreatmentCommandParser implements Parser<DeleteTreatmentCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteTreatmentCommand and
     * returns a DeleteTreatmentCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public DeleteTreatmentCommand parse(String args) throws ParseException {
        return new DeleteTreatmentCommand(args);
    }
}
