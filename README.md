## LDTS_0603 - Dino

This game is strongly inspired on the hidden Chrome browser game when there is no internet. The objective of the game is to control Dino avoiding colliding with obstacles (buildings,  cities and planes) coming from the right.
There are collectables that, if you catch them, can help you to score more points. The points are counted by the distance you travelled since the start of the game.
This project was developed by:
- **Guilherme Silveira Rego** (up202207041)
- **João Pedro Nogueira da Hora Santos** (up202205784)
- **Leonardo de Sousa Magalhães Teixeira** (up202208726)

LDTS 2023/24 <br>
Software Design and Testing Laboratory

### IMPLEMENTED FEATURES

- **Menu** - The game has a menu that can be accessed at the beginning of the game as soon as we run it, and when we lose. The menu has four options:
  - **Start** - Starts a new game.
  - **Instructions** - Displays the instructions of the game.
  - **Leaderboard** - Displays the three highest scores.
  - **Exit** - Exits the game.
- **Playable character** - Dino jumps when the arrow up  key or the space bar is pressed, crouches when the arrow down key is pressed, and uses a bomb if he has it his inventory pressing the arrow left key. If the arrow key or the space bar are pressed when Dino is crouched he will return to his "normal mode".
- **Random obstacles** - There is two possible obstacles that can be randomly generated: a plane, or a city, which is a group of buildings that are either small or large, and could appear as a group of three, two, or just one building.
- **Collectables** -The game has collectable objects that can be consumed by the player:
  - **Bomb** - If the player catches a bomb, it will be stored in his inventory (which is represented in the top right corner, with a counter of the number of bombs the player has) to use whenever he wants to explode the next obstacle. There is a maximum capacity of the inventory of 5 bombs.
  - **Shield** - Dino is able to wear a shield that protects him for a short time (that is represented ion the top left corner). If he collides with an obstacle when he's wearing the shield, the player will not lose.
  - **Boots** - The game character has a higher jump during a certain period of time (which is represented ion the top left corner).
  - **Coin** - The coin will add 100 points to the player's score.
- **Collision detector** - The game has the ability to detect when Dino collides with the obstacles to make the player lose or when Dino catches a collectable to consume it.
- **Difficulty controller** - To make the game more dynamic, the more points you have, the faster it will become, making it increasingly difficult.
- **Music and sound effects** - There is background music and many sound effects throughout the game for each player's action.
- **Game Over** - The game displays a game over screen when the player collides with an obstacle. The player will have two options:
  - **Start** - Starts a new game.
  - **Menu** - The player goes to the main menu.

### PLANNED FEATURES

- All the features were implemented.

<br/>

![sketch1.png](src%2Fmain%2Fresources%2Fmockups%2Fsketch1.png)
![sketch2.png](src%2Fmain%2Fresources%2Fmockups%2Fsketch2.png)
### DESIGN

#### CODE'S STRUCTURE

**Problem in Context**

As the game's complexity grows, the code becomes increasingly intricate, making it harder to comprehend and maintain over time.
This challenge escalates as new features are added, demanding more effort to manage and update the codebase effectively.

**The Pattern**

The MVC (Model-View-Controller) architecture proves beneficial as it segregates the code into three core components: the model, the view, and the controller.
The model handles data, the view manages the visual interface, and the controller oversees the game's logic.
These distinct components operate independently yet collaboratively, synergizing their functionalities to ensure the seamless operation of the game. This segregation enables efficient development, modification, and enhancement of each component without compromising the overall functionality of the game.

**Implementation**

![mvc.jpg](src%2Fmain%2Fresources%2Fuml%2Fmvc.jpg)

**Consequences**

Implementing MVC simplifies managing the game's complexity by dividing it into distinct parts: model, view, and controller. This division streamlines development, making it easier to update or enhance specific components without affecting the entire game's functionality.
It promotes a clearer structure and facilitates smoother collaboration between different aspects of the game, easing the management and evolution of the codebase as the game grows.


#### LANTERNA LIBRARY SIMPLIFICATION

**Problem in Context**

The GUI librabry (Lanterna) could be confusing and more extensive than we really need.
We should be able to make this framework easy to handle without affecting the rest of the code.

**The Pattern**

To solve this problem we use the **Facade** Pattern since it provides a
simplified interface to the library we are working with and assures that it can be easily changed.

**Implementation**

![facade.jpg](src%2Fmain%2Fresources%2Fuml%2Ffacade.jpg)

- Application - Client that uses our simplified interface GUI.
- GUI - Simplified interface of Lanterna library.
- LanternaGUI - Implements methods defined in GUI interface.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- [GUI](./src/main/java/ldts/dino/gui/GUI.java)
- [LanternaGUI](./src/main/java/ldts/dino/gui/LanternaGUI.java)

**Consequences**

By using the Facade Pattern, handling the Lanterna GUI library becomes simpler and more straightforward.
It reduces confusion and makes it easier for us to work with the library without needing extensive knowledge.
It makes our system easier to maintain and adapt, allowing us to make updates without causing major issues in the overall structure.


#### MANAGING GAME STATE TRANSITIONS

**Problem in Context**

The game contains different states (main menu, gameplay, game over) with specific behaviors and transitions between them.
The program should be able to easily change the state depending on the user
interaction with the game.

**The Pattern**

