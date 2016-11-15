package pl.brasswillow;

public class Employee {
    public int workYears;

    private double baseSalary;
    private String position;
    private boolean shouldHaveBonus;
    private double bonus;

    public Employee(int workYears, double baseSalary, String position, boolean shouldHaveBonus, double bonus) {
        this.workYears = workYears;
        this.baseSalary = baseSalary;
        this.position = position;
        this.shouldHaveBonus = shouldHaveBonus;
        this.bonus = bonus;
    }

    public int getWorkYears() {
        return workYears;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getPosition() {
        return position;
    }

    public boolean shouldHaveBonus() {
        return shouldHaveBonus;
    }

    public double getBonus() {
        return bonus;
    }
}
