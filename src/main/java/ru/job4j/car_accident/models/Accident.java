package ru.job4j.car_accident.models;

import java.util.Objects;
import java.util.Set;

public class Accident {

    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private Set<Rule> rules;

    public Accident() {

    }

    public static Accident of(int id, String name,
                              String text, String address,
                              AccidentType type, Set<Rule> rules) {
        Accident accident = new Accident();
        accident.id = id;
        accident.name = name + "_Name";
        accident.text = text + "_Text";
        accident.address = address + "_Address";
        accident.type = type;
        accident.rules = rules;
        return accident;
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

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "Accident{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", address='" + address + '\''
                + ", type='" + type + '\''
                + ", rules='" + rules + '\''
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
        if (!Objects.equals(rules, accident.rules)) {
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
        result = 31 * result + (rules != null ? rules.hashCode() : 0);
        return result;
    }
}