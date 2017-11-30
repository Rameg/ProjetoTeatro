/**
 * 
 */
package br.com.flaer.dominio;

public class Usuario {
	
	private int posicao;
	private String nome;
	private String cpf;
	
	Usuario(){
		
	}
	
	Usuario(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
	
	

}
