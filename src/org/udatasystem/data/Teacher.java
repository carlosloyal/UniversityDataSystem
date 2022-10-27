package org.udatasystem.data;

 abstract public  class Teacher {

    protected int teacherId;
    protected String fullName ;
    protected  double salary; // why

    public Teacher(int teacherId, String fullName, double salary) {
        this.teacherId = teacherId;
        this.fullName = fullName;
        this.salary = salary;
    }

    //abstract method: Abstraction of a behaviour, however it is the definition without be implemented
    abstract  protected  void calculateSalary ();
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
