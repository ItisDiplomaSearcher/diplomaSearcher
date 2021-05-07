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

	@Column(nullable = false)
	private Integer graduationYear;

	@Enumerated(value = EnumType.STRING)
	private EducationLevel level;

	@Column(nullable = false)
	private String text;

	@Column
	private String author;

	@Column
	private String advisor;

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

