package util;

public class CurrencyConverter {
	
	public static double pagoReais(double dolarCotacao, double qtdDolares) { 
		double iof = ((qtdDolares * 6) / 100) * dolarCotacao;
		double pagoReais = (qtdDolares * dolarCotacao) + iof;
		return pagoReais;
}
}