package ru.itis.diplomasearcher.model;

import lombok.Data;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Table(name = "author")
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String patronymic;

	@ManyToMany(mappedBy = "authors")
	Set<Diploma> diplomas;
}
