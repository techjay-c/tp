package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalAppointments.APPOINTMENT_ONE;
import static seedu.address.testutil.TypicalAppointments.APPOINTMENT_TWO;
import static seedu.address.testutil.TypicalAppointments.getTypicalAddressBook;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;


import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterAppointmentCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.appointments.Appointment;

public class FilterAppointmentCommandParserTest {

    private FilterAppointmentCommandParser parser = new FilterAppointmentCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterAppointmentCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validDentist_returnsFilterAppointmentCommand() {
        FilterAppointmentCommand expectedCommand = new FilterAppointmentCommand("dentist", 1);

        assertParseSuccess(parser, "dentist 1", expectedCommand);
        assertParseSuccess(parser, " \n dentist \n \t 1  \t", expectedCommand);
    }

    @Test
    public void parse_validPatient_returnsFilterAppointmentCommand() {
        FilterAppointmentCommand expectedCommand = new FilterAppointmentCommand("patient", 1);

        assertParseSuccess(parser, "patient 1", expectedCommand);
        assertParseSuccess(parser, " \n patient \n \t 1  \t", expectedCommand);
    }

    @Test
    public void parse_invalidFormat() {
        String args = "";
        assertThrows(ParseException.class, () -> parser.parse(args));
    }

    @Test
    public void parse_invalidInputs() {
        String args = "dentist hello";
        assertThrows(ParseException.class, () -> parser.parse(args));
    }
}
