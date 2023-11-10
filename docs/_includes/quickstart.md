## Get Started with ToothTracker
Welcome to ToothTracker! We're excited to help you streamline your dental practice with ease.
This quick start guide will walk you through the setup and basic operations of ToothTracker so you can begin optimizing your clinic's workflow right away.

### Installing ToothTracker

Haven't installed ToothTracker yet? Follow our easy step-by-step guide below to get ToothTracker up and running in no time.
Our software is compatible with Windows, macOS, and Linux for optimal performance.


1. ToothTracker requires **Java 11 or above** installed in your Computer to run.
    - If you're missing Java, no worries — it's free to install! Find detailed installation instructions [here](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A).

    <div markdown="span" class="alert alert-primary">
      :bulb: **Tip:** Unsure about your Java version? Our [troubleshooting](#troubleshooting) section has you covered with a quick guide.
    </div>
   
1. Grab the latest version of ToothTracker by downloading the `toothtracker.jar` file from our [releases page](https://github.com/AY2324S1-CS2103T-W10-3/tp/releases).

1. Create an empty folder in your computer where you would like to use as the _home folder_ for ToothTracker.

1. Place the downloaded ToothTracker file (`toothtracker.jar`) into the folder.

Installation complete! You're now ready to launch ToothTracker.

### Launching ToothTracker
Great! Now that you have downloaded ToothTracker (if not, refer to the [Installation Instructions](#installation-instructions)), let's get it up and running.

1. Open a command terminal.
2. Enter `cd` and change your working directory into the folder you put the `toothtracker.jar` file in.
3. Enter the `java -jar toothtracker.jar` command to run the application.

A user-friendly GUI will pop up shortly, preloaded with some sample data to get you started.<br>
![Ui](images/Ui.png){: .centered-image }

### Familiarising with ToothTracker's interface
Now that you have ToothTracker up and running, let's get you familiar with ToothTracker's user interface!

ToothTracker has two windows: a [Main Window](#main-window) and a [Calendar Window](#calendar-window).
Let's take a closer look at each window individually.

{: .no_toc}
#### Main Window
When you first open ToothTracker, the Main Window will open by default.
It's designed to give you a comprehensive overview of all your patient, dentist, and appointment-related information at a glance.
Let's learn what each of these components does!

![ToothTracker UI](images/UiAnnotated.png){: .centered-image-full-size }

|   | Component        | Description                                                                                                                                                                                                             |
|---|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Menu Bar         | The menu bar contains menu options to [exit](#exiting-the-program-exit) from ToothTracker and access [help](#viewing-help--help) resources.                                                                             |
| 2 | Command Input    | The command input is where you can key in your commands to tell ToothTracker what you want to get done. To learn more about ToothTracker's CLI, refer to the [next section](#toothtrackers-command-line-interface-cli). |
| 3 | Result Display   | The result display area shows you the outcomes or feedback from your entered commands.                                                                                                                                  |
| 4 | Patient List     | This panel lists all patients currently registered in your clinic. It includes vital information such as names, contact details, and other fields.                                                                      |
| 5 | Dentist List     | Here, you'll find a roster of dentists associated with your clinic, complete with their specializations and contact information.                                                                                        |
| 6 | Appointment List | Check the appointment list for the schedule, status, and details of all clinic appointments.                                                                                                                            |
| 7 | Quick Notes      | A dedicated space at the bottom of the Main Window for on-the-fly notes, reminders, or observations that you need to keep handy.                                                                                        |
| 8 | Saved Data File  | For advanced users, the [file path](#glossary) displayed here is where ToothTracker stores your saved data (which you can [edit](#editing-the-data-file)).                                                              |

{: .no_toc}
#### Calendar Window
ToothTracker's Calendar Window provides a visual representation of your clinic's schedule. This view becomes available after executing a [Calendar Command](#viewing-calendar--view-calendar).
It allows you to easily understand your clinic's appointments and availability at a glance.

![Calendar Window](images/ug/CalendarWindowAnnotated.png){: .centered-image-full-size }

|   | Component           | Description                                                                                                                                                 |
|---|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | View Toggle         | The View Toggle allows you to switch between different calendar views: Day, Week, Month, or Year to get a more precise or broader overview of appointments. |
| 2 | Navigation Buttons  | The navigation arrows let you move to the previous or next time periods, depending on the currently selected view (day, week, month, or year).              |
| 3 | Appointment Entries | This section displays the specifics of each appointment, including the appointment ID, patient name, dentist name and appointment time.                     |


### Using ToothTracker's CLI
ToothTracker is optimized for use via a Command Line Interface which means you can do what you want to get done just
by using text input (known as commands).

Right now, ToothTracker only understands certain commands (the complete list of commands can be found in [Features](#features))
and these commands must be formatted in a specific way.
It’s just the way ToothTracker is wired to think and listen. So let’s learn how to talk to ToothTracker!


{: .no_toc}
#### How to Input Commands
Think of the Command Input as ToothTracker’s ‘ears’. This is the rectangular text input box outlined in red below.

1. Click on the Command Input box.
2. Type in your command.
3. Press ‘Enter’ on your keyboard (or ‘return’ if you're on a Mac).

That's it! ToothTracker has just executed your command. It’s that easy!

{: .no_toc}
#### Understanding Command Format
Every command you input follows a simple structure to help ToothTracker understand your needs:

* **Command Word:** This is the first word of your command. It acts like a direct order to ToothTracker, telling it precisely what action you want to take.
* **Index:** When your command relates to a specific patient, dentist or appointment, you'll use an index. It's a unique number assigned to each entry in the respective lists.
* **Flags:** These are markers to distinguish between inputs. A flag is usually followed by a placeholder.
* **Placeholders:** These are temporary labels that you'll replace with actual data. For instance, replace 'TREATMENT' in tr/TREATMENT with the real name of a treatment, like tr/Braces.


### Trying out your first commands
Can't wait to get started with ToothTracker? Let's go through some simple commands together to get you warmed up before you dive into ToothTracker's full feature list!

<div markdown="span" class="alert alert-info">
**:information_source:** Images in this section are only meant to be used as references.
Data shown in this sample reference may differ from the data stored in your ToothTracker.
</div>


Let's start by going through some simple dentist-related commands! 

1. Suppose you have a dentist, named Jonathan Goh, who joined your clinic. <br>
Try running the command `add-dentist n/Jonathan Goh p/92095568 e/jonathan.goh@gmail.com y/3 s/Paediatric Dentistry`.
   - Notice that you've created a new dentist, Jonathan Goh!

![trying-command-add-dentist-example](images/ug/add-dentist-example.png){: .centered-image-full-size }

2. Now, suppose that a dentist, Alex Yeoh, is leaving your clinic, and you want to delete his records from ToothTracker.
You can do this by running `delete-dentist 1`.
   - After executing the command, Alex Yeoh is now deleted from ToothTracker!

![trying-command-delete-dentist-example](images/ug/delete-dentist-example.png){: .centered-image-full-size }

Now that you’ve been introduced to some dentist-related commands, let’s change things up by trying out some patient commands.

1. Suppose you have a new patient, named Jean, onboarding your clinic. <br>
Try entering the command `add-patient n/Jean p/95339212 b/14-09-2001 g/F`.
   - Notice that you've created a new patient, Jean!

![trying-command-add-patient-example](images/ug/add-patient-example.png){: .centered-image-full-size }

2.  Now, suppose that you want to change the phone number of your patient, Alex. Easy! Just type in `edit-patient 1 p/82019452`.
   - Done! Alex's phone number has been updated!

![trying-command-edit-patient-example](images/ug/edit-patient-example.png){: .centered-image-full-size }

Awesome! Now that you've gotten familiar with ToothTracker's commands, feel free to explore more features in the
[Features](#features) section to fully leverage ToothTracker's capabilities.
