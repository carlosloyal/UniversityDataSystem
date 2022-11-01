package org.udatasystem.data;
// In this part the class is inheriting atributes and methods of Teacher class.
public class FullTimeTeacher extends Teacher {
    private int experienceYears;
    // Constructor
    public FullTimeTeacher(int teacherId, String fullName, double salary, int experienceYears) {
        super(teacherId, fullName, salary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }


    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    // POLIMORFISMO : a method that contains different calculations
    // override es la sobre escritura de metodos

    // Method
    @Override
    protected void calculateSalary() {
        super.salary *= 1.1 * this.experienceYears;
    }
}
