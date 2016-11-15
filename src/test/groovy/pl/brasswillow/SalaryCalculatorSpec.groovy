package pl.brasswillow

import spock.lang.Specification
import spock.lang.Unroll

class SalaryCalculatorSpec extends Specification {

    def cut = new SalaryCalculator();

    @Unroll
    def "should return #expectedSalary salary for #position with base salary #baseSalary working for #workYears years with#bonusString"() {
        given:
        Employee employee = new Employee(workYears, baseSalary, position, shouldHaveBonus, bonus);

        when:
        double calculatedSalary = cut.calculateSalaryFor(employee);

        then:
        calculatedSalary.round(2) == expectedSalary

        where:
        workYears | baseSalary | position     | shouldHaveBonus | bonus || expectedSalary
        1         | 100        | 'Junior'     | false           | 100   || 100
        1         | 100        | 'Internship' | false           | 5455  || 75
        4         | 100        | 'Architect'  | false           | 0     || 120
        2         | 100        | 'Senior'     | false           | 0     || 110
        2         | 100        | 'Manager'    | false           | 0     || 125
        2         | 100        | 'Worker'     | true            | 10    || 110

        bonusString = shouldHaveBonus ? bonus + ' bonus' : 'out bonus'
    }

}
