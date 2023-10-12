package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddAppointmentCommand;
import seedu.address.logic.commands.AddDentistCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.person.AppointmentDate;

public class AddAppointmentCommandParser implements Parser<AddAppointmentCommand> {

    public AddAppointmentCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DENTIST, PREFIX_PATIENT, PREFIX_APPOINTMENT,
                        PREFIX_DURATION);

        if (!arePrefixesPresent(argMultimap, PREFIX_DENTIST, PREFIX_PATIENT, PREFIX_APPOINTMENT, PREFIX_DURATION) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddAppointmentCommand.MESSAGE_USAGE));
        }

        String dentist = argMultimap.getValue(PREFIX_DENTIST).get();
        String patient = argMultimap.getValue(PREFIX_PATIENT).get();
        AppointmentDate appointmentdate = ParserUtil.parseAppointment(
                argMultimap.getValue(PREFIX_APPOINTMENT).get());
        String duration = argMultimap.getValue(PREFIX_DURATION).get();
        Appointment appointment = new Appointment(dentist, patient, appointmentdate, duration);
        return new AddAppointmentCommand(appointment);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap,
                                              Prefix... prefixes) {
        return Stream.of(prefixes)
                .allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
