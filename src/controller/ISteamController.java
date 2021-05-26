package controller;

import java.io.IOException;

public interface ISteamController {
	public void createFile(String path, String nome, String novoNome, int ano, String mes) throws IOException;
	public void readFile(String path, String nome, int ano, String mes, double media) throws IOException;
}
