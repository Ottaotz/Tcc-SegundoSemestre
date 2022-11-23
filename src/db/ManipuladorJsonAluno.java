package db;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Alunos.Aluno;

public class ManipuladorJsonAluno {
	private static String path = "aluno.json";
	
	protected static void escritor(ArrayList<Aluno> list) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		Gson gson = new Gson();
		String json = gson.toJson(list);
		buffWrite.append(json + "\n");
		buffWrite.close();
	}
	@SuppressWarnings("unchecked")
	protected static ArrayList<Aluno> leitor() throws FileNotFoundException {
		FileReader json = new FileReader(path);
		Gson gson = new Gson();		
		Type tipoLista = new TypeToken<ArrayList<Aluno>>() {}.getType();
		ArrayList<Aluno> listaDeAlunos = gson.fromJson(json, tipoLista);
		
		return listaDeAlunos;
		
	}
}
