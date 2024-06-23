package com.api.library;

import com.api.library.entity.author.Author;
import com.api.library.entity.book.Book;
import com.api.library.repository.author.AuthorRepository;
import com.api.library.repository.book.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    @DisplayName("Test Get all Book List")
    void testReturnListOfBooks() throws Exception {
        Author author = new Author("Martin", "Wickramasinghe");
        authorRepository.save(author);
        Book book = new Book("Madol Doowa", "1234567890", author);
        bookRepository.save(book);

        mockMvc.perform(get("/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Madol Doowa"))
                .andExpect(jsonPath("$[0].isbn").value("1234567890"))
                .andExpect(jsonPath("$[0].authorName").value("Martin Wickramasinghe"));
    }

    @Test
    @DisplayName("Test Get Book by book id")
    void testReturnBookById() throws Exception {
        Author author = new Author("Kumaratunaga", "Munidasa");
        authorRepository.save(author);
        Book book = new Book("Heensaraya", "0987654321", author);
        bookRepository.save(book);

        mockMvc.perform(get("/book/" + book.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Heensaraya"))
                .andExpect(jsonPath("$.isbn").value("0987654321"))
                .andExpect(jsonPath("$.authorName").value("Kumaratunaga Munidasa"));
    }

    @Test
    @DisplayName("Test Get all authors")
    void testReturnListOfAuthors() throws Exception {
        Author author1 = new Author("H.M", "Kudaligama");
        Author author2 = new Author("Ediriweera", "Sarachchandra");
        authorRepository.save(author1);
        authorRepository.save(author2);

        mockMvc.perform(get("/author")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("H.M"))
                .andExpect(jsonPath("$[0].lastName").value("Kudaligama"))
                .andExpect(jsonPath("$[1].firstName").value("Ediriweera"))
                .andExpect(jsonPath("$[1].lastName").value("Sarachchandra"));
    }

    @Test
    @DisplayName("Test Get Author details by id")
    void shouldReturnAuthorById() throws Exception {
        Author author = new Author("Mahagama", "Sekara");
        authorRepository.save(author);

        mockMvc.perform(get("/author/" + author.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Mahagama"))
                .andExpect(jsonPath("$.lastName").value("Sekara"));
    }

    @Test
    @DisplayName("Create new author")
    void testCreateNewAuthor() throws Exception {
        String newAuthorJson = "{ \"firstName\": \"John\", \"lastName\": \"Smith\" }";

        mockMvc.perform(post("/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newAuthorJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Smith"));
    }

    @Test
    @DisplayName("Create new book")
    void shouldCreateNewBook() throws Exception {
        Author author = new Author("Sugathapala", "Silva");
        authorRepository.save(author);

        String newBookJson = "{ \"name\": \"Nandivisala\", \"isbn\": \"1122334455\", \"authorId\": " + author.getId() + " }";

        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Nandivisala"))
                .andExpect(jsonPath("$.isbn").value("1122334455"))
                .andExpect(jsonPath("$.authorName").value("Sugathapala Silva"));
    }

    @Test
    @DisplayName("Update existing author")
    void testUpdateExistingAuthor() throws Exception {
        Author author = new Author("Cimon", "Name");
        authorRepository.save(author);

        String updatedAuthorJson = "{ \"firstName\": \"Simon\", \"lastName\": \"Navagattegama\" }";

        mockMvc.perform(put("/author/" + author.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedAuthorJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Simon"))
                .andExpect(jsonPath("$.lastName").value("Navagattegama"));
    }

    @Test
    @DisplayName("Update existing book")
    void testUpdateExistingBook() throws Exception {
        Author author = new Author("Arisen", "Ahubudu");
        authorRepository.save(author);
        Book book = new Book("Aduwa", "1234567890", author);
        bookRepository.save(book);

        String updatedBookJson = "{ \"name\": \"Hadiya\", \"isbn\": \"0987654321\", \"authorId\": " + author.getId() + " }";

        mockMvc.perform(put("/book/" + book.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Hadiya"))
                .andExpect(jsonPath("$.isbn").value("0987654321"))
                .andExpect(jsonPath("$.authorName").value("Arisen Ahubudu"));
    }
}
