package db;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Notas.Avaliacao;

public class ManipuladorDeJsonAvaliacoes {
private static String path = "avaliacao.json";
	
	protected static void escritor(ArrayList<Avaliacao> lista) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		buffWrite.append(json + "\n");
		buffWrite.close();
	}
	@SuppressWarnings("unchecked")
	protected static ArrayList<Avaliacao> leitor() throws FileNotFoundException {
		FileReader json = new FileReader(path);
		Gson gson = new Gson();		
		Type tipoLista = new TypeToken<ArrayList<Avaliacao>>() {}.getType();
		ArrayList<Avaliacao> listaDeAvaliacoes = gson.fromJson(json, tipoLista);
		
		return listaDeAvaliacoes;
		
	}
}
