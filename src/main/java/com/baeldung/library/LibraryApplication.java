package com.baeldung.library;

import com.baeldung.library.domain.Book;
import com.baeldung.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApplication {
	@Autowired
	private BookRepository bookRepository;

	@Component
	class DataSetup implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments args) throws Exception {
			bookRepository.save(Book.builder()
					.title("Owls of the Eastern Ice")
					.isbn("12345")
					.build());
			bookRepository.save(Book.builder().title("Small Things Like These").isbn("12346").build());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
