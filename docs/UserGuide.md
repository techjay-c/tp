---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (
CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact
management tasks done faster than traditional GUI apps.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar`
   command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all contacts.

    * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe`
      to the Address Book.

    * `delete 3` : Deletes the 3rd contact shown in the current list.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be
  ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

## Dentist Features (Freddy)

### Adding a dentist : `add-dentist`

Adds a dentist to ToothTracker list of dentists. This is helpful when:
* You are using ToothTracker for the first time and you have to add your dentists' particulars.
* A new dentist has joined your dental clinic.

**Format:** `add-dentist n/NAME p/PHONE e/EMAIL s/SPECIALIZATION y/YOE [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`  adds a dentist named 'Bob' with phone number '12345678' and email ‘bobjune@gmail.com’, who has 6 years of experience and specializing in 'braces' into ToothTracker dentist list.
* `add-dentist n/Emmanuel Chua p/99887766 y/8 s/surgery t/extraction` adds a dentist named 'Emmanuel Chua' with phone number '99887766' who has 8 years of experience specializing in 'surgery' with a tag of 'extraction' into ToothTracker dentist list.

### Editing a dentist: `edit-dentist`

Edits one or more details of the dentist at the specified Dentist ID. This is helpful when:
The particulars of a dentist need to be updated.
You accidentally entered incorrect information about a dentist into the ToothTrack database.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and you can edit more than one detail of the dentist.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the Dentist ID for a dentist, you can simply enter the command `list-dentist`.
</div>

<div markdown="block" class="alert alert-info">
When editing tags, you have to include any previous tags that was already included in the dentist, or else these tags will be removed. This also means that you can use `t/` to remove all tags from a dentist using the edit-dentist command.
</div>

**Format:** `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​`

Examples:
* `edit-dentist 1 p/98987676 e/bobjuly@gmail.com` edits the phone number and email of the dentist with Dentist ID of 1 into 98987676 and bobjuly@gmail.com respectively.
* `edit-dentist 2 n/Emmanuel Alexandra t/` edits the name of the dentist with Dentist ID of 2 into ‘Emmanual Alexandra’ and removes all tags of the dentist.

### Searching a dentist by Dentist ID: `search-dentist DENTIST_ID`

Searches for the  dentist at the specified Dentist ID in ToothTracker

<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `search-dentist DENTIST_ID`

### Searching a dentist by name: `search-dentist NAME`

Searches for the dentist whose name contains `NAME`  in ToothTracker

<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `search-dentist NAME`

### Deleting a dentist: `delete-dentist DENTIST_ID`

Deletes the specified dentist from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE! 
Dentists deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>


<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `delete-dentist DENTIST_ID`

Examples:
* `delete-dentist 2` deletes dentist with DENTIST_ID 2 from ToothTracker.

### Listing all dentists : `list-dentists`

Shows a list of all dentists in ToothTracker. This is useful when:
* You want to retrieve the information of all dentists.
* You want to verify a dentist is added successfully in ToothTracker.
* You want to verify a dentist is updated successfully in ToothTracker.

**Format:** `list-dentists` (No extra parameters required)


## Patient Features (Jaryl)

### Adding a patient: `add`

Adds a patient to ToothTracker.

Format: `add-patient n/NAME p/PHONE b/BIRTHDATE g/GENDER a/APPOINTMENT s/SERVICE h/ADDRESS e/EMAIL`

Examples:

* `add-patient n/John Tan p/90676622 e/johntan@gmail.com b/06-06-1998 g/M a/10-08-2023 s/Cleaning h/60 Jalan Kempinski Road`
* `add-patient n/Megan Chua p/88756298 e/megan@outlook.com b/10-09-1993 g/M a/02-11-2023 s/Cleaning h/34 Changi Rise`

### Listing all patients : `list`

Shows a list of all patients in ToothTracker.

Format: `list`

### Deleting a patient : `delete`

Deletes the specified patient from ToothTracker.

Format: `delete INDEX`

* Deletes the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​
* You may use `list-patients` to obtain the patient's ID first.

Format: `delete-patient [PATIENT_ID]`

Examples:
* `delete-patient 034` deletes patient with PATIENT_ID 34 from ToothTracker.

### Searching patients by ID or keyword: `search`

Search for patients with the specified ID or keyword.

Format: `search-patient [KEYWORD]`

* The search is case-insensitive. e.g., `Thomas` will match `thomas`
* The order of the keywords does not matter. e.g., `Thomas Tan` will match `Tan Thomas`
* Only the name is searched.
* Only full words will be matched, e.g., `Mel` will not match `Melissa`

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are
welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action    | Format, Examples |
|-----------|------------------ |
| **Add**   | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **Clear** | `clear` |
| **Delete** | `delete INDEX`<br> e.g., `delete 3` |
| **Edit**  | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com` |
| **Find**  | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake` |
| **List**  | `list` |
| **Help**  | `help` |

--------------------------------------------------------------------------------------------------------------------

