package main
import kotlin.math.round

class Employee (var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double)




var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)



fun main(args: Array<String>) {

    var input:  Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())

            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}
fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
           8. Update Employee details
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt() //Reads a line of input from
// the standard input stream. Return the
// line read or null if the input stream is
// redirected to a file and the end of file has been reached.
}

fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
    else ->  "${employee.firstName} ${employee.surname}"
}


fun getMonthlySalary() = roundTwoDecimals(employee.grossSalary / 12)
fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (employee.prsiPercentage / 100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (employee.payePercentage / 100))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (employee.annualBonus / 12))
fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + employee.cycleToWorkMonthlyDeduction))
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))




fun getPayslip() =
    """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullName()}, ID: $employeeID                  
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work: $cycleToWorkMonthlyDeduction         
        ______________________________________________________________________
             NET PAY: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""

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





