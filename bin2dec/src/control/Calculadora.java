package control;

public class Calculadora {
	public static int converterBin2Dec(String bin) {
		int resposta = 0;
		bin = bin.substring(bin.indexOf('1'));
		int n = bin.length()-1;
		
		for (int i = 0; i<bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				resposta += Math.pow(2, n);
			}
			n--;
		}
		
		return resposta;
		
	}
}
