package ru.itis.diplomasearcher.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	private String patronymic;

	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "author",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JsonManagedReference(value = "authorReference")
	Set<Diploma> diplomas;

	public void addDiploma(Diploma diploma){
		if (Objects.isNull(diplomas)){
			diplomas = new HashSet<>();
		}
		diplomas.add(diploma);
	}

	public void removeDiploma(Diploma diploma){
		diplomas.remove(diploma);
		diploma.setAuthor(null);
	}

	public Set<Diploma> getDiplomas(){
		return diplomas;
	}
}
