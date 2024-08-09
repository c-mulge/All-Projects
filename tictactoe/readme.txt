Tic-Tac-Toe Game
Overview
This is a simple implementation of the classic Tic-Tac-Toe game using Java Swing for the graphical user interface (GUI). The game allows two players to take turns placing their marks ('X' and 'O') on a 3x3 grid. The game detects and announces when a player wins or if the game ends in a tie.

Features
A 3x3 grid of buttons representing the Tic-Tac-Toe board.
Alternating turns between two players ('X' and 'O').
Detection of win conditions (rows, columns, diagonals) and a tie.
Reset functionality to start a new game after a win or tie.
Requirements
Java Development Kit (JDK) 8 or higher.
How to Run
Clone the Repository:

bash
Copy code
git clone <repository-url>
Navigate to the Project Directory:

bash
Copy code
cd <project-directory>
Compile the Code:

bash
Copy code
javac com/example/tictactoe/tictactoegame.java com/example/tictactoe/tictactoeboard.java
Run the Game:

Copy code
java com.example.tictactoe.tictactoeboard
How to Play
When the game starts, a window titled "Tic-Tac-Toe" will appear with a 3x3 grid of buttons, each labeled with a hyphen ('-') indicating an empty cell.

The first player (Player 'X') clicks on any empty button to place their mark. The button label will change to 'X'.

The second player (Player 'O') then clicks on an empty button to place their mark. The button label will change to 'O'.

Players continue taking turns, trying to get three of their marks in a row, column, or diagonal.

The game checks for a win or a full board after each move:

If a player wins, a message box will appear announcing the winner.
If the board is full and there is no winner, a message box will announce that the game is a tie.
After a win or a tie, the board will reset, and a new game can be started.

Code Structure
tictactoegame: Contains the game logic, including methods to place marks, check for a win or tie, and change the current player.
tictactoeboard: Extends JFrame and sets up the GUI with a 3x3 grid of buttons. It handles button clicks, updates the board, and interacts with the tictactoegame class to manage game state.
Customization
You can customize the appearance of the game by modifying the initializeButtons method in the tictactoeboard class.
You can also add additional features or enhancements, such as a scoring system or an AI opponent, by extending the tictactoegame class.
License
This project is open-source and available under the MIT License. Feel free to use, modify, and distribute it as you like.

Feel free to modify this README to better fit your project and any additional details or instructions you might want to include.