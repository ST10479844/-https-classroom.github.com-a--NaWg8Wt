Playlist Manager:

What is playlist manager?
Playlist manager is a minimalist yet powerful android app designed to help people keep track of their playlists.Built using Kotlin this app leverages parallel arrays, loops and multiscreen navigation to deliver a seamless listening experience!

FEATURES THAT THE APP COMES WITH:

![screen shot main screen](https://github.com/user-attachments/assets/a3840961-0c97-48cd-ab71-f9690ec1061a)

On the main screen we have 4 edit texts for the user to input the song name, artist name, what they would rate the song from 1 to 5 and a comment for the song. The add to list button adds all the user inputs into a parallel array, it supposed to clear the edit texts for the user to enter more inputs but mine closes the emulator. The go to detailed view screen button navigates the user to the second activity which is the display screen. The exit button terminated the app completely.

![screen shot display screen](https://github.com/user-attachments/assets/e785d3f7-ea96-4335-b0fd-2d54909b7b09)

On the display screen we have a button at the top that when clicked it will display all the user inputs in the textview provided below. The second button will calculate the average of the ratings of all the songs. Once the average is created, it will be displayed in the second textview below the calculate average button. The final button on the display screen is a main screen button that will navigate the user back to the main screen.

HOW DOES IT WORK?
Parallel arrays: Data is stored in a synchronized list. Each index represents 1 complete playlist.
Loops: Used to display and filter data dynamically.
Navigation: Intent based switching screens.
Validation: Input checked for completeness and logic.

ERROR HANDLING?
Empty Fields:  You'll get a friendly message
Invalid quantity:  We'll ask you to try again
Heres an example of what you can expect:
![error handling](https://github.com/user-attachments/assets/f5f6df35-4560-494b-9e7b-2cebf8ca9b55)

EXAMPLE PLAYLIST:
1. You, Lloyd, 4, RnB
2. Fein, Travis Scott
3.Only, Drake, 1, Rap

BUILT WITH:
Language:  Kotlin
IDE: Android Studio Ladybug
UI Elements: Buttons, Edit texts, Textviews
Core Concepts: Parallel Arrays, Control Flows, Intents, Error Handling

DEVELOPER NOTE:
This app was developed as part of a Kotlin Learning journey - 


