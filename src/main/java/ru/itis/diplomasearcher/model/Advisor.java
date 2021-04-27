package ru.itis.diplomasearcher.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "advisor")
@Entity
public class Advisor {

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
	@JsonManagedReference(value = "advisorReference")
	Set<Diploma> diplomas;
}
