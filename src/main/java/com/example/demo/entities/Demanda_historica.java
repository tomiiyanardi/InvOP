package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "demanda_historica")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Demanda_historica extends Base{
    @Column(name = "cantidad_total")
    private int cantidad_total;

    @Data
    @Column(name = "fecha_desde")
    private LocalData fecha_desde;

    @Data
    @Column(name = "fecha_hasta")
    private LocalData fecha_hasta;
}
