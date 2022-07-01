public class Passenger {
    private boolean survived;
    private int passengerClass;
    private String name;
    private String sex;
    private double age;
    private boolean siblingsSpousesAboard;
    private boolean parentsChildrenAboard;
    private double fare;

    public Passenger(boolean survived, int passengerClass, String name, String sex, double age, boolean siblingsSpousesAboard, boolean parentsChildrenAboard, double fare) {
        this.survived = survived;
        this.passengerClass = passengerClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.siblingsSpousesAboard = siblingsSpousesAboard;
        this.parentsChildrenAboard = parentsChildrenAboard;
        this.fare = fare;
    }

    public boolean Survived() {
        return survived;
    }

    public int getPassengerClass() {
        return passengerClass;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public boolean isSiblingsSpousesAboard() {
        return siblingsSpousesAboard;
    }

    public boolean isParentsChildrenAboard() {
        return parentsChildrenAboard;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "survived=" + survived +
                ", passengerClass=" + passengerClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", siblingsSpousesAboard=" + siblingsSpousesAboard +
                ", parentsChildrenAboard=" + parentsChildrenAboard +
                ", fare=" + fare +
                '}';
    }
}

