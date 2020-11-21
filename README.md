# Pet-Rescue

## Todo list

- Define the differents levels and stock them on a hard disk
- Introduce constraints and options as things progress
- How to remove a case
- Define the obstacles fixed
- How to represente the board

## Some advices in this implementation

- Split the model and the view
- Split the differents works in objects and methods
- Game environment : where we choose the level, the player's progression. We can also make a demonstration and present him the rules.
- Board : Case\[\]\[\], be careful to play in the cases 
- Add a bot who could play instead of a human ?

## Running the software 

 First you have to do : 
 
 ```
 javac PetRescue.java
 ```
 
You can simply do this to run the first level :
 
 ```
 java PetRescue
 ```
 
 Or you have several possible options :
 
 ``` 
 java PetRescue --level "int"
 ```
 
 And then u can add the graphical interface :
  
 ```
 java PetRescue --level "int" -g
 ```
 
 Or even to let's a bot play :
 
  ```
 java PetRescue --level "int" -b
 ```
 
 You can show the help with the following command : 
 
 ```
 java PetRescue -h
 ```
 
