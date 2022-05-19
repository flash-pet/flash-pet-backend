package com.senac.infrastructure.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PetShop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PetShop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
}
