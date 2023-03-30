<h1 align="center"> 👉 SRP</h1>

The Single Responsibility Principle states that a class should have only one reason to change. In other words, a class should have only one responsibility or job. This helps to keep the code clean, modular, and easy to maintain.  
  
When a class has multiple responsibilities, it becomes more complex and harder to understand. Changes to one responsibility can inadvertently affect another responsibility, leading to unintended side effects and bugs. By keeping each class focused on a single responsibility, we can reduce complexity, improve maintainability, and make the code easier to test and reuse.    

To follow the Single Responsibility Principle, it's important to identify the responsibilities of a class and make sure that they are cohesive and independent. If a class has multiple responsibilities that are tightly coupled, it may be a sign that it needs to be refactored into multiple smaller classes, each with a single responsibility.
 
<h3>I am providing a few examples here for better understanding : </h3> 

<h3> ⭐ Example 1 ⭐ </h3>

Before Refactoring:

```java
public class Customer {
    private String name;
    private String email;
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void saveToDatabase() {
        // code to save customer to database
    }
    
    public void sendWelcomeEmail() {
        // code to send welcome email to customer
    }
}

```

After refactoring:

```java
public class Customer {
    private String name;
    private String email;
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // getters omitted for brevity
    
}

public class CustomerDatabase {
    public void saveToDatabase(Customer customer) {
        // code to save customer to database
    }
}

public class CustomerEmail {
    public void sendWelcomeEmail(Customer customer) {
        // code to send welcome email to customer
    }
}
```

In the example above, the `Customer` class has two responsibilities: managing customer data and interacting with external systems (database and email). This violates the Single Responsibility Principle, which states that a class should have only one reason to change.

After refactoring, the `Customer` class is simplified to manage only customer data. Two new classes, `CustomerDatabase` and `CustomerEmail`, are created to handle the responsibilities of interacting with the database and sending emails, respectively. The `Customer` class no longer has the responsibility of interacting with external systems, which makes it adhere to the Single Responsibility Principle.

This refactoring not only makes the code easier to understand and maintain, but it also makes it more flexible and extensible. For example, if we want to change the way customer data is stored or how emails are sent, we only need to modify the corresponding class without affecting the Customer class.  

<h3> ⭐ Example 2 ⭐ </h3>

Before Refactoring:  

```java
public class UserService {
    public boolean registerUser(String username, String password) {
        // Validation code
        // User creation code
        // Email notification code
        // Database code
        // Logging code
        return true;
    }
}

```

After Refactoring: 

```java
public class UserService {
    private UserValidator userValidator;
    private UserCreator userCreator;
    private EmailService emailService;
    private UserRepository userRepository;
    private Logger logger;
    
    public UserService(UserValidator userValidator, UserCreator userCreator, 
                       EmailService emailService, UserRepository userRepository, Logger logger) {
        this.userValidator = userValidator;
        this.userCreator = userCreator;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.logger = logger;
    }
    
    public boolean registerUser(String username, String password) {
        if (!userValidator.validate(username, password)) {
            logger.error("Invalid user data");
            return false;
        }
        
        User user = userCreator.createUser(username, password);
        
        try {
            emailService.sendEmail(user.getEmail(), "Welcome to our website!");
            userRepository.save(user);
            logger.info("User registered successfully: " + user.getUsername());
            return true;
        } catch (Exception e) {
            logger.error("Error while registering user", e);
            return false;
        }
    }
}

```

In the original code, the `UserService` class was responsible for several different tasks such as validating user data, creating a user, sending email notifications, saving data to a database, and logging. This violates the SRP as the class has multiple responsibilities, and any changes to one of these tasks may affect the others.

In the refactored code, we have separated the responsibilities into different classes such as `UserValidator`, `UserCreator`, `EmailService`, `UserRepository`, and `Logger`. The `UserService` class now only has the responsibility of coordinating these different components to achieve its goal of registering a user. This makes the code more modular, testable, and easier to maintain, and ensures that each class has only one reason to change.  


<h3> ⭐ Example 3 ⭐ </h3>

Before Refactoring:  

```java
public class Order {
    private int orderId;
    private String customerName;
    private List<Item> items;
    private double totalPrice;
    
    public Order(int orderId, String customerName, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = calculateTotalPrice();
    }
    
    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Items: ");
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }
    
    private double calculateTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

```

In this example, the `Order` class has two responsibilities: to represent an order and to print its details. This violates the SRP, as a class should have only one reason to change. If we were to add a new way to print order details (e.g., a PDF generator), we would have to modify the `Order` class.  

After Refactoring: 

```java
public class Order {
    private int orderId;
    private String customerName;
    private List<Item> items;
    
    public Order(int orderId, String customerName, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
    }
    
    public double calculateTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    // getters and setters
    
}

public class OrderPrinter {
    public void printOrderDetails(Order order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Items: ");
        for (Item item : order.getItems()) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total Price: " + order.calculateTotalPrice());
    }
}

```
In the refactored code, we have separated the concerns of representing an order and printing its details into two different classes: `Order` and `OrderPrinter`. The `Order` class now has only one responsibility: to represent an order. We have moved the `calculateTotalPrice()` method to the `Order` class, as it is related to order calculations. The `OrderPrinter` class is responsible for printing order details, and it takes an Order object as a parameter to print. This way, if we were to add a new way to print order details, we would only have to modify the `OrderPrinter` class.  


<h3> ⭐ Example 4 ⭐ </h3>

Before Refactoring:  

```java
public class Employee {
    private String name;
    private String address;
    private int age;
 
    public void saveEmployee(Employee employee) {
        // code to save employee object to database
    }
 
    public void calculatePay(Employee employee) {
        // code to calculate employee's pay
    }
 
    public void printEmployee(Employee employee) {
        // code to print employee details
    }
}

```

After Refactoring: 

```java
public class Employee {
    private String name;
    private String address;
    private int age;
 
    // getters and setters for name, address, and age
 
}
 
public class EmployeeRepository {
    public void saveEmployee(Employee employee) {
        // code to save employee object to database
    }
}
 
public class EmployeePayCalculator {
    public void calculatePay(Employee employee) {
        // code to calculate employee's pay
    }
}
 
public class EmployeePrinter {
    public void printEmployee(Employee employee) {
        // code to print employee details
    }
}

```
In the example above, the `Employee` class has three responsibilities: saving an employee to a database, calculating an employee's pay, and printing an employee's details. This violates the Single Responsibility Principle, as the class has more than one reason to change.

After refactoring, each responsibility is separated into its own class. The `Employee` class now only has the responsibility of representing an employee's data, while the `EmployeeRepository`, `EmployeePayCalculator`, and `EmployeePrinter` classes have their own specific responsibilities. This makes the code more modular and easier to maintain, as changes to one responsibility won't affect the others. 






