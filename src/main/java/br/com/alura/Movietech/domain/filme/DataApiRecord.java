package br.com.alura.Movietech.domain.filme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataApiRecord(
        String Title,
        String Runtime,

        String Year,

        String Genre,
        String Poster
) {
}
