package main.controllers

import main.models.Employee

// Initialize a variable to store the last used employee ID.
var lastId = 0

// Function to generate unique employee IDs.
internal fun getId(): Int {
    // Increment the last used ID and return the result.
    return lastId++
}

class EmployeeAPI {
    // Collection to store employee instances.
    private val employees = ArrayList<Employee>()

    // Method to retrieve all employees in the collection.
    fun findAll(): List<Employee> {
        // Return the entire employee collection.
        return employees
    }

    // Method to retrieve a single employee based on their ID.
    fun findOne(id: Int): Employee? {
        // Use the find function to search for an employee with the specified ID.
        return employees.find { p -> p.employeeID == id }
    }

    // Method to add a new employee to the collection.
    fun create(employee: Employee) {
        // Assign a unique ID to the new employee.
        employee.employeeID = getId()
        // Add the new employee to the collection.
        employees.add(employee)
    }
}
