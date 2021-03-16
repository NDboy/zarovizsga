package hu.nive.ujratervezes.zarovizsga.workhours;

public class EmployeeReg {

    private String name;
    private int hours;
    private String day;

    public EmployeeReg(String name, int hours, String day) {
        this.name = name;
        this.hours = hours;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", hours=" + hours +
                ", day='" + day;
    }

}
