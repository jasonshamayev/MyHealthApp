# MyHealthApp

Devasri Warrier: 1001536613 devasri.warrier@mavs.uta.edu, 214-529-6269
Implementation 1: Personal Information:
  -Add Personal Information
  -View Personal Information saved in the DB
  -Update Personal Information
  -Respective functions in DatabaseHelper file to store into DB

Implementation 2: Monitoring System: On time Medication: -positive affirmation
  Late Medication: -NOK texted notice,  -user texted reminder, -Doctor + Pharm. email prepopulated message and emails pre-filled (if logged into email app
  and android permissions allowed)
  -User can add a self notification message  
  -Medication Tracker of dosage + days left to complete medication

Missing functionality: -not pulling data from DB of Personal Info. to text/email in monitoring system. Did not have time to finish implementation but harded coded works for email/texts -Medication tracker is only able to pull the 1st medication entered, not any respective medications added thereafter
-No notifications of missed medication. Only a self notify for a user to enter their own Notif to put in notification bar

Resources:
https://www.youtube.com/watch?v=tTbd1Mfi-Sk
https://www.youtube.com/watch?v=cp2rL3sAFmI&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07 (playlist videos 1-5)
https://www.youtube.com/watch?v=oLngUva-Ves
https://www.codota.com/code/java/classes/android.app.DatePickerDialog //in code, works, but not combined with implementations to basically useless 

Jason Shamayev: 
Implementations:
Login/Registration:
  -User can register
  -User can log in
  -"Forgot password"
  -"reset password" (security questions)
  -"change password"
  -log out
  -Necessary validations if values not entered correctly
  -Respective functions in DatabaseHelper file to store into DB
Medication:
  -User can add medication
  -User can view list of all medications entered
  -Necessary validations if values not entered correctly
  -Respective functions in DatabaseHelper file to store into DB
Resources: //add all resources

Jason Shamayev: 100
Implementations:
Login/Registration:
  -User can register
  -User can log in
  -"Forgot password"
  -"reset password" (security questions)
  -Necessary validations if values not entered correctly
  -Respective functions in DatabaseHelper file to store into DB
Medication:
  -User can add medication
  -User can view list of all medications entered
  -Necessary validations if values not entered correctly
  -Respective functions in DatabaseHelper file to store into DB
Settings:
  -Log out
  -Change Password
Home Screen:
  -Set up the layout for home screen
  -Made back buttons for navigation through app
Resources:
https://www.youtube.com/watch?v=d5jfNSFu45U
https://developer.android.com/studio/write






Saugat K: 1001644419, saugat.karki@mavs.uta.edu, 8174375349


Implementations:
Search:
-Missing functionality: Search function works only for vital signs and username. As we used SQL lite, every one made a seperate table to store data. So, 
 everyone had a separate numeric user ID to identify each user. So, I couldn't figure out a way to do extraction of data from their table for a specific user
 as each table had a seperate type of unique ID to idenitify each user. 
 The reason search  works for Vital Signs is because while creating table for storing vital signs, I just used the usernames of users as a unique
 ID. So, I could later match the current user's username with the username on the table and extract the required data. Since there can't be two users with same username 
 in our app, the search funcionality works perfectly with vital signs. 
-Users can search for their username by typing "username" in the search field. 
-Users can type any vital signs names(cholesterol, heart rate, blood pressure, glucose) in the search field. 
-If the Vital Signs data has been previously added or updated, users can search for any of the vital Signs. If not, a message will be printed asking user to  initialize 
  vital signs. 
-All inputs are case insensitive. 

Vital Signs:
-Enter Vital Signs (glucose, cholesterol, blood pressure, heart rate)
-Necessary validations if not entered correctly
-Review information regarding vital signs
-Submit vital signs
-Update vital signs

Resources:
https://www.youtube.com/watch?v=KUq5wf3Mh0c&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07&index=4
https://www.youtube.com/watch?v=NhrD_fokd7g

Cesar Rea: 1001643491
Cesar.rea2@mavs.uta.edu
Contact phone number: 2143257031

When going into the New Food Section of Diet, the app will not count the calories
and start from zero when back to main page of diet

New Food Names entered will not be added to the database, so it will not shown again

Implementations:
Diet:
-Enter amount of servings
-User can pick food choice from spinner
-User can press on New Food to add custom food.
-User press on next to display current total of calories
-User press on done

Communications:
-Users can enter phone number
-Users can enter SMS
-User can press on Message or Call

Resources:
https://www.youtube.com/watch?v=KUq5wf3Mh0c&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07&index=4
https://www.youtube.com/watch?v=4HkTrSkYAQ4
https://www.youtube.com/watch?v=pajvuBZc2WA
