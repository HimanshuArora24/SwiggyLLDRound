# Magical Arena

This is the Magical Arena game. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 

## Running

### On Local

Please have Java 19 installed

Run the following commands

`javac -cp src/main/java src/main/java/MagicalArenaGame.java`

`java -cp src/main/java MagicalArenaGame`

### Via Docker

Run the following commands

`docker build -t magical-arena .`

`docker run -it magical-arena `
