package ru.itis.diplomasearcher.model;

import lombok.Data;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
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

	@ManyToMany(mappedBy = "advisors")
	Set<Diploma> diplomas;
}
