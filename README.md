## `Ndlovu Drone Shop - Spring Boot Application`
# JAVA FRAMEWORKS

## Project Scope 
A fictional company has been created for a customer who is passionate about flying drones for activities such as aerial photography and exploring locations inaccessible to humans. Their enthusiasm led them to start a business that not only sells drones and accessories but also offers blogs to help fellow drone enthusiasts select the right equipment for any task or adventure.

My collaboration on this project was instrumental in making the website fully functional by implementing CRUD (Create, Read, Update, Delete) functionality and ensuring logic was in place to validate entries and operations. Below is a detailed walk-through of my contributions, outlining the changes made and where they can be found within the project.


---

### C. **UPDATE - `mainscreen.html`**
- **Line 14**:  
  **Changed** `<title> My Bicycle Shop <title>`  
  **To** `<title> Ndlovu Drone Shop </title>`

- **Line 19**:  
  **Changed** `<h1>Shop </h1>`  
  **To** `<h1>Ndlovu Drone Shop </h1>`

- **Line 21**:  
  **Changed** `<h2>Parts </h2>`  
  **To** `<h2>Accessories </h2>`

- **Line 54**:  
  **Changed** `<h2>Products </h2>`  
  **To** `<h2>Consoles </h2>`

### D. **NEW FILE - `about.html` Created**
- **Content**:  
  Created an "About Us" page that includes company details, contact information, and a link to the main screen.

### Mainscreen.html
- **Lines 17-22**:  
  Added an "About Us" button linking to the `about.html`.

### AboutController.java
- **Controller Creation**:  
  Created `AboutController` with `@GetMapping` for serving `about.html`.  
  **Added** `@Controller` annotation.

### E. **MODIFIED - `BootStrapData.java`**
- **New Imports**:
    - **Line 16**: `import java.util.HashSet;`
    - **Line 19**: `import java.util.Set;`

- **Conditional Check**:
    - **Line 54**: Added a condition to populate the repository only if it's empty:  
      `if (outsourcedPartRepository.count() == 0 && productRepository.count() == 0)`

- **Outsourced Parts Added**:
    - **Lines 55-96**: Added 5 parts with their prices, inventory, and IDs.

- **Multi-pack Logic**:
    - **Lines 113-127**: Implemented logic to create "Multi-pack" versions for existing parts.

- **Products Added**:
    - **Lines 131-141**: Added 5 products including their prices and inventory.

### F. **NEW FILE - `BuyNowController.java` Created**
- **Annotations**:
    - **Line 13**: Added `@Controller` annotation.
    - **Line 16**: Added `@Autowired` annotation.

- **Private Variable**:
    - **Line 17**: Initialized `ProductRepository`.

- **Methods**:
    - **Lines 19-36**: Created a method to decrement inventory upon purchase using `@PostMapping`.
    - **Lines 37-45**: Created methods with `@GetMapping` to serve success and failure pages.

### Mainscreen.html
- **Lines 93-97**:  
  Added a Thymeleaf form to create a functional "Buy Now" button.

### **NEW FILE - `success.html`**
- Displays a success message for each successful purchase and includes a link to return to the main screen.

### **NEW FILE - `failure.html`**
- Displays a failure message when a purchase is unsuccessful, with a link back to the main screen.

### G. **MODIFIED - `Part.java`**
- **Lines 32-33**: Initialized `minInv`.
- **Lines 35-36**: Initialized `maxInv`.
- **Lines 46-49**: Added a constructor with `minInv` and `maxInv` parameters.
- **Lines 112-122**: Created getters and setters for `minInv` and `maxInv`.

### BootStrapData.java
- **Min/Max Inventory Updates**:
    - **Lines 61-102**: Set `minInv` and `maxInv` for all sample inventory items.

- **Table Updates**:
    - **Lines 174-175**: Added "Minimum Inventory" and "Maximum Inventory" table headers.
    - **Lines 184-185**: Added `minInv` and `maxInv` fields in the table.

### **application.properties**
- **Line 6**: Updated database name to `spring-boot-h2-db106somerandomstring`.

### H. **MODIFIED - Controllers**
- **AddOutsourcedPartController.java**:
    - **Lines 43-57**: Added validation to check if inventory is within the min/max range using `lessThanMin()` and `greaterThanMax()` methods.

- **AddInhousePartController.java**:
    - **Lines 43-57**: Implemented validation to display errors if the inventory is below the minimum or above the maximum.

### I. **MODIFIED - `PartTest.java`**
- **Lines 105-144**:  
  Created unit tests for `getMinInv()`, `setMinInv()`, `getMaxInv()`, and `setMaxInv()`.

### J. **Removed - `DeletePartValidator.java`**
- Deleted the `DeletePartValidator.java` class as it was no longer in use.

--- 


