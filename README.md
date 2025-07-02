# TimGame - Rock Paper Scissors

A console-based Rock Paper Scissors game implemented in Java with Russian language interface.

## 🎮 Overview

TimGame is a classic Rock Paper Scissors game where players compete against the computer. The game features:
- Interactive console interface in Russian
- Score tracking and game statistics
- Recursive gameplay allowing multiple rounds
- Random computer opponent moves

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA recommended) or command line tools

### Installation

1. Clone the repository:
```bash
git clone https://github.com/fifteenmsu/TimGame.git
cd TimGame
```

2. Compile the Java files:
```bash
javac -d out src/*.java
```

3. Run the game:
```bash
java -cp out Main
```

### Alternative: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. The project should be automatically configured (TimGame.iml included)
3. Run the `Main` class

## 🎯 How to Play

1. Start the game by running the Main class
2. When prompted with "Камень, ножницы или бумага?" (Rock, scissors or paper?), enter your choice:
   - **К** or **к** for Камень (Rock)
   - **Н** or **н** for Ножницы (Scissors) 
   - **Б** or **б** for Бумага (Paper)
3. The computer will make its move automatically
4. The winner of the round will be announced
5. After each round, you'll be asked "Хотите сыграть еще раз?" (Want to play again?)
   - Enter **Y** to continue playing
   - Enter any other key to end the game and see statistics

## 🏗️ Project Structure

```
TimGame/
├── src/
│   ├── Main.java              # Entry point of the application
│   └── RockPaperScissors.java # Main game logic and classes
├── out/                       # Compiled class files
├── .idea/                     # IntelliJ IDEA project files
├── TimGame.iml               # IntelliJ module file
└── README.md                 # This file
```

## 🔧 Technical Details

### Classes and Components

#### Main Class
- Simple entry point that initializes and starts the game
- Displays welcome message in Russian

#### RockPaperScissors Class
Main game controller containing:

**Inner Classes:**
- `User`: Handles player input and interaction
- `Computer`: Generates random moves for AI opponent

**Enums:**
- `Move`: Represents game moves (ROCK, PAPER, SCISSORS) with comparison logic

**Key Methods:**
- `startGame()`: Main game loop with recursive gameplay
- `printGameStats()`: Displays formatted game statistics table
- `compareMoves()`: Game logic for determining winners

### Game Rules

The standard Rock Paper Scissors rules apply:
- Rock beats Scissors
- Scissors beats Paper  
- Paper beats Rock
- Same moves result in a tie

### Statistics Tracking

The game tracks:
- **Wins**: Player victories
- **Losses**: Computer victories  
- **Ties**: Draw games
- **Games Played**: Total number of rounds
- **Percentage Won**: Win rate (ties count as 0.5 wins)

## 🎨 Features

- **Multilingual Support**: Russian interface for native speakers
- **Input Validation**: Accepts first letter of move names in Russian
- **Flexible Input**: Case-insensitive input handling
- **Comprehensive Stats**: Detailed game statistics with formatted table output
- **Recursive Gameplay**: Seamless continuation between rounds
- **Error Handling**: Input validation with re-prompting for invalid entries

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 Recent Updates

- **Latest**: Updated greeting message to display "Камень, ножницы, бумага!" 
- **Initial**: Basic Rock Paper Scissors implementation with Russian interface

## 📄 License

This project is available under standard open source practices. See the repository for any specific license file.

## 🐛 Known Issues

None currently identified. Please report any bugs through GitHub issues.

## 🔮 Future Enhancements

Potential improvements could include:
- GUI implementation
- Multiplayer support
- Different difficulty levels for AI
- Extended statistics and game history
- Internationalization for multiple languages
- Tournament mode with bracket system

---

**Enjoy playing Rock Paper Scissors! 🪨✂️📄**