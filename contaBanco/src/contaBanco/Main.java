package contaBanco;

public class Main {
	static ContaTerminal conta=new ContaTerminal();
	//---
	public static void main(String[] args) {
		conta.promptInicial();
		//---
		conta.inputNumeroDaConta();
		//---
		conta.inputAgencia();
		//---
		conta.inputNome();
		//---
		conta.inputSaldo();
		//---
		conta.mensagemFinal();
		//---
		conta.closeScanner();
	}

}