The **State** Pattern allows an object to alter its behavior when its internal state changes.
It'll help manage different game states and simplify state-specific behavior.

**Implementation**

![state.jpg](src%2Fmain%2Fresources%2Fuml%2Fstate.jpg)

- Application - The application will have a private state attribute. 
- State - It's the interface for the concrete states.
- GameState, MainMenuState, InstructionsState, ScoresState and GameOverState -
Concrete states.

These classes could be found in the following files:

- [Application](./src/main/java/ldts/dino/Application.java)
- [State](./src/main/java/ldts/dino/state/State.java)
- [GameState](./src/main/java/ldts/dino/state/GameState.java)
- [MainMenuState](./src/main/java/ldts/dino/state/MainMenuState.java)
- [InstructionsState](./src/main/java/ldts/dino/state/InstructionsState.java)
- [ScoresState](./src/main/java/ldts/dino/state/ScoresState.java)
- [GameOverState](./src/main/java/ldts/dino/state/GameOverState.java)

**Consequences**

Using the State Pattern simplifies managing different game states.
It enables smooth transitions between states based on user interactions and streamlines state-specific behaviors.
This approach ensures clearer code and easier future modifications or additions of new states, making the overall game development process more straightforward.
#### DIFFERENT COLLECTABLES MUST HAVE DIFFERENT EFFECTS

**Problem in Context**

Our game has various elements, these elements could be collectables.
There are four collectables (Bomb, Boots, Coin, Shield),
each one has a different effect on the game, so we need to have
a way to execute the effect of the collectable without having to check the
type.

**The Pattern**

To solve this we use the **Command** Pattern which grants 
each collectable its own execute command when they are collected by
the player.

**Implementation**

![command.jpg](src%2Fmain%2Fresources%2Fuml%2Fcommand.jpg)

- Game - Invoker.
- Collectable - Command.
- Bomb, Boots, Coin, Shield - Concrete commands.

These classes could be found in the following files:

- [Game](./src/main/java/ldts/dino/model/game/Game.java)
- [Collectable](./src/main/java/ldts/dino/model/game/elements/collectables/Collectable.java)
- [Bomb](./src/main/java/ldts/dino/model/game/elements/collectables/Bomb.java)
- [Boots](./src/main/java/ldts/dino/model/game/elements/collectables/Boots.java)
- [Coin](./src/main/java/ldts/dino/model/game/elements/collectables/Coin.java)
- [Shield](./src/main/java/ldts/dino/model/game/elements/collectables/Shield.java)

**Consequences**

???? 

#### RANDOMLY GENERATING ELEMENTS

**Problem in Context**

The game needs to generate random obstacles and collectibles in different ways during gameplay.
But, this generation has to have a logic behind it, for example, two elements
should not spawn in the same position.

**The Pattern**

The **Factory Method** Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.
It promotes the creation of objects through a common interface.

**Implementation**

![factorymethod.jpg](src%2Fmain%2Fresources%2Fuml%2Ffactorymethod.jpg)

- Creator - Abstract factory defining methods for creating different game elements.
- ObstacleCreator, CollectableCreator - Concrete creators extending methods to create specific elements
- Collectable, Obstacle - Elements.
- Bomb, Boots, Coin, Shield, Building, City, Plane - Concrete elements
made by the concrete creators.
- ElementsFactory - Controls the concrete creators.

These classes could be found in the following files:

- [Creator](./src/main/java/ldts/dino/model/game/creators/Creator.java)
- [CollectableCreator](./src/main/java/ldts/dino/model/game/creators/CollectableCreator.java)
- [ObstacleCreator](./src/main/java/ldts/dino/model/game/creators/ObstacleCreator.java)
- [Collectable](./src/main/java/ldts/dino/model/game/elements/collectables/Collectable.java)
- [Obstacle](./src/main/java/ldts/dino/model/game/elements/obstacles/Obstacle.java)
- [Bomb](./src/main/java/ldts/dino/model/game/elements/collectables/Bomb.java)
- [Boots](./src/main/java/ldts/dino/model/game/elements/collectables/Boots.java)
- [Coin](./src/main/java/ldts/dino/model/game/elements/collectables/Coin.java)
- [Shield](./src/main/java/ldts/dino/model/game/elements/collectables/Shield.java)
- [Building](./src/main/java/ldts/dino/model/game/elements/obstacles/Building.java)
- [City](./src/main/java/ldts/dino/model/game/elements/obstacles/City.java)
- [Plane](./src/main/java/ldts/dino/model/game/elements/obstacles/Plane.java)

**Consequences**

Using the Factory Method Pattern streamlines how our game generates obstacles and collectibles.
This pattern ensures a logical generation process, preventing elements from appearing in the same position.
By adopting this approach, we establish a consistent method for creating these objects, allowing different types to be generated while adhering to a unified structure. 
This simplifies our codebase, enabling the game to produce diverse elements with unique behaviors while maintaining a clear and systematic generation logic.

------

### TESTING

- Only menu and utils testing. Others still not implemented.

### SELF-EVALUATION

- Guilherme Rego: 33.3%
- João Santos: 33.3%
- Leonardo Magalhães: 33.3%

### UML DIAGRAM
https://www.planttext.com/
![uml.jpg](src%2Fmain%2Fresources%2Fuml%2Fuml.jpg)