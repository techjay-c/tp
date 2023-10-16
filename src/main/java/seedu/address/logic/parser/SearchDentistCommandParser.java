package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.SearchDentistCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new SearchDentistCommand object
 */
public class SearchDentistCommandParser implements Parser<SearchDentistCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SearchDentistCommand
     * and returns a SearchDentistCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SearchDentistCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SearchDentistCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new SearchDentistCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }
}
