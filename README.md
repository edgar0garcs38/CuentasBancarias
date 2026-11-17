# Bank Accounts: Java OOP Exercise

A console program that models bank accounts to practice **inheritance and polymorphism** in Java.

## Design
| Class | Description |
|---|---|
| `CuentaBancaria` | Base account: balance, deposits, withdrawals, annual interest rate, monthly fee, monthly interest and monthly statement |
| `CuentaAhorros` | Savings account: inactive while the balance is under \$50 (no withdrawals allowed), and charges \$1 per withdrawal beyond 4 a month |
| `CuentaCorriente` | Checking account: allows an overdraft, which is paid off automatically by the next deposit |
| `Main` | Reads user input and runs the operations |

Each subclass **overrides** `depositar`, `retirar`, `extractoMensual` and `imprimirDatos` with its own rules.

## Tech stack
Java · Maven

## Run it
```bash
mvn compile exec:java -Dexec.mainClass=org.edgar.cuentabancaria.Main
```
