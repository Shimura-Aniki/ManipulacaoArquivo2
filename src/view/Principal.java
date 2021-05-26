package view;

import java.io.IOException;

import controller.ISteamController;
import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		ISteamController arqCont = new SteamController();
		String path = "C:\\TEMP";
		String nome = "SteamCharts.csv";
		String novoNome = "nome";
		int ano = 2020;
		String mes = "December";
		double media = 5000;

		try {
			arqCont.readFile(path, nome, ano, mes, media);
			arqCont.createFile(path, nome, novoNome, ano, mes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
