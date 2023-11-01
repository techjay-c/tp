package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteAppointmentCommand;

public class DeleteAppointmentCommandParserTest {

    private final DeleteAppointmentCommandParser parser = new DeleteAppointmentCommandParser();

    /*@Test
    public void parse_validAppointmentId_returnsDeleteAppointmentCommand() throws ParseException {
        long appointmentId = 1;
        String args = "1";
        DeleteAppointmentCommand expectedCommand = new DeleteAppointmentCommand(appointmentId);

        assertParseSuccess(parser, args, expectedCommand);
    }*/

    @Test
    public void parse_emptyArgs_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteAppointmentCommand.MESSAGE_USAGE));
    }
}
