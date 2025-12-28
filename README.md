# Quiz-Master
A simple time-based Java quiz application built with Swing and AWT, featuring user login, timed multiple-choice questions, and a final results screen.
This project was developed as a solo project to demonstrate Java GUI development and application architecture.
________________________________________
## Features
•	User login with custom username

•	Multiple-choice questions (A, B, C, D)

•	15-second countdown timer per question

•	Automatic answer submission when time expires

•	Visual feedback for incorrect answers

•	Final score displayed as a percentage

•	Rules, About, and Highest Scores windows

•	Smooth navigation between screens

•	Ability to restart the quiz from the main menu
________________________________________
## Tech Stack
•	Java (JDK 22)
•	Java Swing & AWT
•	IntelliJ IDEA 2024.1.1
•	Canva (UI header image)
________________________________________
## Project Structure
src/

├── Main.java

├── QuizLoginPage.java

└── QuizPage.java

resources/

└── quiz_master_header.png

out/

└── artifacts/

└── Quiz_app_jar/
    
└── Quiz_app.jar
________________________________________
## Prerequisites
•	Java installed on your system

o	Recommended: JDK 22

o	Compatible: Java 8+

Run the Application
From the directory containing the JAR file:
java -jar Quiz_app.jar
If the JAR does not open:

•	Verify Java installation (java -version)

•	Check file permissions and paths

•	Use Jarfix on Windows if needed
________________________________________
## Application Overview

•	Main – launches the application

•	QuizLoginPage

o	Handles username validation

o	Navigation to Rules, About, Scores, and Quiz

•	QuizPage

o	Core quiz logic

o	Question handling with timer

o	Answer validation and result calculation

Questions and answers are stored in arrays, and event handling is managed through the ActionListener interface.
