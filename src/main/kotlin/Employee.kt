package main




class Employee(var firstName: String, var surname: String, var gender: Char, var employeeID: Int, var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double, var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double) {

    fun getFullName() = when (employee.gender) {
        'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
        'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
        else -> "${employee.firstName} ${employee.surname}"
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
         Monthly Payslip:             ${getFullName()}, ID: $employee.employeeID                  
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(employee.annualBonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work: $employee.cycleToWorkMonthlyDeduction         
        ______________________________________________________________________
             NET PAY: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""

}
