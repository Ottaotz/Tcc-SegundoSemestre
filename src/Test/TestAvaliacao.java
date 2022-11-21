package Test;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.junit.*;

import Alunos.Aluno;
import Disciplinas.Disciplina;
import Notas.Avaliacao;

public class TestAvaliacao {
	private Avaliacao avaliacao;
	private NumberFormat formatter;
	
	@Before
	public void start() {
		Aluno aluno = new Aluno("Akko", "665");
		Disciplina disciplina = new Disciplina("Algoritmos", "001");
		avaliacao = new Avaliacao(aluno, disciplina, 6.2, 8.7);
		Locale.setDefault(new Locale("en", "US"));
		formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
	}
	
	@Test
	public void mustCalculateCorrectlyMediaAritmedica() {
		double actual = Double.parseDouble(formatter.format(avaliacao.getMediaAri()));
		assertEquals(7.45, actual, 0);
	}
	
	@Test
	public void mustCalculateCorrectlyMediaPonderada() {
		double actual = Double.parseDouble(formatter.format(avaliacao.getMediaPon()));
		assertEquals(7.87, actual, 0);
	}

}
