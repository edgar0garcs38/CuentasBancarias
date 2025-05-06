package org.edgar.cuentabancaria;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido");
        System.out.println("¿Que tipo de cuenta tiene?");
        System.out.println("1. Ahorros");
        System.out.println("2. Corriente");
        opcion = scanner.nextInt();

        if (opcion == 1) {

            System.out.println("Ingrese el saldo inicial");
            float saldoInicial = scanner.nextFloat();

            System.out.println("Ingrese tasa de interes anual");
            float tasaInteres = scanner.nextFloat();


            CuentaAhorros cuenta1 = new CuentaAhorros(saldoInicial, tasaInteres);
            do {
                System.out.println("/n Menu Principal");
                System.out.println("1. Depositar dinero");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad a depositar");
                        float depositar =  scanner.nextFloat();
                        cuenta1.depositar(depositar);
                        cuenta1.extractoMensual();
                        cuenta1.imprimirDatos();
                        break;

                        case 2:
                            System.out.println("Ingrese la cantidad a retirar");
                            float retirar = scanner.nextFloat();
                            cuenta1.retirar(retirar);
                            cuenta1.extractoMensual();
                            cuenta1.imprimirDatos();
                            break;

                        case 3:
                            cuenta1.imprimirDatos();
                            break;

                        case 4:
                            System.exit(0);

                            default:
                                System.out.println("Opcion Invalida");
                }
            } while (opcion != 4);
        }
        else if (opcion == 2) {

            System.out.println("Ingrese el saldo inicial");
            float saldoInicial = scanner.nextFloat();

            System.out.println("Ingrese tasa de interes anual");
            float tasaInteres = scanner.nextFloat();


            CuentaCorriente cuenta1 = new CuentaCorriente(saldoInicial, tasaInteres);
            do {
                System.out.println("/n Menu Principal");
                System.out.println("1. Depositar dinero");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad a depositar");
                        float depositar =  scanner.nextFloat();
                        cuenta1.depositar(depositar);
                        cuenta1.extractoMensual();
                        cuenta1.imprimirDatos();
                        break;

                    case 2:
                        System.out.println("Ingrese la cantidad a retirar");
                        float retirar = scanner.nextFloat();
                        cuenta1.retirar(retirar);
                        cuenta1.extractoMensual();
                        cuenta1.imprimirDatos();
                        break;

                    case 3:
                        cuenta1.imprimirDatos();
                        break;

                    case 4:
                        System.exit(0);

                    default:
                        System.out.println("Opcion Invalida");
                }
            } while (opcion != 4);
        }
    }
}