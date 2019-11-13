package de.mysiteweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PC-2 on 29.09.2019.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double currentprice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoname;
    @ManyToOne
    private Category category;

}
