package com.challenge.literalura.literalura;

import com.challenge.literalura.literalura.service.AuthorService;
import com.challenge.literalura.literalura.service.BookService;
import com.challenge.literalura.literalura.service.CategoryService;
import com.challenge.literalura.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication  implements CommandLineRunner {
	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private GutendexService gutendexService;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		showMenu();
	}

	private void showMenu() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		while (option != 5) {
			System.out.println("Bienvenido al catálogo LiterAlura");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Buscar y registrar un libro por título");
			System.out.println("2. Listar todos los libros registrados");
			System.out.println("3. Listar todos los autores registrados");
			System.out.println("4. Listar libros por idioma");
			System.out.println("5. Salir");

			try {
				option = Integer.parseInt(scanner.nextLine());

				switch (option) {

					case 1:
						listAllBooks();
						break;
					case 2:
						listAllAuthors();
						break;
					case 3:
						listBooksByLanguage(scanner);
						break;
					case 4:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida. Intente de nuevo.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada no válida. Por favor ingrese un número.");
			}
		}

		scanner.close();
	}

	private void searchBook(Scanner scanner) {
		System.out.println("Ingrese el título del libro:");
		String title = scanner.nextLine();

		try {
			String bookDetails = gutendexService.fetchBookDetails(title);
			System.out.println("Libro registrado exitosamente.");
		} catch (Exception e) {
			System.out.println("Error al registrar el libro: " + e.getMessage());
		}
	}

	private void listAllBooks() {
		bookService.findAllBooks().forEach(book -> System.out.println(book.toString()));
	}

	private void listAllAuthors() {
		authorService.findAllAuthors().forEach(author -> System.out.println(author.toString()));
	}

	private void listBooksByLanguage(Scanner scanner) {
		System.out.println("Ingrese el código de idioma (ES, EN, FR, PT):");
		String languageCode = scanner.nextLine();

		bookService.findBooksByLanguage(languageCode).forEach(book -> System.out.println(book.toString()));
	}

}
