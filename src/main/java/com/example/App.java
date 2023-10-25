package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        try {
            System.out.println("Il client è partito");
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("inserisci un numero da 1 a 100");
            int risposta =0;
            do {
                out.writeBytes(tastiera.nextLine() + '\n');
                risposta = Integer.parseInt(in.readLine());
                System.out.println(risposta);
                System.out.println("ciao");
                if (risposta == 1) {
                    System.out.println("il numero è troppo piccolo, prova di nuovo");
                } else {
                    System.out.println("il numero è troppo grande");
                }

            } while (risposta != 3);

            System.out.println("il numero è giusto");

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
