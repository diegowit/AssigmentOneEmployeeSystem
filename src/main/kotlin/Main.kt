package main

import main.controllers.EmployeeAPI
import main.models.Employee
import kotlin.math.round
// Initialize the employee API instance
var employees = EmployeeAPI()


// Function to display the menu options and return the user input.
fun menu() : Int {
    // Displaying the menu options
print("""
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees
         |   4. Print Payslip for Employee
         |   5. Update Employee details
         |  -1. Exit
         |
         |Enter Option : """.trimMargin())
return readLine()!!.toInt()
    // Returning the user input as an integer.
}

// Start the application by calling the start() function.
fun start() {
    // Variable to store the user input from the menu.
    var input: Int
    // Do-while loop to repeat the menu until the user selects "Exit".
    do {
        // Call the menu() function to display the options and get the user input.
        input = menu()
        // Switch case to handle the user input.
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> update()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

// Function to list all the employees.
fun list(){
    // Call the findAll() function from the EmployeeAPI class to get all the employees.
    employees.findAll()
        // Loop through each employee and print it.
        .forEach{ println(it) }
}


// Function to search for an employee by their ID.
fun search() {
    // Call the getEmployeeById() function to get the employee instance.
    val employee = getEmployeeById()
    // If the employee is not found, display a message.
    if (employee == null)
        println("No employee found")
    // If the employee is found, print the employee instance.
    else
        println(employee)
}


// Function to print the payslip of an employee.
fun paySlip(){
    // Call the getEmployeeById() function to get the employee instance.
    val employee = getEmployeeById()
    // If the employee is found, print the payslip.
    if (employee != null)
        println(employee.getPayslip())
}

// Function to update an employee's details.
fun update(){
    // Call the getEmployeeById() function to get the employee instance.
    val employee = getEmployeeById()
    // If the employee is found, update the details.
    if (employee != null) {
        // Get the new first name from the user and update the employee instance.
        println("Enter the new first name: ")
        employee.firstName = readLine()!!

        // Prompt the user for the new surname and update the employee instance.
        println("Enter the new surname: ")
        employee.surname = readLine()!!

        // Prompt the user for the new gender and update the employee instance.
        println("Enter the new gender (m/f): ")
        employee.gender = readLine()!![0]

        // Prompt the user for the new gross salary and update the employee instance.
        println("Enter the new gross salary: ")
        employee.grossSalary = readLine()!!.toDouble()

        // Prompt the user for the new PAYE percentage and update the employee instance.
        println("Enter the new PAYE percentage: ")
        employee.payePercentage = readLine()!!.toDouble()

        // Prompt the user for the new PRSI percentage and update the employee instance.
        println("Enter the new PRSI percentage: ")
        employee.prsiPercentage = readLine()!!.toDouble()

        // Prompt the user for the new annual bonus and update the employee instance.
        println("Enter the new annual bonus: ")
        employee.annualBonus = readLine()!!.toDouble()

        // Prompt the user for the new cycle to work monthly deduction and update the employee instance.
        println("Enter the new cycle to work monthly deduction: ")
        employee.cycleToWorkMonthlyDeduction = readLine()!!.toDouble()
    }
}
fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}


internal fun getEmployeeById(): Employee? /* The return type of the method is """Employee?""",
 which means that it returns an instance of the Employee class or null.
  The ? symbol in the type declaration indicates that the value can be either
  an instance of the Employee class or null.*/

{
    // Prompt the user for the employee id to search by.
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()

    // Search for the employee with the specified id and return the result.
    return employees.findOne(employeeID)
}


fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}
//val logger = KotlinLogging.logger {}

fun main(args: Array<String>){
    start()
   // logger.info { "Launching Employee App" }

}


//https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
//There are several options...try each of them out
fun roundTwoDecimals(number: Double) = round(number * 100) / 100
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()










