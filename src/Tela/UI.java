package Tela;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Alunos.Aluno;
import Alunos.Turma;
import Disciplinas.Curriculo;
import Disciplinas.Disciplina;
import Notas.Avaliacao;
import Notas.Curso;
import db.ManipuladorJson;

public class UI {
	private Scanner teclado;
	private Turma turma = new Turma();
	private Curriculo curriculo = new Curriculo();
	private Curso curso = new Curso();
	private ManipuladorJson manipulador = new ManipuladorJson();

	public UI() {
		teclado = new Scanner(System.in);
	}

	public void loopMenu() throws IOException {
		turma.addAluno(manipulador.readAluno());
		curriculo.addDisciplinas(manipulador.readDisciplina());
		curso.addAvaliacao(manipulador.readAvaliacao());
		boolean condicao = true;

		while (condicao) {
			menu();
			System.out.printf("\nDigite a opção que deseja do menu: ");
			int codigo = teclado.nextInt();
			switch (codigo) {
			case 1:
				insereAluno();
				break;
			case 2:
				insereDisciplina();
				break;
			case 3:
				adicionarNota();
				break;
			case 4:
				mediaAri();
				break;
			case 5:
				mediaPon();
				break;
			case 6:
				listaAlu();
				break;
			case 7:
				manipulador.writeAluno(turma.getListaDeAlunos());
				manipulador.writeDisciplina(curriculo.getLista());
				manipulador.writeAvaliacao(curso.getListaDeAvaliacoes());
				System.out.println("Encerrando...");
				condicao = false;
				break;
			default:
				naoExiste();
				break;
			}
		}
	}

	public void menu() {
		System.out.println("[1] - Inserir Aluno");
		System.out.println("[2] - Inserir Disciplina");
		System.out.println("[3] - Adicionar Notas");
		System.out.println("[4] - Calcular Média Aritmética");
		System.out.println("[5] - Calcular Média Ponderada");
		System.out.println("[6] - Listar Alunos e suas notas");
		System.out.println("[7] - Sair");
	}

	public void naoExiste() {
		System.out.println("Número digitado não existe no Menu. Digite novamente");
	}

	public void insereAluno() {
		System.out.println("Adicionando um aluno!");
		System.out.println("Digite o nome do Aluno ");
		String nome = teclado.next();
		System.out.println("Digite a matricula do aluno: ");
		String matricula = teclado.next();

		turma.addAluno(new Aluno(nome, matricula));
		System.out.println("Aluno adicionado com sucesso...");
	}

	public void insereDisciplina() {
		System.out.println("Adicionando uma Disciplina!");
		System.out.println("Digite o nome da Disciplina: ");
		String nome = teclado.next();
		System.out.println("Digite o código da Disciplina: ");
		String codigo = teclado.next();

		curriculo.addDisciplinas(new Disciplina(nome, codigo));
		System.out.println("Disciplina adicionada com sucesso...");
	}

	// verificar se aluno existe
	public void adicionarNota() {
		boolean condicao1 = true;
		boolean condicao2 = true;
		String matriculaAluno = "";
		String codigoDisciplina = "";

		while (condicao1) {
			System.out.println("Adicionando Notas\n\nInforme a matricula do Aluno");
			matriculaAluno = teclado.next();
			if (matriculaAluno == "") {
				System.out.println("Código inválido! Retornando ao menu.");
				break;
			}

			Aluno alu = turma.verificaSeAlunoExistePorMatricula(matriculaAluno);

			if (alu == null) {
				System.out.println("Aluno não existe! Retornando ao menu.");
				break;
			}

			System.out.println("\nInforme o código da Disciplina");
			codigoDisciplina = teclado.next();
			if (codigoDisciplina == "") {
				System.out.println("Código inválido! Retornando ao menu.");
				break;
			}

			Disciplina dis = curriculo.verificaSeDisciplinaExistePorCodigo(codigoDisciplina);

			if (dis == null) {
				System.out.println("Disciplina não existe! Retornando ao menu.");
				break;
			}

			while (condicao2) {
				System.out.println("Adicionando Notas \nQual/Quais nota(s) adicionar?");
				System.out.println("[1] Nota 1\n[2] Nota 2\n[3] Nota 1 e 2\n[4] Sair");
				int codigo = verificaSeValidoInt(teclado.next());

				switch (codigo) {
				case 1:
					double nota1 = capturarNotas("1");
					curso.adicionaNota1(alu, dis, nota1);
					condicao2 = false;
					condicao1 = false;
					break;
				case 2:
					double nota2 = capturarNotas("2");
					curso.adicionaNota2(alu, dis, nota2);
					condicao2 = false;
					condicao1 = false;
					break;
				case 3:
					double not1 = capturarNotas("1");
					double not2 = capturarNotas("2");
					curso.adicionaNota1e2(alu, dis, not1, not2);
					condicao2 = false;
					condicao1 = false;
					break;
				case 4:
					System.out.println("Saindo...");
					condicao2 = false;
					condicao1 = false;
					break;
				default:
					System.out.println("Codigo não encontrado, digite novamente.");

				}

			}

		}

	}

