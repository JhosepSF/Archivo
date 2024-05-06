package unsm.archivo.entitys;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class usuario
{
    @Id
    Integer id;
    
    @Column
    String name;
    String lastname;
    String address;
    
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = cargo.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "Usuario_Cargo", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name="id_cargo"))
	private Set<cargo> cargoid;
}