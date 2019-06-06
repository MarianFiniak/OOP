package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Класс-модель для адресата (Person).
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty number;
    private final StringProperty seat;
    private final ObjectProperty<LocalDate> day;


    //public ArrayList<Station> stations = new ArrayList<>();
    public final StringProperty strings;
    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this(null, null,null);
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName,String string) {
        this.number = new SimpleStringProperty(firstName);
        this.seat = new SimpleStringProperty(lastName);
        this.strings = new SimpleStringProperty(string);
        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.day = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));


    }
    public String getStations(){return strings.get();}
    public void setStations(String s){strings.set(s);}


    public StringProperty stationProperty() {
        return strings;
    }



    public String getFirstName() {
        return number.get();
    }

    public void setFirstName(String firstName) {
        this.number.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return number;
    }

    public String getLastName() {
        return seat.get();
    }

    public void setLastName(String lastName) {
        this.seat.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return seat;
    }

    public LocalDate getBirthday() {
        return day.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.day.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return day;
    }
}
