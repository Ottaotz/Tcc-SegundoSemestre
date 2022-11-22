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

import Disciplinas.Disciplina;

public class ManipuladorJsonDisciplinas {
private static String path = "C:\\Users\\ottos\\Documents\\github\\unisinos\\semestre2\\TrabalhoFinalNotas\\src\\db\\disciplina.json";
	
	public static void escrtitor(ArrayList<Disciplina> lista) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		buffWrite.append(json + "\n");
		buffWrite.close();
	}
	@SuppressWarnings("unchecked")
	public static void leitor() throws FileNotFoundException {
		FileReader json = new FileReader(path);
		Gson gson = new Gson();		
		Type tipoLista = new TypeToken<ArrayList<Disciplina>>() {}.getType();
		ArrayList<Disciplina> listaDeDisciplinas = gson.fromJson(json, tipoLista);
		
		System.out.println(listaDeDisciplinas);
		
	}
}