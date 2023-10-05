package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */

    // Commands for both patients and dentists.
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    // Commands for dentists only
    public static final Prefix PREFIX_DENTIST = new Prefix("dentist/");
    public static final Prefix PREFIX_SPECIALIZATION = new Prefix("s/");
    public static final Prefix PREFIX_YOE = new Prefix("y/");

    // Commands for patients only


}
