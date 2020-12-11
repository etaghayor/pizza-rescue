# Pizza-Rescue

## Todo list
##### Must have
- Make the game works quickly (remove a case, create a board, represente the board, define the obstacles fixed, be carefull to play in the cases)
- Use a simple text interface to allows the player to play
- Create one or two levels and check our game work well

##### Should have
- Stock the different levels on the disk (via Serializable)
- Have a basic window on which we can play levels
- Handle and check that we can run the code on console, without have to use an IDE, and handle the .class files
- Make a basic UML file with ObjectAid 

##### Could have
- Add a bot who could play instead of a human
- Ask for some help
- Go back and cancel our last turn

## Running the software 

 First you have to do : 
 
 ```
 javac PizzaRescue.java
 ```
 
You can simply do this to run the first level :
 
 ```
 java PizzaRescue
 ```
 
 Or you have several possible options :
 
 ``` 
 java PizzaRescue --level "int"
 ```
 
 And then u can add the graphical interface :
  
 ```
 java PizzaRescue --level "int" -g
 ```
 
 Or even to let's a bot play :
 
  ```
 java PizzaRescue --level "int" -b
 ```
 
 You can show the help with the following command : 
 
 ```
 java PizzaRescue -h
 ```
 
