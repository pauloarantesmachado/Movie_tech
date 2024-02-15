package br.com.alura.Movietech.domain.filme;

public record RegisterDataMovie(
        String name,
        Integer duration,
        Integer years,
        String gender
) {
}
