# Balancing_teams

## Description
The primary goal is to develop a solution that divides a group of people into teams of equal size
while attempting to balance the teams in terms of the "rate" of each individual. The rate can
represent various attributes, such as skill level, experience, workload capacity, or any other relevant
metric.

Create functionality that:
• accepts input data that includes a list of individuals, each associated with their name and
rate. Desired number of teams is also given.

Sample:

name rate
"Johnny", 8
"Robbie", 5
"Juliet", 3
"Scarlet", 5
"Jude", 9
"Deborah", 6

Number of teams: 3

• returns selected teams. Summary of the outcome should be printed to the console in the
following format:
Team no 1 has 2 players (Jude, Juliet). Average rate: 6.0
Team no 2 has 2 players (Johnny, Robbie). Average rate: 6.5
Team no 3 has 2 players (Deborah, Scarlet). Average rate: 5.5
Teams rate standard deviation: 0.41

## System Requirements

To run tests in this project, you will need:

- Java 19
- Apache Maven

## Installation

1. Clone this repository to your computer:
   git clone https://github.com/BStchw/Balancing_teams

2. Navigate to the project directory.
3. Run the Maven command to install all dependencies and prepare the project:
   mvn clean install
4. To run the tests, navigate to the project directory and use the following Maven command:
   mvn test
