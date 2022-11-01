package org.udatasystem.data;

public class PartTimeTeacher extends Teacher {

    private double hoursWeek;

// Consrtructor
    public PartTimeTeacher(int teacherId, String fullName, double salary, double hoursWeek) {
        super(teacherId, fullName, salary);
        this.hoursWeek = hoursWeek;
    }
 // Getters and setters
    public double getHoursWeek() {
        return hoursWeek;
    }

    public void setHoursWeek(double hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    @Override
    protected void calculateSalary() {
        super.salary *= this.hoursWeek;        // super.salary *= this.hoursWeek;  CONTRACTION of =super.salary = super.salary * this.hoursWeek;

    }
}
