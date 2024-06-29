package com.challenge.literalura.literalura.service;

import com.challenge.literalura.literalura.model.Book;
import com.challenge.literalura.literalura.model.GutendexResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class GutendexService {

    private final HttpClient httpClient = HttpClientBuilder.create().build();

    public List<Book> getBooks(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);

        if (response.getStatusLine().getStatusCode() == 200) {
            try (InputStream inputStream = response.getEntity().getContent()) {
                ObjectMapper mapper = new ObjectMapper();
                GutendexResponse gutendexResponse = mapper.readValue(inputStream, GutendexResponse.class);
                return gutendexResponse.getResults();
            }
        } else {
            throw new IOException("Error al obtener libros: " + response.getStatusLine().getStatusCode());
        }
    }

    public String fetchBookDetails(String title) throws IOException {
        String url = "https://gutendex.com/books/?search=" + title;
        return getBooks(url).stream().findFirst().map(Book::getDetails).orElse(null);
    }
}

