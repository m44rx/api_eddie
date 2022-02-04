package mi.prueba.api_eddie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "pizzerias")
public class Pizerria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPizerria;
    private String direccion;
    private String sede;

    @ManyToMany
    @JoinTable(
        name = "pizzeria_pizzas",
        joinColumns = @JoinColumn(name="id_pizzeria"),
        inverseJoinColumns = @JoinColumn(name="id_pizza")
    )
    private Set<Pizza> pizzas_pizerria = new HashSet<>();
}
