package org.edgar.cuentabancaria;
/*
* programador : Edgar Garces
* fecha: 01/05/2025
* descripcion: Esta es la clase padre donde vamos a modelar
* un objeto de tipo cuenta bancaria
 */


public class CuentaBancaria {
    /*
    Declarar una variable de tipo float de nombre saldo
     */
    protected float saldo;
    /*
    declaramos e inicializamos una variable de tipo entero con el nombre número de depositos
     */
    protected int numeroDepositos = 0;
    /*
    Declaramos e inicializamos una variable de tipo entero con el nombre de  número de retiros
     */
    protected int numeroRetiro = 0;
    /*
    Declaramos una variable de tipo flotante de interes anual
     */
    protected float interesAnual;
    /*
    Declaramos una variable de tipo float de nombre de comision mensual
     */
    protected float comisionMensual = 0;

    protected float interesMensual;
    /*
    contructor de la clase CuentaBancaria
    @Param saldo, parametro que define el saldo de la cuenta
    @Param interesAnual, parametro que define el interes anual que nos da el banco
     */
    public CuentaBancaria(float saldo, float interesAnual) {
        this.saldo = saldo;
        this.interesAnual = interesAnual;
    }

    /*
    metodo depositar
     */
    public void depositar(float cantidad) {
        //Aumentar o sumar el saldo
        saldo = saldo + cantidad;
        //incrementamos el numero de depositos
        numeroDepositos =  numeroDepositos + 1;
    }

    /*
    metodo retirar
     */
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;

        if(nuevoSaldo >= 0) {
            //Retiro de dinero
            saldo = saldo - cantidad;
            //Cuento las opreaciones de retiro
            numeroRetiro = numeroRetiro + 1;
        } else {
            System.out.println("No se puede retirar el dinero, saldo insuficiente");
        }
    }

    /*
    metodo interes mensual
     */
    public void calcularInteresMensual() {
        float interesMensual = (interesAnual / 12) / 100; // Convertimos a porcentaje
        saldo += saldo * interesMensual;
    }

    /*
    metodo extracto mensual
     */
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    /*
    imprimir datos bancarios
     */
    public void imprimirDatos() {
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Número de depósitos: " + numeroDepositos);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Interés anual: " + interesAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
    }

    public static void main(String[] args){
        // Crear una instancia de la cuenta con saldo inicial y tasa de interés
        CuentaBancaria cuenta = new CuentaBancaria(1000, 5);

        // Realizar algunas operaciones
        cuenta.depositar(500);
        cuenta.retirar(200);
        cuenta.extractoMensual();

        // Imprimir los datos de la cuenta
        cuenta.imprimirDatos();
    }
}