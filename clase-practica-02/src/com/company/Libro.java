package com.company;

public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private Boolean disponible = true;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public Libro() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void prestamo() {
        this.disponible = false;
    }

    public void devolucion() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Libro: " +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'';
    }
}
