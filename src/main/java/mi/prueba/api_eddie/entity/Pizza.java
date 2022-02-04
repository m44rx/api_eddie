package mi.prueba.api_eddie.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pizzas")
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPizza;
    private String nombrePizza;
    private String descripcion;

    @ManyToMany(mappedBy = "pizzas_pizerria", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Pizerria> pizerrias = new HashSet<>();

    @ManyToMany(mappedBy = "pizzas_cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Cliente> clientes = new HashSet<>();
}

