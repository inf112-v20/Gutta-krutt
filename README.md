# Robo Rally [![Build Status](https://travis-ci.com/inf112-v20/Gutta-krutt.svg?branch=master)](https://travis-ci.com/inf112-v20/Gutta-krutt) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/bb70fbcc87ab437c85e2f1a17cf31c35)](https://www.codacy.com/gh/inf112-v20/Gutta-krutt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v20/Gutta-krutt&amp;utm_campaign=Badge_Grade)

![Logo](https://github.com/inf112-v20/Gutta-krutt/blob/master/assets/extra/logo.png)

Our goal is to create the most realistic digital versjon of the classic Robo Rally Board Game. To achieve our goal we have to implement necessary game functions as: walls, lasers, pushers, rotators etc...

We got the rules from: [RoboRally Rulebook 2016](https://media.wizards.com/2015/rules/robo_rally_rules.pdf)

## Game content
-   [2 Player boards](https://github.com/inf112-v20/Gutta-krutt/tree/master/assets/Maps) (With a possibility to make unique boards, just [install Tiled](https://www.mapeditor.org/) and you're good to go!)
-   [Rulebook](https://github.com/inf112-v20/Gutta-krutt/tree/master/assets/extra/)
-   [6 Awesome robots](https://github.com/inf112-v20/Gutta-krutt/tree/master/assets/Robots)
-   3 Flags
-   82 Programcards 
-   One sequence board

## Setup
1.  Install [Maven](https://maven.apache.org/download.cgi)
2.  Clone git repostery: `git clone git@github.com:inf112-v20/Gutta-krutt.git`
3.  Build game with: `mvn clean install`

### How to run the game
-   Run main.java which is located in: _src/main/java/roborally_in your IDE of choice.
-   Press the start button

### How to play
-   Press <kbd>G</kbd> to switch between _GameScreen_ and _SequenceScreen_
-   Card in slot 1-9 corresponds with key <kbd>1</kbd> - <kbd>9</kbd> (eks: press 1 to choose card 1)
-   Choose cards in the right order 1 - 5
-   Press <kbd>L</kbd> to lock inn and execute sequence 
-   Press <kbd>P</kbd> to enter the "user manual"
#### (Look beneath for a preview of our game)

## Bugs
Currently throws "WARNING: An illegal reflective access operation has occurred", when the java version used is >8. This has no effect on function or performance, and is just a warning.

![Player Board](https://github.com/inf112-v20/Gutta-krutt/blob/master/assets/extra/GameBoard.png)
![Sequence Board](https://github.com/inf112-v20/Gutta-krutt/blob/master/assets/extra/SequenceBoard.png)
