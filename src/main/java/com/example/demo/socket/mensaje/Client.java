package com.example.demo.socket.mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Client() {
		try {
			Socket clientSocket = new Socket(IP, PORT);
			System.out.println("--------1 Iniciando comunicacion-----------");
			
			//Flujos de comunicacion
			BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
			
			salida.println("Platinium");
			String precio = entrada.readLine();
			System.out.println("El precio es ==> " + precio);
			
			System.out.println("--------2 Finalizando comunicacion-----------");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new Client();
	}

}
