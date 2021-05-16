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

	@Lob
	private String text;

	@Column(nullable = false)
	private Integer graduationYear;

	@Column
	private String educationLevel;

	@Column
	private String educationForm;

	@Column
	private String faculty;

	@Column
	private String department;

	@Column
	private String profile;

	@Lob
	private String direction;

	@Column
	private String groupp;

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

