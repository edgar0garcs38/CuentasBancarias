package org.edgar.cuentabancaria;

public class CuentaAhorros extends CuentaBancaria{

    //Declaramos una variable de tipo booleana para verificar si la cuenta esta activa o no

    private boolean activa;

    /*
    implementamos el constructor
    @param saldo: Define el saldo de la cuenta de ahorros
    @param tasa: Parametro que define la tasa anual de interes
     */

    public CuentaAhorros(float saldo, float interesAnual){
        super(saldo,interesAnual);

        /*
        Verificamos si la cuenta esta activa o no
         */

        if (saldo < 50){
            //Desactivamos la cuenta
            activa = false;
        }else{
            activa = true;
        }
    }

    /*
    Implementamos un metodo de retiro
    @Param: saldo que va a manejar el saldo de la cuenta
    @Param: Cantidad defina la cantidad que va a retirar el cliente
     */

    public void retirar(float cantidad) {
        /*
        verifico si la cuenta esta activa
         */

        if (activa){
         /* retiro la cantidad de dinero*/
            super.retirar(cantidad);
        }
    }

    /*
    Implementamos el metodo para depositar
    @Param: saldo definimos el saldo de la cuenta
     */
    public void depositar(float cantidad){
        //Verificamos si la cuenta esta activa
        if (activa){
            super.depositar(cantidad);
        }
    }

    /*
    Implementamos el metodo de estracto mensual
     */
    public void extractoMensual(){
        /*
        Verificamos el numer de retiros para cobrar la comision mensual
         */
        if(numeroRetiro > 4){
            comisionMensual += (numeroRetiro - 4)*1;
        }
        //Invocamos al metodo extractoMensual
        super.extractoMensual();
        //Verificamos si la cuenta esta activa o no activa
        if(saldo < 50){
            activa = false;
        }
    }

    /*
    Implementamos un metodo donde se imprime toda la información
     */
    public void imprimirDatos() {
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Número de depósitos: " + numeroDepositos);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Extracto mesual es: " + interesAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
    }
}
