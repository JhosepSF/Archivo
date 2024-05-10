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
    Integer idUser;
    
    @Column
    String name;
    String lastname;
    String address;
    String username;
    String password;
    
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = cargo.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "Usuario_Cargo", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name="id_cargo"))
	private Set<cargo> cargoid;

	public Integer getId() {
		return idUser;
	}

	public void setId(Integer id) {
		this.idUser = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<cargo> getCargoid() {
		return cargoid;
	}

	public void setCargoid(Set<cargo> cargoid) {
		this.cargoid = cargoid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}