---
layout: page
title: Ruth Lim's Project Portfolio Page
---

{: .no_toc}
### Project: ToothTracker

ToothTracker is an all-in-one solution for front desk administration staff in dental clinics to manage
patients/dentists/appointments. It is optimized for CLI users.

Given below are my contributions to the project.

* **New Feature**: Added the ability to delete dentist records.
(PR: [#71](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/71))
  * What it does: Allows the user to delete dentist records from ToothTracker using the dentist's unique ID.
  * Justification: This feature is vital for ToothTracker users as it ensures that dentist records can be deleted after
said dentist leaves the clinic.

* **New Feature**: Added the `view-calendar` feature and `CalendarWindow`
  * What it does: Allows the user to view all appointments in a Calendar.
  * Justification: User can visualise all appointments rather than scrolling through a long list.
  * Credits: `CalendarWindow` makes use of the [CalendarFX](https://github.com/dlsc-software-consulting-gmbh/CalendarFX) library, an open source calendar framework for JavaFX 8.

* **New Feature**: Added the Quick Notes Box
  * What it does: Provides a dedicated space for users to jot down quick reminders or notes directly within the ToothTracker application.
The Quick Notes Box is accessible at all times at the bottom of the main window.
  * Justification: This feature enhances user productivity by allowing the seamless tracking of to-dos and reminders
without the need for a separate application or physical note-taking. It's especially useful during patient or dentist
record management when the user needs to make a quick note of follow-ups or important information.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=ruth-lim&breakdown=true)

* **Contributions to team-based tasks**:
  * Set up GitHub team organization and project repo
  * Set up CodeCov for continuous integration

* **Enhancements to existing features**:
  * Change the theme of the GUI: Created mockups of UI in Figma and updated the styling from AB3 to the mockup designed.
([#67](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/67) and [#76](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/76))

* **Documentation**:
  * User Guide:
    * Modified site-wide settings: ([#26](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/26), [#50](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/50))
    * Renovated website: ([#96](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/96), [#153](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/153),)
    * Added documentation for Calendar feature
    * Added "How to use ToothTracker's User Guide" section
    * Added "Icons used in this guide" section
    * Added "Quick Reference Guide" section
    * Added auto numbering to Headings and Table of Content
    * Added screenshots for all examples ([#158](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/158))
  * Developer Guide:
    * Added implementation details for `delete-dentist` ([#126](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/126))
    * Update sequence diagram for `Logic` component
    * Update class diagram for `Ui` component
    * Added instructions for Manual Testing for appointment, treatment and calendar-related features ([#220](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/220))

* **Community**:
  * PRs reviewed (with non-trivial review comments): [#114](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/114),
[#119](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/119), [#145](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/145)
  * Reported bugs and suggestions for other teams in the class ([Link to repo](https://github.com/ruth-lim/ped))

* **Tools**:
  * Integrated a third party library (CalendarFX) to the project ([#125](https://github.com/AY2324S1-CS2103T-W10-3/tp/pull/125))

