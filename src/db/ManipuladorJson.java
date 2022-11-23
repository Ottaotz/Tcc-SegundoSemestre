package db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Alunos.Aluno;
import Disciplinas.Disciplina;
import Notas.Avaliacao;

public class ManipuladorJson {
	public void writeAluno(ArrayList<Aluno> list) throws IOException {
		ManipuladorJsonAluno.escritor(list);
	}
	
	public void writeDisciplina(ArrayList<Disciplina> lista) throws IOException {
		ManipuladorJsonDisciplinas.escritor(lista);
	}
	
	public void writeAvaliacao(ArrayList<Avaliacao> lista) throws IOException {
		ManipuladorDeJsonAvaliacoes.escritor(lista);
	}
	
	public ArrayList<Aluno> readAluno() throws FileNotFoundException {
		return ManipuladorJsonAluno.leitor();
	}
	
	public ArrayList<Disciplina> readDisciplina() throws FileNotFoundException {
		return ManipuladorJsonDisciplinas.leitor();
	}
	
	public ArrayList<Avaliacao> readAvaliacao() throws FileNotFoundException {
		return ManipuladorDeJsonAvaliacoes.leitor();
	}
}