	public void mediaAri() {
		System.out.println("Verificando Média Aritmética\n\nInforme a matricula do Aluno");
		String matriculaAluno = teclado.next();
		if (matriculaAluno == "") {
			System.out.println("Código inválido! Retornando ao menu.");
			return;
		}

		Aluno alu = turma.verificaSeAlunoExistePorMatricula(matriculaAluno);

		if (alu == null) {
			System.out.println("Aluno não existe! Retornando ao menu.");
			return;
		}

		System.out.println("Verificando Média Aritmética\n\nInforme o código da Disciplina");
		String codigoDisciplina = teclado.next();
		if (codigoDisciplina == "") {
			System.out.println("Código inválido! Retornando ao menu.");
			return;
		}

		Disciplina dis = curriculo.verificaSeDisciplinaExistePorCodigo(codigoDisciplina);

		if (dis == null) {
			System.out.println("Disciplina não existe! Retornando ao menu.");
			return;
		}

		Avaliacao a = curso.procuraAvaliacao(alu, dis);

		if (a == null) {
			System.out.println("Avaliacao deste Aluno/Disciplina não existe! Retornando ao menu.");
			return;
		}

		if (a.getNota1() == 0 && a.getNota2() == 0) {
			System.out.println("Aluno sem notas para esta disciplina! Retornando ao menu.");
			return;
		}

		System.out.println("-> " + alu.getNome() + " - " + dis.getNome() + " - " + a.getMediaAri());

	}

	public void mediaPon() {
		System.out.println("Verificando Média Ponderada\n\nInforme a matricula do Aluno");
		String matriculaAluno = teclado.next();
		if (matriculaAluno == "") {
			System.out.println("Código inválido! Retornando ao menu.");
			return;
		}

		Aluno alu = turma.verificaSeAlunoExistePorMatricula(matriculaAluno);

		if (alu == null) {
			System.out.println("Aluno não existe! Retornando ao menu.");
			return;
		}

		System.out.println("Verificando Média Ponderada\n\nInforme o código da Disciplina");
		String codigoDisciplina = teclado.next();
		if (codigoDisciplina == "") {
			System.out.println("Código inválido! Retornando ao menu.");
			return;
		}

		Disciplina dis = curriculo.verificaSeDisciplinaExistePorCodigo(codigoDisciplina);

		if (dis == null) {
			System.out.println("Disciplina não existe! Retornando ao menu.");
			return;
		}

		Avaliacao a = curso.procuraAvaliacao(alu, dis);

		if (a == null) {
			System.out.println("Avaliacao deste Aluno/Disciplina não existe! Retornando ao menu.");
			return;
		}

		if (a.getNota1() == 0 && a.getNota2() == 0) {
			System.out.println("Aluno sem notas para esta disciplina! Retornando ao menu.");
			return;
		}

		System.out.println("-> " + alu.getNome() + " - " + dis.getNome() + " - " + a.getMediaPon());
	}

	public void listaAlu() {
		ArrayList<Avaliacao> cursoAux = curso.getListaDeAvaliacoes();
		if (cursoAux.size() == 0) {
			System.out.println("Nenhuma avaliacão encontrada.");
			return;
		}
		System.out.println("***Lista de Avaliações***");
		System.out.println("====================");

		for (int i = 0; i < cursoAux.size(); i++) {
			System.out.println(cursoAux.get(i).getAluno().getNome());
			System.out.println(cursoAux.get(i).getDisciplina().getNome());
			System.out.print("Nota 1: ");
			if (cursoAux.get(i).getNota1() == -1) {
				System.out.println("* ");
			} else {
				System.out.println("(" + cursoAux.get(i).getNota1() + ")");
			}
			System.out.print("Nota 2: ");
			if (cursoAux.get(i).getNota2() == -1) {
				System.out.println("* ");
			} else {
				System.out.println("(" + cursoAux.get(i).getNota2() + ")");
			}
			if (cursoAux.get(i).getNota1() != -1 && cursoAux.get(i).getNota2() != -1) {
				System.out.printf("Média Aritmética: " + cursoAux.get(i).getMediaAri()+ "%n");
				System.out.printf("Média Ponderada: " + cursoAux.get(i).getMediaPon());
			} 
			else if (cursoAux.get(i).getNota1() != -1){
				System.out.printf("Média Aritmética: " + cursoAux.get(i).getNota1()+ "%n");
				System.out.printf("Média Ponderada: " + cursoAux.get(i).getNota1());	
			}
			else {
				System.out.printf("Média Aritmética: " + cursoAux.get(i).getNota2()+ "%n");
				System.out.printf("Média Ponderada: " + cursoAux.get(i).getNota2());	
			}
			
			System.out.println("\n====================\n");

		}

	}

	public int verificaSeValidoInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}

	public double capturarNotas(String s) {
		System.out.println("Digite a nota " + s + ":");
		double nota = teclado.nextDouble();
		while (nota < 0 || nota > 10.0) {
			System.out.println("Nota precisa ser maior que 0 e menor que 10");
			System.out.println("Digite a nota " + s + ":");
			nota = teclado.nextDouble();
		}
		return nota;
	}

}
