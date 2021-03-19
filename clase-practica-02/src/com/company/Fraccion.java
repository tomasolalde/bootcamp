package com.company;

public class Fraccion {

    private float valor;

    public Fraccion(float valor) {
        this.valor = valor;
    }

    public Fraccion() {
    }

    public void sumar(float val) {
        this.valor += val;
    }

    public void sumar(int val) {
        this.valor += val;
    }

    public void restar(float val) {
        this.valor -= val;
    }

    public void restar(int val) {
        this.valor -= val;
    }

    public void multilicar(float val) {
        this.valor *= val;
    }

    public void multilicar(int val) {
        this.valor *= val;
    }

    public void dividir(float val) {
        this.valor /= val;
    }

    public void dividir(int val) {
        this.valor /= val;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "valor=" + valor +
                '}';
    }
}
