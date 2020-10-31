package ru.job4j.car_accident.models;

import java.util.Objects;

public class Accident {

    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;

    public Accident() {

    }

    public Accident(int id, String name, String text, String address) {
        this.id = id;
        this.name = name + "_Name";
        this.text = text + "_Text";
        this.address = address + "_Address";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Accident{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", address='" + address + '\''
                + ", type='" + type + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Accident accident = (Accident) o;

        if (id != accident.id) {
            return false;
        }
        if (!Objects.equals(name, accident.name)) {
            return false;
        }
        if (!Objects.equals(text, accident.text)) {
            return false;
        }
        if (!Objects.equals(type, accident.type)) {
            return false;
        }
        return Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        int result = 17 + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}