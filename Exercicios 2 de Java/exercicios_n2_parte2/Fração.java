package exercicios_n2_parte2;

public class Fração {
	
	private int numerador;
	private int denominador;
	
	Fração(int numerador, int denominador){
		this.numerador = numerador; 
		this.denominador = denominador;
	}
	
	public String toString() {
		
		return Math.abs(getNumerador()) + "/" + Math.abs(getDenominador());
		
	}
	
	public Fração soma(Fração adiciona){
			
		return new Fração (
			(denominador * adiciona.numerador) + (adiciona.denominador * numerador),
			denominador * adiciona.denominador);		
			
	}
	
	public Fração subtração(Fração subtrai){
		
		return new Fração (
				(denominador * subtrai.numerador) - (subtrai.denominador * numerador),
				denominador * subtrai.denominador);
		
	};
	
	public Fração multiplicação(Fração multiplica) {
		
		return new Fração (numerador * multiplica.numerador, denominador * multiplica.denominador);
		
	}
	
	public Fração divisão(Fração divide) {
		
		return new Fração (numerador * divide.denominador, denominador * divide.numerador);

	}
	
    public Fração simplificar() {
    	final int mmc = this.minimoMultiploComumDe(this.numerador, this.denominador);
        this.numerador = numerador / mmc;
        this.denominador = denominador / mmc;
        return new Fração(this.numerador / mmc, this.denominador / mmc);
    }

    private int minimoMultiploComumDe(final int primeiroNumero, final int segundoNumero) {
        if (segundoNumero == 0) {
            return primeiroNumero;
        }
        return this.minimoMultiploComumDe(segundoNumero, primeiroNumero % segundoNumero);
    }

	public int getNumerador() {
		return numerador;
	}
	
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	
	public int getDenominador() {
		return denominador;
	}
	
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

}

