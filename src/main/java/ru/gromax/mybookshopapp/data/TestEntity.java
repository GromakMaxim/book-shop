package ru.gromax.mybookshopapp.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="test_entity")
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
}
