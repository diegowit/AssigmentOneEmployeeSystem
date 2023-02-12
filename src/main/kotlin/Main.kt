package main

import main.controllers.EmployeeAPI
import main.models.Employee
import kotlin.math.round

var employees = EmployeeAPI()

fun menu() : Int {
print("""
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees
         |   4. Print Payslip for Employee
         |  -1. Exit
         |
         |Enter Option : """.trimMargin())
return readLine()!!.toInt()
}


fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun list(){
    employees.findAll()
        .forEach{ println(it) }
}



fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}


fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}


fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}


internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
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





/*This code calculates the monthly salary and deductions for an employee, and generates a payslip with the calculated values.

The employee's information is stored as variables such as firstName, surname, gender, employeeID, etc. These values are then used to calculate various aspects of the employee's monthly pay such as the monthly salary, PRSI, PAYE, gross pay, total deductions, and net pay.

The main function presents a menu to the user, which allows the user to choose what information they want to see. The menu options include the monthly salary, PRSI, PAYE, gross pay, total deductions, net pay, or a full payslip. The menu function prompts the user to enter their selection, and the when statement in the main function implements the selected option.

The calculation of the various aspects of the employee's pay is done using functions such as getMonthlySalary, getMonthlyPRSI, getMonthlyPAYE, getGrossMonthlyPay, getTotalMonthlyDeductions, and getNetMonthlyPay. These functions make use of the values stored in the variables and other functions to perform the calculations.

Finally, the getPayslip function generates a formatted string that represents the payslip, which includes the employee's information and the calculated values for their monthly pay.

The roundTwoDecimals function is used to round the calculated values to two decimal places.*/





