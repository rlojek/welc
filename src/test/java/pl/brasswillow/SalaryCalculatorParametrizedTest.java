package pl.brasswillow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

//zohhak

@RunWith(Parameterized.class)
public class SalaryCalculatorParametrizedTest {

    @Parameters(name = "{index}: emp: {0} -> salary: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new Employee(1, 100, "Junior", false, 5455), 100},
            {new Employee(1, 100, "Internship", false, 5455), 75}
        });
    }

    @Parameter
    public Employee employee;

    @Parameter(value = 1)
    public double salary;

    @Test
    public void testCalculatedSallary() throws Exception{
        //given
        SalaryCalculator cut = new SalaryCalculator();
        //when
        double calculatedSalary = cut.calculateSalaryFor(employee);
        //then
        assertThat(calculatedSalary).isEqualTo(salary, offset(0.001));
    }

}