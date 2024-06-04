package unsm.archivo.entitys;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer id;
    
    @Column
    String name;
    String lastname;
    String address;
    String phone;
    String username;
    String password;
    
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Cargo.class, cascade = CascadeType.MERGE)
	@JoinTable(name = "Usuario_Cargo", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name="id_cargo"))
	private Set<Cargo> Cargos;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Cargos.stream().map(cargo -> new SimpleGrantedAuthority(cargo.getName())).collect(Collectors.toList());
	}
	
	public Set<Cargo> getCargos() {
		return Cargos;
	}

	public void setCargos(Set<Cargo> Cargos) {
		this.Cargos = Cargos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return	true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}