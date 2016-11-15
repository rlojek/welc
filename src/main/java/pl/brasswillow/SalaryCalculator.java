package pl.brasswillow;

public class SalaryCalculator {

    public double calculateSalaryFor(Employee employee){

        double salary = employee.getBaseSalary();
        if(employee.getWorkYears() > 3){
            salary *= 1.2;
        }
        if (employee.getPosition().equals("Senior")){
            salary *= 1.1;
        } else if(employee.getPosition().equals("Manager")){
            salary *= 1.25;
        }
        if(employee.shouldHaveBonus()){
            salary += employee.getBonus();
        }
        if(employee.getPosition().equals("Internship")){
            salary = employee.getBaseSalary() * 0.75;
        }
        return  salary;
    }

}
