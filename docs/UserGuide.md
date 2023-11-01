---
layout: page
title: User Guide
---


ToothTracker is an All-in-One solution for effortless Dental Clinic Record Management. From adding new patient and dentist profiles to seamlessly creating appointment schedules, 
ToothTracker is engineered to simplify every aspect of your dental clinic administrative responsibilities.


Here is an overview of how ToothTracker can help you manage your dental clinic administration better:
- You can add tags to every patient and dentist to highlight additional information about them.
- You need not worry about storing physical copies of patient and dentist profiles and appointment schedules.
- You can access and retrieve patient and dentist records easily using the `search` and `filter` commands.
- You can avoid creating clashing appointments to reduce operational delays.
- You can have the flexibility to add custom treatments that your clinic provides.
- You can view your clinic's appointment schedule in ToothTracker's calendar.

We believe that time is the rarest commodity in a dental office. This means dental clinic administrative management must be efficient.  
Therefore, ToothTracker is optimized for use via a Command Line Interface (CLI) while also having the advantages of a Graphical User Interface (GUI), particularly our calendar feature. 
If you type fast, ToothTracker offers your dental clinic a significantly more efficient workflow to get your job done.

If you are new here, visit our quick start guide to start tracking your dental clinic records with ToothTracker!


### About ToothTracker's User Guide
This user guide provides a comprehensive documentation on the various commands supported by ToothTracker.

If you are familiar with ToothTracker already, this user guide serves to give you an overview on how to use specific commands in ToothTracker.

