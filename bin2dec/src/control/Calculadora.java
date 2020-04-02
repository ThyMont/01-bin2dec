package control;

public class Calculadora {
	private int resposta = 0;
	private String respostaBin = "";

	public boolean converterBin2Dec(String bin) {

		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) != '0' && bin.charAt(i) != '1') {
				return false;
			}
		}
		try {
			bin = bin.substring(bin.indexOf('1')).trim();
		} catch (Exception e) {

		}
		int n = bin.length() - 1;

		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				resposta += Math.pow(2, n);
			}
			n--;
		}

		return true;

	}

	public int getResposta() {
		return resposta;
	}

	public boolean converterDec2Bin(String dec) {
		int x = 0;
		int resto = 0;
		try {
			x = Integer.parseInt(dec);
		} catch (Exception e) {
			return false;
		}

		while (x >= 1) {
			resto = x % 2;
			respostaBin = resto + respostaBin;
			x = x / 2;
		}

		return true;
	}

	public String getRespostaBin() {
		return respostaBin;
	}

}
