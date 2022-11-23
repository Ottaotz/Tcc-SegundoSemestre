package Notas;

import java.util.ArrayList;

import Alunos.Aluno;
import Disciplinas.Disciplina;

public class Curso {
	private ArrayList <Avaliacao> listaDeAvaliacoes = new ArrayList<>();
	
	
	public void addAvaliacao(Avaliacao avaliacao) {
		listaDeAvaliacoes.add(avaliacao);
	}
	
	public void addAvaliacao(ArrayList<Avaliacao> lista) {
		if (lista == null)
			return;
		for (Avaliacao avaliacao : lista)
			listaDeAvaliacoes.add(avaliacao);
	}
	
	public ArrayList<Avaliacao> getListaDeAvaliacoes() {
		return listaDeAvaliacoes;
	}

	public void adicionaNota1(Aluno alu, Disciplina dis, double nota1) {
		Avaliacao aval = procuraAvaliacao(alu, dis);
		if(aval == null) {
			Avaliacao ava = new Avaliacao(alu, dis);
			ava.setNota1(nota1);
			addAvaliacao(ava);
		}
		else {
			aval.setNota1(nota1);
		}
		
	}

	public void adicionaNota2(Aluno alu, Disciplina dis, double nota2) {
		Avaliacao aval = procuraAvaliacao(alu, dis);
		if(aval == null) {
			Avaliacao ava = new Avaliacao(alu, dis);
			ava.setNota2(nota2);
			addAvaliacao(ava);
		}
		else {
			aval.setNota2(nota2);
		}
	}

	public void adicionaNota1e2(Aluno alu, Disciplina dis, double nota1, double nota2) {
		Avaliacao aval = procuraAvaliacao(alu, dis);
		if(aval == null) {
			Avaliacao ava = new Avaliacao(alu, dis, nota1, nota2);
			addAvaliacao(ava);
		}
		else {
			aval.setNota1eNota2(nota1, nota2);
		}
	}
	
	public Avaliacao procuraAvaliacao(Aluno alu, Disciplina dis) {
		for(int i=0;i<listaDeAvaliacoes.size();i++) {
			if(listaDeAvaliacoes.get(i).getAluno().getMatricula() == alu.getMatricula() && listaDeAvaliacoes.get(i).getDisciplina().getCodigo() == dis.getCodigo()) {
				return listaDeAvaliacoes.get(i);
			}
		}
		return null;
	}
	
}
