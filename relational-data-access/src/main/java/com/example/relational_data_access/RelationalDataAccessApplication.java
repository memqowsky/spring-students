package com.example.relational_data_access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class RelationalDataAccessApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(RelationalDataAccessApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		jdbcTemplate.execute("DROP TABLE IF EXISTS student");
		jdbcTemplate.execute("CREATE TABLE student(" +
				"id SERIAL, imie VARCHAR(255), nazwisko VARCHAR(255), adres VARCHAR(255))");

		List<Object[]> splitUpNames = Arrays.asList(
				new Object[]{"John", "Woo", "ul. Mickiewicza"},
				new Object[]{"Jeff", "Dean", "ul. Slowackiego"},
				new Object[]{"Jeff", "Doe", "ul. Owocowa"},
				new Object[]{"Mateusz", "Korotajew", "ul. Przykladowa"}
		);

		splitUpNames.forEach(name -> log.info(String.format("Dodawanie studenta: %s %s %s", name[0], name[1], name[2])));
		jdbcTemplate.batchUpdate("INSERT INTO student(imie, nazwisko, adres) VALUES (?,?,?)", splitUpNames);
		String name = "Mateusz";
		log.info("Szukanie studenta o imieniu = '" + name + "':");
		jdbcTemplate.query(
						"SELECT id, imie, nazwisko, adres FROM student WHERE imie = ?",
						(rs, rowNum) -> new Student(
								rs.getLong("id"),
								rs.getString("imie"),
								rs.getString("nazwisko"),
								rs.getString("adres")),
						name)
				.forEach(student -> log.info(student.toString()));


	}
	@GetMapping("/student")
	public List<Student> getStudentsByName(@RequestParam String name) {
		log.info("Pobierane studenta o imieniu = {}", name);
		List<Student> students = jdbcTemplate.query(
				"SELECT id, imie, nazwisko, adres FROM student WHERE imie = ?",
				(rs, rowNum) -> new Student(
						rs.getLong("id"),
						rs.getString("imie"),
						rs.getString("nazwisko"),
						rs.getString("adres")),
				name
		);

		if (students.isEmpty()) {
			log.info("Nie znaleziono studentow z imieniem = {}", name);
		} else {
			students.forEach(student -> log.info("Znaleziono studenta: {}", student));
		}

		return students;
	}
}
