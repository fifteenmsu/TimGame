# API Documentation

This document provides detailed API documentation for the TimGame project classes and methods.

## 📋 Overview

TimGame follows a simple object-oriented architecture with the following main components:
- `Main` class - Application entry point
- `RockPaperScissors` class - Game controller and logic
- Inner classes for game components (User, Computer, Move enum)

## 🏗️ Class Hierarchy

```
Main
└── RockPaperScissors
    ├── User (inner class)
    ├── Computer (inner class)
    └── Move (enum)
```

---

## 📄 Main Class

### Class Definition
```java
public class Main
```

**Purpose**: Application entry point and initialization

### Methods

#### main(String[] args)
```java
public static void main(String[] args)
```
**Description**: Application entry point  
**Parameters**: 
- `args` - Command line arguments (unused)
**Returns**: void  
**Behavior**: 
- Displays welcome message in Russian
- Creates RockPaperScissors instance
- Starts the game

**Example Usage**:
```bash
java Main
```

---

## 🎮 RockPaperScissors Class

### Class Definition
```java
public class RockPaperScissors
```

**Purpose**: Main game controller handling gameplay, scoring, and user interaction

### Fields

#### Private Instance Variables
```java
private User user;           // Player interface handler
private Computer computer;   // AI opponent
private int userScore;       // Player win count
private int computerScore;   // Computer win count  
private int numberOfGames;   // Total games played
```

### Constructor

#### RockPaperScissors()
```java
public RockPaperScissors()
```
**Description**: Initializes game state and player objects  
**Parameters**: None  
**Behavior**:
- Initializes User and Computer instances
- Sets all scores to 0

### Public Methods

#### startGame()
```java
public void startGame()
```
**Description**: Main game loop handling single round and recursion  
**Parameters**: None  
**Returns**: void  
**Behavior**:
1. Gets player move via User.getMove()
2. Gets computer move via Computer.getMove()
3. Compares moves using Move.compareMoves()
4. Updates scores based on result
5. Displays round results
6. Prompts for continuation via User.playAgain()
7. Recursively calls itself if player continues
8. Displays final statistics if player exits

**Game Flow**:
```
startGame() → getMove() → compare → update scores → display → playAgain()
     ↑                                                            │
     └──────────────── recursive call ←──────────────────────────┘
```

### Private Methods

#### printGameStats()
```java
private void printGameStats()
```
**Description**: Displays formatted game statistics table  
**Parameters**: None  
**Returns**: void  
**Output Format**:
```
+--------------------------------------------------------------------+
|   WINS  |  LOSSES  |   TIES  |  GAMES PLAYED  |  PERCENTAGE WON  |
|---------|----------|---------|----------------|------------------|
|      5  |      3   |      2  |           10   |        60.00%    |
+--------------------------------------------------------------------+
```

**Statistics Calculation**:
- Percentage = (wins + ties/2) / totalGames * 100

#### printDashes(int numberOfDashes)
```java
private void printDashes(int numberOfDashes)
```
**Description**: Utility method for formatting table borders  
**Parameters**:
- `numberOfDashes` - Number of dash characters to print
**Returns**: void

---

## 👤 User Class (Inner)

### Class Definition
```java
private class User
```

**Purpose**: Handles all player input and interaction

### Fields
```java
private Scanner inputScanner;  // Input stream handler
```

### Constructor

#### User()
```java
public User()
```
**Description**: Initializes input scanner  
**Parameters**: None

### Methods

#### getMove()
```java
public Move getMove()
```
**Description**: Gets and validates player move input  
**Parameters**: None  
**Returns**: `Move` enum value (ROCK, PAPER, or SCISSORS)  
**Input Handling**:
- Prompts: "Камень, ножницы или бумага? "
- Accepts: К/к (Rock), Н/н (Scissors), Б/б (Paper)
- Case insensitive
- Recursive validation on invalid input

**Input Mapping**:
| Input | Russian Word | English | Move Enum |
|-------|-------------|---------|-----------|
| К/к   | Камень      | Rock    | ROCK      |
| Н/н   | Ножницы     | Scissors| SCISSORS  |
| Б/б   | Бумага      | Paper   | PAPER     |

