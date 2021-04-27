package ru.itis.diplomasearcher.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

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

	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade=CascadeType.ALL)
	@JoinColumn(name = "author_id", nullable = false)
	@JsonBackReference(value = "authorReference")
	Author author;

	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.ALL)
	@JoinColumn(name = "advisor_id", nullable = false)
	@JsonBackReference(value = "advisorReference")
	Advisor advisor;

}

