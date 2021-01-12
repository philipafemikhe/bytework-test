package com.servbyte.app.entities;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="meals")
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String mealName;
    private String picture;
    private Double price;
    private int minutesToPrepare;
    private String description;

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(insertable = false, updatable = false, name = "provider_id")
    private FoodProvider provider;
//    private Long provider_id;
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
