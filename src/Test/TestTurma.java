package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import Alunos.Aluno;
import Alunos.Turma;

public class TestTurma {
	private Turma turma;
	private List<Aluno> alunos;
	
	@Before
	public void start() {
		turma = new Turma();
		alunos = new ArrayList<>();
		alunos.add(new Aluno("Otto", "001"));
		alunos.add(new Aluno("Festa", "002"));
		alunos.add(new Aluno("Thomaz", "003"));
		alunos.add(new Aluno("Beatriz", "010"));
		alunos.add(new Aluno("KillJoy", "004"));
	}
	
	@After
	public void end() {
		alunos.clear();
		turma.clearListaDeAlunos(); //não entendi pois para cada teste é criada outra turma na ref
	}
	
	@Test
	public void mustAddAllStudantsNoList() {
		for(Aluno aluno : alunos)
			turma.addAluno(aluno);
		
		assertEquals(alunos.size(), turma.getListaDeAlunos().size());
	}
	
	@Test
	public void mustAddAllStudantsFromList() {
		turma.addAluno(alunos);
		
		assertEquals(alunos.size(), turma.getListaDeAlunos().size());
	}
	
	@Test
	public void mustReturnAnExistingStudent() {
		turma.addAluno(alunos);
		
		assertEquals("Otto", turma.verificaSeAlunoExistePorMatricula("001").getNome());
	}
	
	@Test
	public void mustReturnNull() {
		turma.addAluno(alunos);
		
		assertEquals(null, turma.verificaSeAlunoExistePorMatricula("p"));
	}

}
