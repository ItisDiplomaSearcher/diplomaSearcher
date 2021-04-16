package ru.itis.diplomasearcher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "diploma")
@Entity
public class Diploma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Integer graduationYear;

	@Enumerated(value = EnumType.STRING)
	private EducationLevel level;

	@Column(nullable = false)
	private String text;

	@ManyToMany
	@JoinTable(
			name = "authors",
			joinColumns = @JoinColumn(name="diploma_id"),
			inverseJoinColumns = @JoinColumn(name="author_id")
	)
	Set<Author> authors;

	@ManyToMany
	@JoinTable(
			name = "advisors",
			joinColumns = @JoinColumn(name="diploma_id"),
			inverseJoinColumns = @JoinColumn(name="advisor_id")
	)
	Set<Author> advisors;
}

