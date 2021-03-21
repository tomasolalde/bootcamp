package com.company;

public class CuentaCorriente {

    private double saldo;
    private String propietario;
    private String CBU;

    public CuentaCorriente(double saldo, String propietario, String CBU) {
        this.saldo = saldo;
        this.propietario = propietario;
        this.CBU = CBU;
    }

    public String getPropietario() {
        return propietario;
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente() {
    }

    public void ingreso(double monto) {
        this.saldo += monto;
    }

    public void egreso(double monto) {
        this.saldo -= monto;
    }

    public void reintegro(double monto) {
        ingreso(monto);
    }

    public void transferencia(double monto) {
        egreso(monto);
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCorriente: " +
                "saldo=" + saldo +
                ", propietario='" + propietario + '\'' +
                ", CBU='" + CBU + '\'';
    }
}
