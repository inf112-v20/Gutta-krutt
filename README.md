![Gutta Krutt](logo.png)
# Robo Rally [![Build Status](https://travis-ci.com/inf112-v20/Gutta-krutt.svg?branch=master)](https://travis-ci.com/inf112-v20/Gutta-krutt) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/bb70fbcc87ab437c85e2f1a17cf31c35)](https://www.codacy.com/gh/inf112-v20/Gutta-krutt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v20/Gutta-krutt&amp;utm_campaign=Badge_Grade)
Out goal is to create the most realistic digital versjon of the classic Robo Rally Board Game. To achieve our goal we have to implement necessary game functions as: walls, lasers, pushers, rotators etc...

We got the rules from: [RoboRally Rulebook 2016](https://media.wizards.com/2015/rules/robo_rally_rules.pdf)

## Game content
-   ["x" Player boards](https://github.com/inf112-v20/Gutta-krutt/tree/master/assets/Maps)
-   [Rulebook]()
-   [6 Awesome robots](https://github.com/inf112-v20/Gutta-krutt/tree/master/assets/Robots)
-   4 Flags
-   82 Programcards 
-   One sequence board
-   One 30-second timer

## Setup
1.  Install [Maven](https://maven.apache.org/download.cgi)
2.  Clone git repostery: `git clone git@github.com:inf112-v20/Gutta-krutt.git`
3.  Build game with: `mvn clean install`

### How to run the game
-   Run main.java which is located in: _src/main/java/roborally_ in intellij.
-   Press the start button
-   Move around with the arrows

### How to play
-   G to switch between gamescreen and and sequencescreen.
-   Numbers 1-9 to pick available cards.
-   R to remove the card last added

## GDX-Skin
Big shoutout to [Raymond "Raeleus" Buckley](https://ray3k.wordpress.com/software/skin-composer-for-libgdx/)
for letting us use [Star Soldier UI Ver. 1](https://github.com/czyzby/gdx-skins/tree/master/star-soldier).

Visit: [ray3k.wordpress](ray3k.wordpress.com) for games, tutorials, and much more!

## Bugs
Currently throws "WARNING: An illegal reflective access operation has occurred", when the java version used is >8. This has no effect on function or performance, and is just a warning.
