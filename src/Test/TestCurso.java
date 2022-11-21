package Test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import Alunos.Aluno;
import Disciplinas.Disciplina;
import Notas.Avaliacao;
import Notas.Curso;

public class TestCurso {
	private Curso curso;
	private Aluno aluno;
	private Disciplina disciplina;
	
	@Before
	public void start() {
		curso = new Curso();
		aluno = new Aluno("Geromel", "002");
		disciplina = new Disciplina("Algoritmos", "001");
		curso.addAvaliacao(new Avaliacao(aluno, disciplina));
	}
	
	@Test
	public void mustAddGrade1() {
		double notaAdicionada = 8.8;
		curso.adicionaNota1(aluno, disciplina, notaAdicionada);
		
		assertEquals(notaAdicionada, curso.procuraAvaliacao(aluno, disciplina).getNota1(), 0);
	}
	
	@Test
	public void mustAddGrade2() {
		double notaAdicionada = 7.6;
		curso.adicionaNota2(aluno, disciplina, notaAdicionada);
		
		assertEquals(notaAdicionada, curso.procuraAvaliacao(aluno, disciplina).getNota2(), 0);
	}
	
	@Test
	public void mustAddBothGrades() {
		double notaAdicionada1 = 9.4;
		double notaAdicionada2 = 7.8;
		curso.adicionaNota1e2(aluno, disciplina, notaAdicionada1, notaAdicionada2);
		
		assertEquals(notaAdicionada1, curso.procuraAvaliacao(aluno, disciplina).getNota1(), 0);
		assertEquals(notaAdicionada2, curso.procuraAvaliacao(aluno, disciplina).getNota2(), 0);
	}
	
	@Test
	public void mustAddGade1WithoutAvaliacao() {
		double notaAdicionda = 6.9;
		disciplina = new Disciplina("Matematica", "002");
		curso.adicionaNota1(aluno, disciplina, notaAdicionda);
		
		assertEquals(notaAdicionda, curso.procuraAvaliacao(aluno, disciplina).getNota1(), 0);
	}
	
	@Test
	public void mustAddGade2WithoutAvaliacao() {
		double notaAdicionda = 6.9;
		disciplina = new Disciplina("Matematica", "002");
		curso.adicionaNota2(aluno, disciplina, notaAdicionda);
		
		assertEquals(notaAdicionda, curso.procuraAvaliacao(aluno, disciplina).getNota2(), 0);
	}
	
	@Test
	public void mustAddBothGradesWithoutAvaliacao() {
		double notaAdicionada1 = 9.4;
		double notaAdicionada2 = 7.8;
		disciplina = new Disciplina("Matematica", "002");
		curso.adicionaNota1e2(aluno, disciplina, notaAdicionada1, notaAdicionada2);
		
		assertEquals(notaAdicionada1, curso.procuraAvaliacao(aluno, disciplina).getNota1(), 0);
		assertEquals(notaAdicionada2, curso.procuraAvaliacao(aluno, disciplina).getNota2(), 0);
	}
	
}
