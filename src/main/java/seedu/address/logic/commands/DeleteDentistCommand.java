package seedu.address.logic.commands;

import static java.util.Objects.*;

import java.util.*;

import seedu.address.commons.util.*;
import seedu.address.logic.*;
import seedu.address.logic.commands.exceptions.*;
import seedu.address.model.*;
import seedu.address.model.person.dentist.*;

/**
 * Deletes a dentist identified using it's displayed index from the address book.
 */
public class DeleteDentistCommand extends Command {

    public static final String COMMAND_WORD = "delete-dentist";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Deletes the dentist identified by the index number used in the displayed dentist list.\n"
        + "Parameters: ID (must be a positive integer)\n"
        + "Example: " + COMMAND_WORD + " 1";

    private final long targetId;

    public DeleteDentistCommand(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        try {
            Dentist dentistToDelete = model.getDentistById(targetId);

            if (dentistToDelete == null) {
                throw new CommandException(String.format(Messages.MESSAGE_NO_SUCH_DENTIST, targetId));
            }

            model.deleteDentist(dentistToDelete);
            return new CommandResult(
                    String.format(Messages.MESSAGE_DELETE_DENTIST_SUCCESS, Messages.format(dentistToDelete)));

        } catch (Exception e) {
            throw new CommandException("An error occurred while deleting the dentist: " + e.getMessage());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteDentistCommand)) {
            return false;
        }

        DeleteDentistCommand otherDeleteDentistCommand = (DeleteDentistCommand) other;
        return Objects.equals(targetId, otherDeleteDentistCommand.targetId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("targetIndex", targetId)
            .toString();
    }
}
