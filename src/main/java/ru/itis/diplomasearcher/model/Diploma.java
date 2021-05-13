package ru.itis.diplomasearcher.model;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "diploma")
@Entity
@Document(indexName = "diplomas")
public class Diploma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column
	private Integer pagesCount;

	@Lob
	private String contentsList;

	@Lob
	private String mainPart;

	@Lob
	private String literature;


	@Column(nullable = false)
	private Integer graduationYear;

	@Enumerated(value = EnumType.STRING)
	private EducationLevel educationLevel;

	@Enumerated(value = EnumType.STRING)
	private EducationForm educationForm;

	@Column
	private String faculty;

	@Lob
	private String direction;

	@Column
	private String group;

	@Column
	private String author;

	@Column
	private String advisor;

	@Column
	private String downloadLink;

	@Override
	public String toString() {
		return "Diploma{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", advisor='" + advisor + '\'' +
				'}';
	}
}