#### playAgain()
```java
public boolean playAgain()
```
**Description**: Prompts player to continue or end game  
**Parameters**: None  
**Returns**: boolean - true if player wants to continue  
**Behavior**:
- Prompts: "Хотите сыграть еще раз? "
- Returns true if input starts with 'Y' (case insensitive)
- Returns false for any other input

---

## 🤖 Computer Class (Inner)

### Class Definition
```java
private class Computer
```

**Purpose**: AI opponent that generates random moves

### Methods

#### getMove()
```java
public Move getMove()
```
**Description**: Generates random computer move  
**Parameters**: None  
**Returns**: `Move` enum value (randomly selected)  
**Implementation**:
- Uses `Random.nextInt()` to select from Move.values()
- Equal probability for all moves (33.33% each)

---

## 🎯 Move Enum

### Enum Definition
```java
private enum Move {
    ROCK, PAPER, SCISSORS;
}
```

**Purpose**: Type-safe representation of game moves with comparison logic

### Enum Values
- `ROCK` - Камень (beats SCISSORS)
- `PAPER` - Ножницы (beats ROCK)  
- `SCISSORS` - Бумага (beats PAPER)

### Methods

#### compareMoves(Move otherMove)
```java
public int compareMoves(Move otherMove)
```
**Description**: Compares current move with opponent move  
**Parameters**:
- `otherMove` - The move to compare against
**Returns**: int
- `1` if current move wins
- `-1` if current move loses
- `0` if moves are equal (tie)

**Game Logic**:
```java
ROCK vs SCISSORS → 1    (Rock wins)
ROCK vs PAPER    → -1   (Paper wins)
PAPER vs ROCK    → 1    (Paper wins)
PAPER vs SCISSORS → -1  (Scissors wins)
SCISSORS vs PAPER → 1   (Scissors wins)
SCISSORS vs ROCK  → -1  (Rock wins)
Same vs Same      → 0   (Tie)
```

---

## 🔄 Game State Flow

### Initialization
```
Main.main() → new RockPaperScissors() → Constructor initializes:
                                        ├── new User()
                                        ├── new Computer()
                                        ├── userScore = 0
                                        ├── computerScore = 0
                                        └── numberOfGames = 0
```

### Game Loop
```
startGame() → User.getMove() → Computer.getMove() → Move.compareMoves()
     ↑                                                        ↓
     └── User.playAgain() ←── printGameStats() ←── update scores
```

### State Transitions
1. **Game Start**: All scores zero, new User/Computer instances
2. **Round Play**: Get moves, compare, update scores, increment game count
3. **Round End**: Display results, check continuation
4. **Game End**: Display statistics, terminate

## 🧪 Testing Interface

### Manual Testing Methods
```java
// Test move comparison
Move.ROCK.compareMoves(Move.SCISSORS);  // Should return 1

// Test input validation
// Enter invalid input → should re-prompt
// Enter 'К' → should return ROCK

// Test statistics
// Play multiple rounds → verify score calculations
```

### Error Handling
- **Invalid Input**: Recursive prompting until valid input
- **Empty Input**: Handled by charAt(0) - may throw exception
- **Non-character Input**: May cause runtime errors

## 📊 Performance Characteristics

### Time Complexity
- Move comparison: O(1)
- Input validation: O(1) per valid input, O(n) for n invalid attempts
- Statistics calculation: O(1)
- Game loop: O(g) where g is number of games played

### Memory Usage
- Minimal heap allocation
- Scanner instance persists throughout game
- No dynamic data structures
- Stack usage increases with recursive game calls

### Scalability Limitations
- Deep recursion potential with many consecutive games
- Single-threaded execution
- Console I/O bound performance

---

## 🔧 Extension Points

### Adding New Moves
```java
// Extend Move enum
private enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
    
    // Update compareMoves() logic
    // Update User input handling
}
```

### Internationalization
```java
// Extract strings to properties files
// Add language selection mechanism
// Update input character mappings
```

### Enhanced AI
```java
// Replace Computer.getMove() with strategy pattern
// Add difficulty levels
// Implement move prediction algorithms
```

---

*This API documentation reflects the current implementation. For usage examples and setup instructions, see [README.md](README.md).*