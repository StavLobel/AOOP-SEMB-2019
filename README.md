# 🎓 Advanced Object-Oriented Programming (AOOP) - SEMB 2019

**Comprehensive Java-based object-oriented programming project demonstrating advanced software engineering principles and design patterns**

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-4.x-green.svg)](https://junit.org/)
[![Design Patterns](https://img.shields.io/badge/Design%20Patterns-Implemented-blue.svg)](https://refactoring.guru/design-patterns)
[![SOLID](https://img.shields.io/badge/SOLID-Principles-green.svg)](https://en.wikipedia.org/wiki/SOLID)
[![Clean Code](https://img.shields.io/badge/Clean%20Code-Practices-yellow.svg)](https://clean-code-developer.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 🎯 Project Overview

A comprehensive **object-oriented programming project** developed as part of the Advanced Object-Oriented Programming course (SEMB 2019). This project demonstrates mastery of Java programming, advanced OOP concepts, design patterns, and software engineering best practices. The implementation showcases clean code principles, SOLID design patterns, and professional software development methodologies.

### ✨ Key Features

- **Advanced OOP Concepts** - Inheritance, polymorphism, encapsulation, abstraction
- **Design Patterns Implementation** - Factory, Singleton, Observer, Strategy patterns
- **SOLID Principles** - Single responsibility, open/closed, Liskov substitution, interface segregation, dependency inversion
- **Clean Code Practices** - Readable, maintainable, and well-documented code
- **Comprehensive Testing** - Unit tests with JUnit framework
- **Professional Documentation** - Detailed code comments and architecture documentation

---

## 🛠️ Technology Stack

### Core Technologies
- **Java 8+** - Primary programming language
- **Maven** - Build automation and dependency management
- **JUnit 4** - Unit testing framework
- **Git** - Version control system

### Development Tools
- **IDE Support** - IntelliJ IDEA, Eclipse, VS Code
- **Build Tools** - Maven for project management
- **Testing Framework** - JUnit for unit testing
- **Documentation** - JavaDoc for code documentation

---

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Maven 3.x
- Git
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/StavLobel/AOOP-SEMB-2019.git
   cd AOOP-SEMB-2019
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **Generate documentation**
   ```bash
   mvn javadoc:javadoc
   ```

---

## 🏗️ Architecture & Design

### Object-Oriented Design Principles

#### Inheritance & Polymorphism
```java
// Base class demonstrating inheritance
public abstract class Shape {
    protected double area;
    
    public abstract double calculateArea();
    public abstract void display();
}

// Derived classes showing polymorphism
public class Circle extends Shape {
    private double radius;
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

#### Encapsulation & Abstraction
```java
// Encapsulation example
public class BankAccount {
    private double balance;
    private String accountNumber;
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
```

### Design Patterns Implementation

#### Factory Pattern
```java
public interface ShapeFactory {
    Shape createShape(String type);
}

public class ConcreteShapeFactory implements ShapeFactory {
    @Override
    public Shape createShape(String type) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            default: throw new IllegalArgumentException("Unknown shape type");
        }
    }
}
```

#### Singleton Pattern
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;
    
    private DatabaseConnection() {
        // Private constructor
    }
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

---

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── aoop/
│               ├── models/           # Data models and entities
│               ├── services/         # Business logic services
│               ├── factories/        # Factory pattern implementations
│               ├── patterns/         # Design pattern examples
│               ├── utils/            # Utility classes
│               └── exceptions/       # Custom exception classes
├── test/
│   └── java/
│       └── com/
│           └── aoop/
│               ├── unit/             # Unit tests
│               ├── integration/      # Integration tests
│               └── mocks/            # Mock objects
├── resources/                        # Configuration files
├── docs/                            # Documentation
└── pom.xml                          # Maven configuration
```

---

## 🧪 Testing Strategy

### Unit Testing
```java
@Test
public void testCircleAreaCalculation() {
    Circle circle = new Circle(5.0);
    double expectedArea = Math.PI * 25.0;
    assertEquals(expectedArea, circle.calculateArea(), 0.001);
}

@Test
public void testFactoryPattern() {
    ShapeFactory factory = new ConcreteShapeFactory();
    Shape circle = factory.createShape("circle");
    assertTrue(circle instanceof Circle);
}
```

### Test Coverage
- **Unit Tests** - Individual component testing
- **Integration Tests** - Component interaction testing
- **Mock Testing** - Isolated testing with mock objects
- **Edge Case Testing** - Boundary condition validation

---

## 📊 Code Quality Metrics

### SOLID Principles Implementation

#### Single Responsibility Principle (SRP)
- Each class has a single, well-defined responsibility
- Methods are focused and cohesive
- Clear separation of concerns

#### Open/Closed Principle (OCP)
- Classes are open for extension, closed for modification
- Use of interfaces and abstract classes
- Polymorphic behavior implementation

#### Liskov Substitution Principle (LSP)
- Derived classes can substitute base classes
- Proper inheritance hierarchies
- Consistent behavior across inheritance chain

#### Interface Segregation Principle (ISP)
- Focused, specific interfaces
- No forced dependencies on unused methods
- Clean interface design

#### Dependency Inversion Principle (DIP)
- High-level modules don't depend on low-level modules
- Both depend on abstractions
- Dependency injection implementation

---

## 🎓 Educational Value

### Learning Objectives
- **Advanced OOP Concepts** - Mastery of inheritance, polymorphism, encapsulation
- **Design Patterns** - Practical implementation of common patterns
- **Clean Code Principles** - Writing maintainable and readable code
- **Testing Strategies** - Comprehensive unit testing approaches
- **Software Architecture** - Understanding of system design principles

### Skills Demonstrated
- **Java Programming** - Advanced language features and best practices
- **Object-Oriented Design** - Proper class design and relationships
- **Design Patterns** - Implementation of common software patterns
- **Testing** - Unit testing and test-driven development
- **Documentation** - Professional code documentation practices

---

## 🔧 Development Workflow

### Code Quality Standards
```bash
# Compile and test
mvn clean compile test

# Generate documentation
mvn javadoc:javadoc

# Run code analysis
mvn spotbugs:check

# Format code
mvn formatter:format
```

### Best Practices
- **Meaningful Names** - Descriptive variable and method names
- **Small Functions** - Single responsibility functions
- **Comments** - Clear and helpful documentation
- **Error Handling** - Proper exception management
- **Consistent Formatting** - Standard code style

---

## 🤝 Contributing

We welcome contributions! Please follow these guidelines:

1. **Fork the repository** and create a feature branch
2. **Follow Java coding standards** and conventions
3. **Write comprehensive tests** for new functionality
4. **Update documentation** as needed
5. **Submit a pull request** with clear description

### Development Setup
```bash
# Install dependencies
mvn dependency:resolve

# Run all tests
mvn test

# Generate reports
mvn site
```

---

## 📚 Resources & References

- [Java Documentation](https://docs.oracle.com/javase/)
- [Maven Guide](https://maven.apache.org/guides/)
- [JUnit Documentation](https://junit.org/junit4/)
- [Design Patterns](https://refactoring.guru/design-patterns)
- [Clean Code Principles](https://clean-code-developer.com/)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

> **Mastering object-oriented programming through practical implementation** 🎓

*Demonstrating advanced Java programming skills and software engineering best practices*