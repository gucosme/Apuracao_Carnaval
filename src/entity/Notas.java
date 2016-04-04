package entity;

public class Notas {

	private String idEscola;
	private String quesito;
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double nota5;
	private double totaPontos;
	private double maior;
	private double menor;
	
	public double getMaior() {
		return maior;
	}
	public void setMaior(double maior) {
		this.maior = maior;
	}
	public double getMenor() {
		return menor;
	}
	public void setMenor(double menor) {
		this.menor = menor;
	}
	public String getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(String idEscola) {
		this.idEscola = idEscola;
	}
	public String getQuesito() {
		return quesito;
	}
	public void setQuesito(String quesito) {
		this.quesito = quesito;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public double getNota5() {
		return nota5;
	}
	public void setNota5(double nota5) {
		this.nota5 = nota5;
	}
	public double getTotaPontos() {
		return totaPontos;
	}
	public void setTotaPontos(double totaPontos) {
		this.totaPontos = totaPontos;
	}
}
