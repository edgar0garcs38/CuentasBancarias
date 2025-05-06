package org.edgar.cuentabancaria;

public class CuentaCorriente extends CuentaBancaria {
    private float sobreGiro = 0;

    public CuentaCorriente(float saldo, float interesAnual) {
        super(saldo, interesAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
        } else {
            sobreGiro = cantidad - saldo;
            saldo = 0;
        }
    }

    @Override
    public void depositar(float cantidad) {
        if (sobreGiro > 0) {
            if (cantidad >= sobreGiro) {
                cantidad -= sobreGiro;
                sobreGiro = 0;
            } else {
                sobreGiro -= cantidad;
                cantidad = 0;
            }
        }
        super.depositar(cantidad);
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    public void imprimirDatos() {
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Número de depósitos: " + numeroDepositos);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Interés anual: " + interesAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Sobregiro actual: $" + sobreGiro);
    }

    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente(500, 5); // Saldo inicial: $500, interés anual: 5%

        cuenta.retirar(600); // Retira más del saldo disponible, genera sobregiro
        cuenta.depositar(100); // Deposita dinero, primero cubre parte del sobregiro
        cuenta.extractoMensual(); // Genera el extracto mensual
        cuenta.imprimirDatos(); // Muestra los datos de la cuenta
    }
}
