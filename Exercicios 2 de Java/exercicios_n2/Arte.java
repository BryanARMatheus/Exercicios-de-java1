package exercicios_n2;

public class Arte implements MenuMetodos{
	private String metodoDesenho;
	private String tipo;
	private String instrumentoDesenho;
	
	Arte(String metodoDesenho, String tipo, String instrumentoDesenho){
		this.setMetodoDesenho(metodoDesenho);
		this.setTipo(tipo);
		this.setInstrumentoDesenho(instrumentoDesenho);
	}
	
	void desenhar(){
		System.out.println("Você cria um desenho " + metodoDesenho);
	}
	
	void colorir() {
		System.out.println("Você adiciona cor ao seu desenho");
	}
	
	void apagar() {
		System.out.println("Voc~e identifica um erro no desenho e o apaga");
	}

	public String getMetodoDesenho() {
		return metodoDesenho;
	}

	public void setMetodoDesenho(String metodoDesenho) {
		this.metodoDesenho = metodoDesenho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getInstrumentoDesenho() {
		return instrumentoDesenho;
	}

	public void setInstrumentoDesenho(String instrumentoDesenho) {
		this.instrumentoDesenho = instrumentoDesenho;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Desenhar");
		System.out.println("3 - Colorir");
		System.out.println("4 - Sair");
	}

}
