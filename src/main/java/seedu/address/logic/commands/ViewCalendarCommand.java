package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Displays a calendar view window.
 */
public class ViewCalendarCommand extends Command {

    public static final String COMMAND_WORD = "view-calendar";

    public static final String SHOWING_CALENDAR_MESSAGE = "Calendar displayed.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(SHOWING_CALENDAR_MESSAGE, false, false, true);
    }
}