If you are a new user, you may proceed to our quick start guide to assist you in installing ToothTracker and launching it for the first time.

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

    * `list-dentist` : Lists all dentists.

    * `add-dentist n/Bob p/12345678 e/bobjune@gmail.com s/Orthodontics y/6 s/braces` : Adds a dentist named `Bob`
      to the ToothTracker. See [add-dentist](#adding-a-dentist--add-dentist) for more details.

    * `delete-dentist 3` : Deletes the dentist with `Dentist_ID` 3.
   
    * `search-patient 6` : Search for the patient with `Patient_ID` 6.

    * `clear` : Deletes all records from ToothTracker.

    * `exit` : Exits ToothTracker.

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

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list-patient`,
  `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

## Part 1 - Dentist Features

### Adding a dentist : `add-dentist`
Adds a dentist to the list of dentists in ToothTracker. This is helpful when:

* You are using ToothTracker for the first time, and you have to add your dentists' particulars.
* You are adding a new dentist who has joined your dental clinic.

**Format:** `add-dentist n/NAME p/PHONE s/SPECIALIZATION y/YOE [e/EMAIL] [h/ADDRESS] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A dentist can have any number of <code>TAG</code>s (including zero tags).

<code>EMAIL</code> and <code>ADDRESS</code> are optional to be put.
You may use the `edit-dentist` command to update them in the future.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a dentist without email and address:**<br>
ToothTracker will put the <code>EMAIL</code> as "NoEmailProvided@ToBeAdded.com"
and put the <code>ADDRESS</code> as "No Address Provided." by default.

If you wish to update them at a later time, you can use <code>edit-dentist</code> to edit them.
</div>

**Examples:**
* `add-dentist n/Xavier Roald p/99773311 s/Whitening y/1 e/roaldxavier@hotmail.com
h/Yishun Street 72, Blk 742, #03-354, Singapore 512742 t/Undergraduate Trainee`
This adds a dentist named 'Xavier Roald' with phone number '99773311', email 'roaldxavier@hotmail.com',
address 'Yishun Street 72, Blk 742, #03-354, Singapore 512742',
specialising in 'Whitening' with 1 year of experience, who is undergoing University Training program under Dentistry.


* `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`
This adds a dentist named 'Bob' with phone number '12345678' and email ‘bobjune@gmail.com’,
who has 6 years of experience and specializing in 'braces' into the list of dentists in ToothTracker.


* `add-dentist n/Emmanuel Chua p/99887766 y/8 s/surgery t/extraction`
This adds a dentist named 'Emmanuel Chua' with phone number '99887766' who has 8 years of experience
specializing in 'surgery' with a tag of 'extraction' into the list of dentists in ToothTracker.

### Listing all dentists : `list-dentist`

Shows a list of all dentists in ToothTracker. This is useful when:

* You want to retrieve the information of all dentists.
* You want to verify a dentist is added successfully in ToothTracker.
* You want to verify a dentist is updated successfully in ToothTracker.

**Format:** `list-dentist` (No extra parameters required)

### Deleting a dentist : `delete-dentist`

Deletes the dentist with the specified `DENTIST_ID` from ToothTracker.

Format: `delete-dentist DENTIST_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE! Dentists deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

<div markdown="span" class="alert alert-primary">:bulb: Tip:
To check the Dentist ID of a dentist, you can simply enter the command `list-dentist`.
</div>

**Examples:**
* `delete-dentist 6` deletes the dentist with the `DENTIST_ID` 6.
* `delete-dentist 20` deletes the dentist with the `DENTIST_ID` 20.

### Searching for dentists by `DENTIST_ID`: `search-dentist`

Search for a dentist by their `DENTIST_ID` in ToothTracker. This search returns a unique dentist based on the provided `DENTIST_ID`.
This is useful when:

* You want to confirm the identity of a specific dentist before using further commands.
* You need quick access to one specific dentist's particulars.

**Format:** `search-dentist DENTIST_ID`

<div markdown="block" class="alert alert-info">
:bulb: **Tip:**
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists. <br>
To check the `DENTIST_ID` of a dentist, you can simply enter the command `list-dentist`.
</div>

**Examples:**
* `search-dentist 5` searches for the dentist with `DENTIST_ID` 5.
* `search-dentist 10` searches for the dentist with `DENTIST_ID` 10.


### Searching for dentists by keywords: `search-dentist`

Search for dentists by matching names with a keyword. This command helps you find dentist records that match your search criteria.
This is useful when:

* You need to find dentists whose names match your search criteria.

**Format:** `search-dentist KEYWORD`

**Important Notes for searching dentists by keyword:**

* The search is performed only on the dentist's name.
* The search is case-insensitive, meaning that it will match both uppercase and lowercase characters. For example, searching for `James` will match both `James` and `james`.
* The order of the keywords in the name does not matter. For instance, searching for `Mike Lim` will match `Lim Mike` as well.
* Sub-strings will be matched. For example, if you search for `Fred`, it will match `Frederick`.
* More than one dentist result might be returned when searching by keywords, especially if multiple dentists match your search criteria.

**Examples:**
* `search-dentist John` searches for dentists with names containing the keyword `John`.
* `search-dentist Ronald Lim` searches for dentists with names containing the keyword `Ronald Lim`.

### Filtering dentists: `filter-dentist`

Narrows down your search for dentists based on a specified attribute. When this command is used, there might be more than
one result that matches your search criteria. This is helpful when:

* You want to find dentists with specific attributes.
* You want to confirm the identity of a dentist before using further commands.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the attributes that you can filter by, you can simply enter the command `list-dentist`.
Alternatively, a message will be shown in the text box regarding the attributes that you can filter by if you entered an invalid attribute.
We have set the attributes that can be filtered to be: 
`name`, `email`, `specialization`, `address`, `phone`, `experience`, `tags`
</div>

**Format:** `filter-dentist a/ATTRIBUTE k/KEYWORDS`

**Examples:**
* `filter-dentist a/phone k/98225677` searches for dentists with the phone number 98225677.
* `filter-dentist a/specialization k/Orthodontics` searches for dentists with the specialization Orthodontics.

### Editing a dentist: `edit-dentist`

Edits one or more details of the dentist at the specified Dentist ID. This is helpful when:

* The particulars of a dentist need to be updated.
* Optional dentist details were not provided previously.
* You accidentally entered incorrect information about a dentist into the ToothTrack database.

**Format:** `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​`

**Examples:**

* `edit-dentist 1 p/98987676 e/bobjuly@gmail.com` edits the phone number and email of the dentist with `DENTIST_ID 1`
  into 98987676 and bobjuly@gmail.com respectively.


* `edit-dentist 2 n/Emmanuel Alexandra t/` edits the name of the dentist with `DENTIST_ID 2` into ‘Emmanual Alexandra’
  and removes all tags of the dentist.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and edit more than one detail of the dentist with a single `edit-dentist` command.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `Dentist_ID` of a dentist, you can simply enter the command `list-dentist`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing tags:**<br>
When editing tags, you have to include any previous tags that was already included in the dentist, or else these tags will be removed.
This also means that you can use `t/` to remove all tags from a dentist using the <code>edit-dentist</code> command.
</div>

## Part 2 - Patient Features

### Adding a patient : `add-patient`
Adds a patient to the list of patients in ToothTracker. This is helpful when:

* You are using ToothTracker for the first time, and you have to add your patients' particulars.
* A new patient has joined your clinic.

**Format:** `add-patient n/NAME p/PHONE b/BIRTHDATE g/GENDER [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A patient can have any number of <code>TAG</code>s (including zero tags).

<code>EMAIL</code>, <code>ADDRESS</code>, <code>REMARK</code> and <code>TREATMENT</code> are optional to be put.
You may use the `edit-patient` command to update them in the future.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a patient without remark and treatment:**<br>
ToothTracker will put the <code>REMARK</code> and <code>TREATMENT</code> as `NIL` by default.

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a patient without email and address:**<br>
ToothTracker will put the <code>EMAIL</code> as "NoEmailProvided@ToBeAdded.com"
and put the <code>ADDRESS</code> as "No Address Provided." by default.

If you wish to update them at a later time, you can use <code>edit-patient</code> to edit them.
</div>

**Examples:**

* `add-patient n/John p/90676622 b/06-06-1998 g/M r/Allergic to Peanuts tr/Braces e/johntan@gmail.com h/60 Harvey Avenue t/Urgent` <br>
Adds a new patient named ‘John’, with phone number ‘90676622’ and email of ‘johntan@gmail.com’,
birthdate of 06 June 1998, Gender Male, remark that he is allergic to Peanuts, requesting for cleaning treatment
and with an address at 60 Harvey Avenue.

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding Treatments:**<br>
The new treatment must be a valid treatment in ToothTracker. For a list of valid treatments, you can use the command `list-treatment`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding patients with the same name:**<br>
Each patient must have a unique name and ToothTracker does not allow multiple patients with identical names. 
</div>

### Listing all patients : `list-patient`

Shows a list of all patients in ToothTracker. This is useful when:

* You want to retrieve the information of all patients.
* You want to verify a patient is added successfully in ToothTracker.
* You want to verify a patient is updated successfully in ToothTracker.

Format: `list-patient` (No extra parameters required)

### Deleting a patient : `delete-patient`

Deletes the patient with the specified `PATIENT_ID` from ToothTracker.

Format: `delete-patient PATIENT_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE! Patients deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

Examples:
* `delete-patient 34` deletes the patient with the `PATIENT_ID` 34.

### Searching for patients by `PATIENT_ID`: `search-patient`

Search for a patient by their `PATIENT_ID` in ToothTracker. This search returns a unique patient based on the provided `PATIENT_ID`.
This is useful when:

* You want to confirm the identity of a specific patient before using further commands.
* You need quick access to one specific patient's particulars.

**Format:** `search-patient PATIENT_ID`

<div markdown="block" class="alert alert-info">
:bulb: **Tip:**
The `PATIENT_ID` refers to the index number shown in the displayed list of patients. <br>
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

**Examples:**
* `search-patient 2` searches for the patient with `PATIENT_ID` 2.
* `search-patient 8` searches for the patient with `PATIENT_ID` 8.


### Searching for patients by keywords: `search-patient`

Search for patients by matching names with a keyword. This command helps you find patient records that match your search criteria.
This is useful when:

* You need to find patients whose names match your search criteria.

**Format:** `search-patient KEYWORD`

**Important Notes for searching dentists by keyword:**

* The search is performed only on the patient's name.
* The search is case-insensitive, meaning that it will match both uppercase and lowercase characters. For example, searching for `James` will match both `James` and `james`.
* The order of the keywords in the name does not matter. For instance, searching for `Mike Lim` will match `Lim Mike` as well.
* Sub-strings will be matched. For example, if you search for `Fred`, it will match `Frederick`.
* More than one patient result might be returned when searching by keywords, especially if multiple patients match your search criteria.

**Examples:**
* `search-dentist John` searches for dentists with names containing the keyword `John`.
* `search-dentist Ronald Lim` searches for dentists with names containing the keyword `Ronald Lim`.

### Filtering patients: `filter-patient`

Narrows down your search for patients based on a specified attribute. When this command is used, there might be more than
one result that matches your search criteria. This is helpful when:

* You want to find patients with specific attributes.
* You want to confirm the identity of a patient before using further commands.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the attributes that you can filter by, you can simply enter the command `list-patient`.
Alternatively, a message will be shown in the text box regarding the attributes that you can filter by if you entered an invalid attribute.
We have set the attributes that can be filtered to be: 
`birthday`, `email`, `name`, `remark`, `gender`, `tags`, `address`, `phone`, `treatment`
</div>

**Format:** `filter-patient a/ATTRIBUTE k/KEYWORDS`

**Examples:**
* `filter-patient a/phone k/81076655` searches for patients with the phone number 81076655.
* `filter-patient a/treatment k/Cleaning` searches for patients with the treatment Cleaning.

### Editing a patient: `edit-patient`

Edits one or more details of the patient at the specified patient ID. This is helpful when:
* The particulars of a patient need to be updated.
* Optional patient details were not provided previously.
* You accidentally entered incorrect information about a patient into the ToothTrack database.

**Format:** `PATIENT_ID [n/NAME] [p/PHONE] [b/BIRTHDATE] [g/GENDER] [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]`

**Examples:**
* `edit-patient 1 p/91234567 e/johndoe@example.com r/Allergic to Peanuts` updates the 
phone number, email address and remarks of the patient with `PATIENT_ID 1`

* `edit-patient 2  n/Alex` updates the name of the patient with `PATIENT_ID 2` to Alex

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and edit more than one detail of the patient with a single `edit-patient` command.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing tags:**<br>
When editing tags, you have to include any previous tags that was already included in the patient, or else these tags will be removed.
This also means that you can use `t/` to remove all tags from a patient using the <code>edit-patient</code> command.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding Treatments:**<br>
The edited treatment must be a valid treatment in ToothTracker. For a list of valid treatments, you can use the command `list-treatment`.
</div>

## Part 3 - Appointment Features

### Adding an appointment: `add-appointment`

Adds a new dental appointment to ToothTracker.

This is helpful when:
- you want to schedule future dental appointments for patients with specific dentists at designated times.
- you want to check for clashes with existing appointments.

Format: `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_DATE_TIME s/TREATMENT`

**Example:**

* `add-appointment dentist/0 patient/0 start/2023-10-12 16:00 s/Braces`

This command adds an appointment with the patient whose ID is 0 and, the dentist whose ID is 0.
The appointment starts on 12 October 2023, 4pm. Treatment provided during the appointment is braces. 
The duration of the appointment is determined by the treatment.

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding Appointments:**<br>
The system will not allow the addition of appointments that clashes with existing appointments with the same dentist or patient.
</div>


### Deleting an appointment: `delete-appointment`

Deletes the specified appointment from ToothTracker.

**Format:** `delete-appointment APPOINTMENT_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE!
Appointments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>

<div markdown="block" class="alert alert-info">
The `APPOINTMENT_ID` refers to the index number shown in the displayed list of appointments.
You may use `list-appointment` to check out the `APPOINTMENT_ID` first.
</div>

**Example:**

* `delete-appointment 2` deletes the appointment with `APPOINTMENT_ID 2` from ToothTracker.


### Listing all appointments: `list-appointment`

Shows a list of all appointments in ToothTracker.

This is helpful when:
- you want to retrieve the information of all appointments.
- you want to verify that the appointment is added to ToothTracker.

**Format:** `list-appointment` (No extra parameters required)

### Filtering Appointments by `DENTIST_ID`: `filter-appointment dentist`

Filters the appointment list to show the list of appointments under the dentist with the specified `DENTIST_ID`.

This is useful when:
- you want to view the list of appointments under a specific dentist.

**Format:** `filter-appointment dentist DENTIST_ID`

<div markdown="block" class="alert alert-info">
`DENTIST_ID` refers to the index number shown in the displayed list of dentists. <br>
You may use `list-dentist` to check out the `DENTIST_ID` first.
</div>

**Example:**

* `filter-appointment dentist 1` returns all appointments under the dentist with `DENTIST_ID 1`.

### Filtering Appointments by `PATIENT_ID`: `filter-appointment patient`

Filters the appointment list to show the list of appointments under the patient with the specified `PATIENT_ID`.

This is useful when:
- you want to view the list of appointments under a specific patient.

**Format:** `filter-appointment patient PATIENT_ID`

<div markdown="block" class="alert alert-info">
`PATIENT_ID` refers to the index number shown in the displayed list of patients. <br>
You may use `list-patient` to check out the `PATIENT_ID` first.
</div>

**Example:**

* `filter-appointment patient 1` returns all appointments under the patient with the `PATIENT_ID 1`.


## Part 4 - Treatment Features

### Adding a treatment: `add-treatment`

You can add a new dental treatment to the ToothTracker system using the `add-treatment` command.
This command allows you to specify the treatment name, the cost of treatment, and how long the treatment would take.
The treatment would be stored in ToothTracker's internal storage.

**Format:** `add-treatment tr/NAME cs/PRICE ti/DURATION`

**Example:**

* `add-treatment tr/Tooth Extraction cs/1080 ti/10:30` adds a tooth extraction treatment to ToothTracker with a cost of $1080 SGD, and
  duration of 10 hours and 30 minutes.

**Important Notes:**

- Ensure that you provide treatment name, its cost and its duration when using the `add-treatment` command.
- ToothTracker will not allow duplicate treatment names. If a treatment with the same name already exists, you will be
  prompted to provide a unique name.

### Listing all treatments : `list-treatment`

Shows a list of all treatments in ToothTracker. This is useful when:

* You want to view the currently available treatments stored in ToothTracker.

Format: `list-treatment` (No extra parameters required)


### Deleting a treatment: `delete-treatment`

Deletes the specified treatment from ToothTracker.

**Format:** `delete-treatment TREATMENT_NAME`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE!
Treaments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
`TREATMENT_NAME` must be an exact match
</div>

**Example:**

* `delete-treatment Braces` deletes the treatment `Braces` from ToothTracker.

## Part 5 - General Features

### Clearing all entries : `clear`

Clears all entries from ToothTracker. Proceed with Caution!

Format: `clear`

### Exiting the program : `exit`

Exits ToothTracker app.

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

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous ToothTracker home folder.

**Q**: Why do I get an error while trying to edit an existing dentist/patient?<br>
**A**: The dentist/patient to be edited may not be shown in ToothTracker.
To display the to-be-edited dentist/patient, you may use these commands:
1. `list-dentist` or `list-patient`
2. `search-dentist` or `search-patient`

Thereafter, you may edit the particulars using `edit-dentist` or `edit-patient` with their `DENTIST_ID` or `PATIENT_ID`
respectively.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                           | Format, Examples                                                                                                                                                                                                                                    |
|----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Dentist**                  | `add-dentist n/NAME p/PHONE s/SPECIALIZATION y/YOE [e/EMAIL] [h/ADDRESS] [t/TAG]…​` <br> e.g., `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`                                                                                      |
| **Edit Dentist**                 | `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​` <br> e.g., `edit-dentist 1 p/98987676 e/bobjuly@gmail.com`                                                                                  |
| **Delete Dentist**               | `delete-dentist DENTIST_ID`<br> e.g., `delete-dentist 3`                                                                                                                                                                                            |
| **List Dentist**                 | `list-dentist`                                                                                                                                                                                                                                      |
| **Search Dentist by Dentist ID** | `search-dentist DENTIST_ID` <br> e.g., `search-dentist 2`                                                                                                                                                                                           |
| **Search Dentist by Keyword**    | `search-dentist KEYWORD` <br> e.g., `search-dentist Tom`                                                                                                                                                                                            |
| **Filter Dentist**               | `filter-dentist a/ATTRIBUTE k/KEYWORDS` <br> e.g., `filter-dentist a/phone k/90182211`                                                                                                                                                              |
| **Add Patient**                  | `add-patient n/NAME p/PHONE b/BIRTHDATE g/GENDER s/SERVICE [e/EMAIL] [h/ADDRESS] [r/REMARK] [t/TAG]…​` <br> e.g., `add-patient n/John p/90676622 b/06-06-1998 g/M r/Allergic to Peanuts tr/Braces e/johntan@gmail.com h/60 Harvey Avenue t/Urgent`  | 
| **Delete Patient**               | `delete-patient PATIENT_ID`<br> e.g., `delete-patient 3`                                                                                                                                                                                            |
| **List Patient**                 | `list-patient`                                                                                                                                                                                                                                      |
| **Search Patient by Patient ID** | `search-patient PATIENT_ID`  <br> e.g., `search-patient 3`                                                                                                                                                                                          |
| **Search Patient by Keyword**    | `search-patient KEYWORD` <br> e.g., `search-patient John`                                                                                                                                                                                           |
| **Filter Patient**               | `filter-patient a/ATTRIBUTE k/KEYWORDS` <br> e.g., `filter-patient a/phone k/98776211`                                                                                                                                                              |
| **Add Treatment**                | `add-treatment tr/NAME cs/PRICE ti/DURATION` <br> e.g., `add-treatment tr/Tooth Extraction cs/150 ti/01:00`                                                                                                                                         |
| **Delete Treatment**             | `delete-treatment NAME` <br> e.g., `delete-treatment Braces`                                                                                                                                                                                        |
| **List Treatment**               | `list-treatment`                                                                                                                                                                                                                                    |
| **Add Appointment**              | `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_TIME s/TREATMENT` <br> e.g.,`add-appointment dentist/0 patient/0 start/2023-10-12 16:00 s/Braces`                                                                                |
| **Delete Appointment**           | `delete-appointment APPOINTMENT_ID`<br> e.g., `delete-appointment 3`                                                                                                                                                                                |
| **List Appointment**             | `list-appointment`                                                                                                                                                                                                                                  |
| **Filter Appointment by Dentist ID** | `filter-appointment dentist DENTIST_ID` <br> e.g., `filter-appointment dentist 1`                                                                                                                                                                   |
| **Filter Appointment by Patient ID** | `filter-appointment patient PATIENT_ID` <br> e.g., `filter-appointment patient 1`                                                                                                                                                                   |
| **Clear all Profiles**           | `clear`                                                                                                                                                                                                                                             |
| **Exit Programme**               | `exit`                                                                                                                                                                                                                                              |
| **Help**                         | `help`                                                                                                                                                                                                                                              |


