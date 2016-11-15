package pl.brasswillow;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SalaryCalculatorTest {

    @Test
    public void calculateSalaryForJunior(){
        SalaryCalculator cut = new SalaryCalculator();
        Employee juniorEmployee = new Employee(1, 100, "Junior", false, 5455);
        double calculatedSalary = cut.calculateSalaryFor(juniorEmployee);
        assertThat(calculatedSalary).isEqualTo(100);
    }

    @Test
    public void calculateSalaryForInternship() throws Exception{
        //given
        SalaryCalculator cut = new SalaryCalculator();
        Employee juniorEmployee = new Employee(1, 100, "Internship", false, 5455);
        //when
        double calculatedSalary = cut.calculateSalaryFor(juniorEmployee);
        //then
        assertThat(calculatedSalary).isEqualTo(75);
    }



}