package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TREATMENTS;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.treatment.Treatment;

/**
 * Lists all treatments in the address book to the user.
 */
public class ListTreatmentCommand extends Command {

    public static final String COMMAND_WORD = "list-treatment";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTreatmentList(PREDICATE_SHOW_ALL_TREATMENTS);
        ObservableList<Treatment> treatments = model.getFilteredTreatmentList();
        StringBuilder output = new StringBuilder();
        output.append("treatments: ");
        for (Treatment tr : treatments) {
            output.append(tr.getName() + ", ");
        }
        return new CommandResult(output.toString());
    }
}
