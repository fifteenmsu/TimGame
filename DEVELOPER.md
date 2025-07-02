# Developer Guide

This document provides detailed technical information for developers working on the TimGame project.

## 🏗️ Architecture Overview

The TimGame project follows a simple object-oriented design with clear separation of concerns:

```
┌─────────────────┐
│     Main.java   │  ← Entry Point
└─────────────────┘
         │
         ▼
┌─────────────────┐
│ RockPaperScissors│  ← Game Controller
└─────────────────┘
         │
    ┌────┴────┐
    ▼         ▼
┌───────┐ ┌─────────┐
│ User  │ │Computer │  ← Player Classes
└───────┘ └─────────┘
         │
         ▼
    ┌─────────┐
    │  Move   │  ← Game Logic Enum
    └─────────┘
```

## 📁 Code Structure

### Main.java
**Purpose**: Application entry point
**Responsibilities**:
- Initialize the game
- Display welcome message
- Start game execution

```java
public class Main {
    public static void main(String[] args) {
        // Simple initialization and startup
    }
}
```

### RockPaperScissors.java
**Purpose**: Core game logic and coordination
**Key Components**:

#### Inner Classes

1. **User Class**
   - Handles all player interactions
   - Input validation and processing
   - Play-again prompts

2. **Computer Class**
   - Generates random moves
   - Represents AI opponent

#### Move Enum
- Defines game moves (ROCK, PAPER, SCISSORS)
- Contains game logic for move comparisons
- Returns comparison results (-1, 0, 1)

#### Game State Management
- Tracks scores and game statistics
- Manages game flow and recursion
- Handles game termination

## 🔧 Development Setup

### Prerequisites
- Java JDK 8+
- IntelliJ IDEA (recommended)
- Git

### Local Development

1. **Clone and Setup**
```bash
git clone https://github.com/fifteenmsu/TimGame.git
cd TimGame
```

2. **Compile and Test**
```bash
# Compile
javac -d out src/*.java

# Run
java -cp out Main

# Run tests (if any)
# Currently no unit tests implemented
```

3. **IDE Setup**
- Open `TimGame.iml` in IntelliJ IDEA
- Project should auto-configure
- Set src/ as source root if needed

## 🎯 Key Implementation Details

### Input Handling Strategy
```java
// Russian character input processing
char firstLetter = userInput.charAt(0);
if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
    // Valid input processing
}
```

**Design Decisions**:
- Only first character matters for input
- Case-insensitive input handling
- Recursive input validation on invalid entries

### Game Logic Implementation
```java
public int compareMoves(Move otherMove) {
    if (this == otherMove) return 0;  // Tie
    
    switch (this) {
        case ROCK: return (otherMove == SCISSORS ? 1 : -1);
        case PAPER: return (otherMove == ROCK ? 1 : -1);
        case SCISSORS: return (otherMove == PAPER ? 1 : -1);
    }
    return 0;
}
```

**Design Decisions**:
- Enum-based move representation
- Centralized comparison logic
- Simple integer return values for game state

### Statistics Calculation
```java
double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;
```

**Design Decisions**:
- Ties count as 0.5 wins for percentage calculation
- Comprehensive statistics tracking
- Formatted table output for statistics

## 🧪 Testing Strategy

### Current State
- No automated tests implemented
- Manual testing through game play

### Recommended Testing Approach

1. **Unit Tests**
```java
// Example test structure
@Test
public void testRockBeatsScissors() {
    assertEquals(1, Move.ROCK.compareMoves(Move.SCISSORS));
}

@Test
public void testInvalidInputHandling() {
    // Test input validation
}
```

2. **Integration Tests**
- Test full game flow
- Test statistics calculation
- Test input/output handling

3. **Test Categories**
- Move comparison logic
- Input validation
- Statistics calculation
- Game flow control

## 🔍 Code Quality Guidelines

### Naming Conventions
- Classes: PascalCase (`RockPaperScissors`)
- Methods: camelCase (`startGame()`)
- Variables: camelCase (`userScore`)
- Constants: UPPER_SNAKE_CASE (`ROCK`)

### Code Organization
- Inner classes for related functionality
- Enum for type-safe move representation
- Clear method responsibilities
- Minimal external dependencies

### Russian Language Support
- All user-facing text in Russian
- Input handling for Cyrillic characters
- Consistent language throughout interface

## 🔄 Game Flow Analysis

```
Start Game
    ↓
Get User Move ← (recursive on invalid input)
    ↓
Get Computer Move (random)
    ↓
Compare Moves
    ↓
Update Scores
    ↓
Display Results
    ↓
Play Again? ← (Y/N)
    ↓
[Yes] → Start Game (recursive)
    ↓
[No] → Display Statistics → End
```

## 🚀 Performance Considerations

### Current Implementation
- Minimal memory usage
- Single-threaded execution
- No external dependencies
- Console-based I/O

### Potential Optimizations
- Statistics could be calculated incrementally
- Input validation could be more efficient
- Random number generation could be seeded

## 🐛 Common Issues and Solutions

### Input Handling Issues
**Problem**: Invalid input causes recursive calls
**Solution**: Implement iterative input validation
**Current**: Recursive `getMove()` calls

### Character Encoding
**Problem**: Russian characters may not display correctly
**Solution**: Ensure UTF-8 encoding in IDE and terminal
**Note**: Project assumes proper encoding setup

### Memory Usage
**Problem**: Deep recursion on many games
**Solution**: Convert to iterative game loop
**Impact**: Currently minimal for typical usage

## 📈 Metrics and Monitoring

### Key Metrics to Track
- Game completion rate
- Average games per session
- Win/loss ratios
- Input validation failures

### Performance Monitoring
- Memory usage during long sessions
- Response time for user input
- Statistics calculation time

## 🔧 Build and Deployment

### Manual Build
```bash
javac -d out src/*.java
```

### Creating JAR (if needed)
```bash
jar cfm TimGame.jar manifest.txt -C out .
```

### Deployment Considerations
- Requires Java runtime on target system
- Console application - no GUI dependencies
- Minimal system requirements

## 📚 Additional Resources

### Java Documentation
- [Oracle Java Documentation](https://docs.oracle.com/javase/)
- [Java Enum Best Practices](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

### Development Tools
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Git Documentation](https://git-scm.com/doc)

### Russian Language Resources
- [Cyrillic Character Handling in Java](https://docs.oracle.com/javase/tutorial/i18n/text/charintro.html)

---

*For questions or clarifications, please open an issue in the GitHub repository.*