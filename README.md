# Atulyam

This app uses google firebase auth to signup/login.
and firebase database to read and write.<br>
 Key features recyclerView, fragments, gradient etc.<br>
find this on playstore
https://play.google.com/store/apps/details?id=com.sauravkumar71920gmail.atulyam
(Removed due to change in play store policies, updation required)

this is the splash screen of app.

![webp net-resizeimage](https://user-images.githubusercontent.com/33747587/42918214-84b63b08-8b2a-11e8-93d4-6a27ab73139e.png)


Log in Screen and Sign up Screen

![webp net-resizeimage 1](https://user-images.githubusercontent.com/33747587/42918300-f2e09434-8b2a-11e8-87b2-e59c3f3d7719.png) ![webp net-resizeimage 2](https://user-images.githubusercontent.com/33747587/42918381-3c93d154-8b2b-11e8-8e6f-0b4aa453d80a.png)

Main Activity Screen

![webp net-resizeimage 3](https://user-images.githubusercontent.com/33747587/42918483-a4ba53ca-8b2b-11e8-89b5-b7a3d60622a4.png) ![webp net-resizeimage 4](https://user-images.githubusercontent.com/33747587/42918545-dd87fa54-8b2b-11e8-9f70-fd1c7f2657c9.png)

Flow of app :-<br>
Splash screen is entry point of the app then reditrected to Main Activity screen with checking authentication of user. If user is authorised then it stays there else redirected to login screen. If the user is not yet signed then it will be done by clicking NOT A MEMBER SIGNUP text. 

Purpose of app :- <br>
It is used for registration of different events held in our college cultural festival respective to their category. By clicking "Register"
button user's identity that is their login credential will be saved in my google firebase databse with their respective events.

Explanation of Activities :- <br>

1. SplashActivit.java :- <br>
   It is the entry point of app showing the starting image for 1.5 seconds.
   
2. LogInActivity.java :-<br>
   It is the login screen. Email and password, that is used when the user signed up in the app. Google firebase authentication is used
   for authentication.
   
3. SignUpActivity.java :- <br>
   Four feeds are required to signup. Google firebase authentication is used here.
  
4. MainActivity.java :- <br>
   It is the main activity in which five fragments are attached.<br>
   On side navigation. Four option are there :-
                                            1. visit our website :- By clicking on that user will redirected to website
                                            2. Notification - By clicking on that NotifictaionActivity.java will open.
                                            3. About us - It is redirected to AboutUsActivity.java.
                                            4. Log Out - user can logout from the app by clicking on it.
                                            
5. NotificationActivity.java :-<br>
   It contain listview to show dynamic changes fetching from google firebase database.
   
6. AboutUsActivity.java :-<br>
   It contain developer and designer information who developed the app.
   
   
### Packages
 Fragements:- It conatin 5 different fragments. Each fragment contain recycler view to show dynamic event list which is updates on        google firebase database.<br>
 
 TopicsAdapter:- It contain recycler view's flow.
 

