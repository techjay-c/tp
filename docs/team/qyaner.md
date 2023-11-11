---
layout: page
title: Qin Yan Er's Project Portfolio Page
---

### Project: ToothTracker

**Overview**

ToothTracker is an all-in-one solution designed to revolutionize
the management of dental clinic records.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=qyaner&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos)

* **Enhancements implemented**:
    * Appointment features
      * `add-appointment`: Added the ability to add an appointment into ToothTracker.
        * What it does: Allows user to add in an appointment to ToothTracker.
        * Justification: This feature is an essential feature of ToothTracker as it allows user to keep track
        of their clinic's past and future appointments. It helps to simplify the process of recording down an
        appointment.
        * Highlights: The command is heavily intertwined with other commands as it needs to retrieve
        critical information from the model. If other add commands do not work, `add-appointment` would not work either.
        It was difficult trying to retrieve the correct information and also checking for appointment clashes.
      * `delete-appointment`
        * Deletes an appointment from ToothTracker permanently. This is done using a unique appointment id.
      * `filter-appointment`
        * What it does: Filters appointment by dentist id or patient id. 
        * Justification: This command provides user with a more convenient way to view appointments. Instead of
        scrolling down a long list of appointments, user can just filter to view the appointment with the specific
        dentist or patient easily.

* **Documentation**:
    * User Guide:
        * Added documentation for appointment features
    * Developer Guide:
        * Added documentation for appointment features

* **Team-based Tasks**:
    * to be added soon

* **Review/mentoring contributions**:
    * to be added soon

* **Beyond the project team**:
    * to be added soon
