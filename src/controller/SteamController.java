package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SteamController implements ISteamController{

	@Override
	public void readFile(String path, String nome, int ano, String mes, double media) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			buffer.readLine();
			String linha = null;
			while((linha = buffer.readLine()) !=null) {
				String dados[] = new String[7];
				dados = linha.split(",");
				String fileira = "";
				int auxAno = Integer.parseInt(dados[1]);
				if(auxAno == ano && dados[2].equals(mes)) {
					double auxMedia = Double.parseDouble(dados[3]);
					if(auxMedia >= media){
						fileira = dados[0] + " | " + dados[3];				
						System.out.println(fileira);
					}	
				}
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}


	@Override
	public void createFile(String path, String nome, String novoNome, int ano, String mes) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome);
		File arqNovo = new File(path, novoNome);
		if(dir.exists() && dir.isDirectory()){
			boolean existe = false;
			if(arq.exists()){
				existe = true;
			}
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			FileWriter fileWriter = new FileWriter(arqNovo, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			buffer.readLine();
			String linha = null;
			while((linha = buffer.readLine()) !=null) {
				String dados[] = new String[7];
				dados = linha.split(",");
				String fileira = "";
				int auxAno = Integer.parseInt(dados[1]);
				if(auxAno == ano && dados[2].equals(mes)) {
					fileira = dados[0] + " ; " + dados[5];
					print.write(fileira + "\n");
					print.flush();
				}
			}
			print.close();
			buffer.close();
			leitor.close();
			fluxo.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido");
		}

		}
		
	}
