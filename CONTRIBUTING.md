# Contributing to TimGame

Thank you for your interest in contributing to TimGame! This document provides guidelines for contributing to the project.

## 🤝 How to Contribute

### Types of Contributions

We welcome several types of contributions:
- 🐛 **Bug Reports**: Report issues you've encountered
- 💡 **Feature Requests**: Suggest new features or improvements
- 🔧 **Code Contributions**: Submit bug fixes or new features
- 📖 **Documentation**: Improve or expand documentation
- 🧪 **Testing**: Add tests or improve test coverage
- 🌐 **Localization**: Add support for additional languages

## 🚀 Getting Started

### 1. Fork and Clone

```bash
# Fork the repository on GitHub, then clone your fork
git clone https://github.com/YOUR_USERNAME/TimGame.git
cd TimGame

# Add the original repository as upstream
git remote add upstream https://github.com/fifteenmsu/TimGame.git
```

### 2. Set Up Development Environment

```bash
# Ensure you have Java JDK 8+ installed
java -version

# Compile the project
javac -d out src/*.java

# Test that it runs
java -cp out Main
```

### 3. Create a Branch

```bash
git checkout -b feature/your-feature-name
# or
git checkout -b bugfix/issue-description
```

## 📝 Development Guidelines

### Code Style

Follow these coding standards:

#### Java Conventions
```java
// Class names: PascalCase
public class MyGameClass {
    
    // Method names: camelCase
    public void startNewGame() {
        
    }
    
    // Variable names: camelCase
    private int playerScore;
    
    // Constants: UPPER_SNAKE_CASE
    private static final int MAX_GAMES = 100;
}
```

#### Documentation
- Add JavaDoc comments for public methods
- Include inline comments for complex logic
- Keep Russian language comments for user-facing text

```java
/**
 * Compares the current move with another move to determine the winner.
 * 
 * @param otherMove the move to compare against
 * @return 1 if current move wins, -1 if it loses, 0 for tie
 */
public int compareMoves(Move otherMove) {
    // Implementation
}
```

### Testing Guidelines

#### Manual Testing
Before submitting changes, test the following scenarios:
- Valid input handling (К, Н, Б)
- Invalid input handling
- Case insensitivity
- Multiple game rounds
- Statistics accuracy
- Game termination

#### Automated Testing (Future)
When adding tests:
- Use JUnit for unit tests
- Test edge cases and error conditions
- Maintain high test coverage for critical methods

### Russian Language Guidelines

Since this project uses Russian interface:
- Maintain consistency with existing Russian text
- Use appropriate Cyrillic characters
- Test with Russian keyboard layouts
- Consider users familiar with Russian gaming terminology

## 🐛 Bug Reports

### Before Reporting
1. Check existing issues to avoid duplicates
2. Test with the latest version
3. Try to reproduce the issue consistently

### Bug Report Template
```markdown
**Bug Description**
A clear description of what the bug is.

**Steps to Reproduce**
1. Start the game
2. Enter 'К'
3. See error

**Expected Behavior**
What you expected to happen.

**Actual Behavior**
What actually happened.

**Environment**
- OS: [e.g., Windows 10, Ubuntu 20.04]
- Java Version: [e.g., Java 11]
- IDE: [if applicable]

**Additional Context**
Any other context about the problem.
```

## 💡 Feature Requests

### Before Requesting
- Check if the feature already exists
- Review existing feature requests
- Consider if it fits the project scope

### Feature Request Template
```markdown
**Feature Description**
A clear description of the feature you'd like to see.

**Problem it Solves**
Why is this feature needed?

**Proposed Solution**
How do you envision this working?

**Alternatives Considered**
Other ways this could be implemented.

**Additional Context**
Any other context or screenshots.
```

## 🔧 Code Contributions

### Commit Message Format

Use clear, descriptive commit messages:

```bash
# Good examples
git commit -m "Fix input validation for Cyrillic characters"
git commit -m "Add statistics calculation for tie games"
git commit -m "Refactor move comparison logic"

# Bad examples
git commit -m "Fix bug"
git commit -m "Update code"
git commit -m "Changes"
```

### Pull Request Process

1. **Update Documentation**: If your changes affect usage or setup
2. **Test Thoroughly**: Ensure all existing functionality still works
3. **Descriptive PR**: Explain what changes were made and why

#### Pull Request Template
```markdown
## Description
Brief description of changes made.

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Refactoring
- [ ] Other (please describe)

## Testing
- [ ] Tested manually
- [ ] Added/updated tests
- [ ] All existing tests pass

## Screenshots (if applicable)
For UI changes or new features.

## Checklist
- [ ] Code follows project style guidelines
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] No breaking changes (or documented)
```

## 🏗️ Development Workflow

### Typical Workflow

1. **Plan**: Discuss major changes in issues first
2. **Branch**: Create feature/bugfix branch
3. **Develop**: Write code following guidelines
4. **Test**: Verify changes work correctly
5. **Document**: Update relevant documentation
6. **Submit**: Create pull request
7. **Review**: Address feedback from maintainers
8. **Merge**: Changes integrated after approval

### Keeping Your Fork Updated

```bash
# Fetch latest changes from upstream
git fetch upstream

# Switch to main branch
git checkout master

# Merge upstream changes
git merge upstream/master

# Push to your fork
git push origin master
```

## 🌟 Recognition

Contributors will be recognized in:
- GitHub contributors list
- Future CONTRIBUTORS.md file
- Release notes for significant contributions

## 📋 Project Roadmap

### Current Focus Areas
- Code stability and bug fixes
- Documentation improvements
- Test coverage expansion

### Future Considerations
- GUI implementation
- Multiplayer support
- Additional languages
- Enhanced statistics
- Performance optimizations

## ❓ Questions and Support

### Getting Help
- **GitHub Issues**: For bugs and feature requests
- **GitHub Discussions**: For questions and general discussion
- **Code Review**: Request feedback on pull requests

### Response Times
- We aim to respond to issues within 2-3 days
- Pull requests typically reviewed within a week
- Complex changes may take longer

## 📄 License

By contributing to TimGame, you agree that your contributions will be licensed under the same license as the project.

## 🙏 Thank You

Every contribution, no matter how small, is valued and appreciated. Thank you for helping make TimGame better!

---

*For additional questions about contributing, please open a GitHub issue with the "question" label.*