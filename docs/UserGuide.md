---
layout: page
title: User Guide
---

ToothTracker is an **All-in-One solution for Effortless Dental Clinic Record Management**.
From adding new patient and dentist profiles to seamlessly deleting records,
ToothTracker is engineered to simplify every aspect of your administrative responsibilities.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ToothTracker.jar` from [here]().

1. Copy the file to the folder you want to use as the _home folder_ for your ToothTracker.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar ToothTracker.jar`
   command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `list-dentists` : Lists all dentists.

    * `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces` : Adds a dentist named `Bob`
      to the ToothTracker.

    * `delete-dentist 3` : Deletes the dentist with id 2.

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

## Dentist Features

### Adding a dentist : `add-dentist`

Adds a dentist to ToothTracker list of dentists. This is helpful when:

* You are using ToothTracker for the first time and you have to add your dentists' particulars.
* A new dentist has joined your dental clinic.

**Format:** `add-dentist n/NAME p/PHONE e/EMAIL s/SPECIALIZATION y/YOE [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:

* `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces` adds a dentist named 'Bob' with phone number 
'12345678' and email ‘bobjune@gmail.com’, who has 6 years of experience and specializing in 'braces' into ToothTracker
dentist list.
* `add-dentist n/Emmanuel Chua p/99887766 y/8 s/surgery t/extraction` adds a dentist named 'Emmanuel Chua' with phone
number '99887766' who has 8 years of experience specializing in 'surgery' with a tag of 'extraction' into ToothTracker
dentist list.

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

* `edit-dentist 1 p/98987676 e/bobjuly@gmail.com` edits the phone number and email of the dentist with Dentist ID of 1
  into 98987676 and bobjuly@gmail.com respectively.
* `edit-dentist 2 n/Emmanuel Alexandra t/` edits the name of the dentist with Dentist ID of 2 into ‘Emmanual Alexandra’
  and removes all tags of the dentist.

### Searching a dentist by Dentist ID: `search-dentist DENTIST_ID`

Searches for the dentist at the specified Dentist ID in ToothTracker

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


## Patient Features

### Adding a patient: `add-patient`

Adds a patient to ToothTracker list of patients. This is helpful when:
- You are using ToothTracker for the first time and you have to add your patients' particulars.
- A new patient has joined your clinic.

Format: `add-patient n/NAME p/PHONE e/EMAIL b/BIRTHDATE g/GENDER a/APPOINTMENT s/SERVICE h/ADDRESS `

Examples:

* `Add-patient n/John Tan p/90676622 e/johntan@gmail.com b/06-06-1998 g/M a/10-08-2023 s/Cleaning h/60 Jalan Kempinski Road` <br>
Adds a new patient named ‘John Tan’, with phone number ‘90676622’ and email of ‘johntan@gmail.com’,
birthdate of 06 June 1998, Gender Male, appointment date of 10 August 2023, requesting for cleaning treatment
and with an address at 60 Jalan Kempinski Road.
* `Add-patient n/Megan Chua p/88756298 e/megan@outlook.com b/10-09-1993 g/F a/02-11-2023 s/Cleaning h/34 Changi Rise` <br>
Adds a new patient named ‘Megan Chua’, with phone number ‘88756298’ and email of ‘megan@outlook.com’,
birthdate of 10 Sep 1993, Gender Female, appointment date of 02 Nov 2023, requesting for cleaning treatment and with
an address at 34 Changi Rise.


### Listing all patients : `list-patient`

Shows a list of all patients in ToothTracker.

Format: `list-patient`

Examples:

* `list-patient 296` shows the details of the patient with PATIENT_ID 296 from ToothTracker.


### Deleting a patient : `delete-patient`

Deletes the specified patient from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE! Dentists deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

* Deletes the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​
* You may use `list-patient` to obtain the patient's ID first.

Format: `delete-patient PATIENT_ID`

Examples:

* `delete-patient 034` deletes patient with PATIENT_ID 34 from ToothTracker.


### Searching patients by ID or keyword: `search-patient`

Searches for the patient with the specified ID or patients that matches the keyword. This command allows you to find patient records that match your
search criteria.

Format: `search-patient [KEYWORD]`, `search-patient [PATIENT_ID]`

<div markdown="block" class="alert alert-info">
The `PATIENT_ID` refers to the index number shown in the displayed list of patients. <br>
You may use `list-patients` to check out the patient' ID first.
</div>

**Important Notes:**

* The search is case-insensitive, meaning that the search will match both uppercase and lowercase characters. For
  example, searching for `Thomas` will match both `Thomas` and `thomas`.
* The order of the keywords in the name does not matter. For instance, searching for `Thomas Tan` will
  match `Tan Thomas` as well.
* The search is performed only on the patient's name.
* Only full words will be matched. For example, if you search for `Mel`, it will not match `Melissa`.


Examples:

* `search-patient Thomas` will search for patients with the name containing the keyword `Thomas`.
* `search-patient 088` will search for a patient with the ID `088`. If one or more matching patients are found based on
  your search criteria, the system will list the matching patients along with their details.

## General Features

### Adding a treatment: `add-treatment`

You can add a new dental treatment to the ToothTracker system using the `add-treatment` command. This command allows you
to specify the name of the treatment and its associated price.

Format: `add-treatment [name] [price]`

Examples:

* `add-treatment "Tooth Extraction" 150` adds a Tooth Extraction Treatment to ToothTracker with a cost of $150.

**Important Notes:**

- Ensure that you provide both the treatment name and its cost when using the `add-treatment` command.
- The system will not allow duplicate treatment names. If a treatment with the same name already exists, you will be
  prompted to provide a unique name.

### Filter Appointments by service type, date or dentist: `filter KEYWORD`

You can filter appointments by their service type, date or dentists in the ToothTracker system
using the `filter` command.

Format: `filter s/SERVICE_TYPE`, `filter t/DATE`, `filter d/DENTIST`

Examples:

* `filter s/Tooth Extraction` return all Tooth Extraction appointments.
* `filter t/20-11-2023` return all appointments happening on 20 November 2023.
* `filter d/Tom` return all appointments with Tom as the dentist.


### Clearing all entries : `clear`

Clears all entries from ToothTracker.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

ToothTracker data is saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file

ToothTracker data is saved automatically as a JSON file `[JAR file location]/data/toothtracker.json`. Advanced users are
welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ToothTracker will discard all data and start with an empty
data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous ToothTracker home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                                  | Format, Examples                                                                                                                                                                                                                  |
|-----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Dentist**                         | `add-dentist n/NAME p/PHONE e/EMAIL s/SPECIALIZATION y/YOE [t/TAG]…​` <br> e.g., `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`                                                                                  |
| **Edit Dentist**                        | `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​` <br> e.g., `edit-dentist 1 p/98987676 e/bobjuly@gmail.com`                                                                |
| **Delete Dentist**                      | `delete-dentist DENTIST_ID`<br> e.g., `delete-dentist 3`                                                                                                                                                                          |
| **List Dentists**                       | `list-dentists`                                                                                                                                                                                                                   |
| **Search Dentist by Dentist ID**        | `search-dentist DENTIST_ID` <br> e.g., `search-dentist 2`                                                                                                                                                                         |
| **Search Dentist by Name**              | `search-dentist NAME` <br> e.g., `search-dentist Tom`                                                                                                                                                                             |
| **Add Patient**                         | `add-patient n/NAME p/PHONE e/EMAIL b/BIRTHDATE g/GENDER a/APPOINTMENT s/SERVICE h/ADDRESS` <br> e.g., `add-patient n/John Tan p/90676622 e/johntan@gmail.com b/06-06-1998 g/M a/10-08-2023 s/Cleaning h/60 Jalan Kempinski Road` |
| **Delete Patient**                      | `delete-patient PATIENT_ID`<br> e.g., `delete-patient 3`                                                                                                                                                                          |
| **List Patients**                       | `list-patients`                                                                                                                                                                                                                   |
| **Search Patient by Patient ID**        | `search-patient PATIENT_ID`  <br> e.g., `search-patient 3`                                                                                                                                                                        |
| **Search Patient by Name**              | `search-patient NAME` <br> e.g., `search-patient John`                                                                                                                                                                            |
| **Add a Treatment**                     | `add-treatment [NAME] [PRICE]` <br> e.g., `add-treatment "Tooth Extraction" 150`                                                                                                                                                  |
| **Filter Appointments by Service Type** | `filter s/SERVICE_TYPE` <br> e.g., `filter s/Tooth Extraction`                                                                                                                                                                    |
| **Filter Appointments by Date**         | `filter t/DATE` <br> e.g., `filter t/20-11-2023`                                                                                                                                                                                  |
| **Filter Appointments by Dentist**      | `filter d/DENTIST_ID` <br> e.g., `filter d/Tom`                                                                                                                                                                                   |
| **Clear all Profiles**                  | `clear`                                                                                                                                                                                                                           |
| **Exit Programme**                      | `exit`                                                                                                                                                                                                                            |
| **Help**                                | `help`                                                                                                                                                                                                                            |

--------------------------------------------------------------------------------------------------------------------

