package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddAppointmentCommand;
import seedu.address.logic.commands.AddDentistCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointments.Appointment;
import seedu.address.model.appointments.AppointmentTime;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Service;

public class AddAppointmentCommandParser implements Parser<AddAppointmentCommand> {

    public AddAppointmentCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DENTIST, PREFIX_PATIENT, PREFIX_START,
                        PREFIX_DURATION, PREFIX_SERVICE);

        if (!arePrefixesPresent(argMultimap, PREFIX_DENTIST, PREFIX_PATIENT, PREFIX_START, PREFIX_DURATION, PREFIX_SERVICE) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddAppointmentCommand.MESSAGE_USAGE));
        }

        String dentist = argMultimap.getValue(PREFIX_DENTIST).get();
        String patient = argMultimap.getValue(PREFIX_PATIENT).get();
        String start = argMultimap.getValue(PREFIX_START).get();
        String[] parts = start.split("\\s+");
        String startParsed = null;
        if (parts.length == 2) {
            startParsed = parts[0] + "T" + parts[1];
        } else {
            throw new ParseException("Please enter start time in correct format: yyyy-MM-dd HH:mm");
        }
        String duration = argMultimap.getValue(PREFIX_DURATION).get();
        AppointmentTime appointmentTime = ParserUtil.parseAppointmentTime(startParsed, duration);
        String treatment = argMultimap.getValue(PREFIX_SERVICE).get();
        Appointment appointment = new Appointment(dentist, patient, appointmentTime, duration, treatment);
        return new AddAppointmentCommand(appointment);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap,
                                              Prefix... prefixes) {
        return Stream.of(prefixes)
                .allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
