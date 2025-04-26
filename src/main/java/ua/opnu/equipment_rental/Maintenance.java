package ua.opnu.equipment_rental;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Equipment equipment;

    private LocalDate date;
    private String description;

    // Геттери
    public Long getId() {
        return id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Сеттери
    public void setId(Long id) {
        this.id = id;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
