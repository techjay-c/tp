package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FilterPatientCommand;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FilterPatientCommand object
 */
public class FilterPatientCommandParser implements Parser<FilterPatientCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FilterPatientCommand
     * and returns a FilterPatientCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterPatientCommand parse(String args) throws ParseException {
        // Solution adapted and inspired from https://chat.openai.com/share/c95e431a-4406-4a1e-b88f-cbff729f1cca

        String trimmedArgs = args.trim();

        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterPatientCommand.MESSAGE_USAGE));
        }

        String[] parts = trimmedArgs.split("\\s+", 2);

        if (parts.length != 2) {
            throw new ParseException("Invalid filter format.");
        }

        String attribute = parts[0];
        String keywords = parts[1].trim();

        return new FilterPatientCommand(attribute, keywords);
    }
}
