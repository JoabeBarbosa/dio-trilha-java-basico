package contaBanco;
//---
import java.util.Scanner;
//---
import java.util.List;
import java.util.ArrayList;
/* TO DO LIST:
*
* 1) Conhecer e importar a classe Scanner.
* 2) Exibir as mensagens para o usuário.
* 3) Obter pelo Scanner os valores digitados no terminal.
* 4) Exibir a mensagem "Conta Criada".
*/
public class ContaTerminal {
	//--- atributos (fields)
	int numero;
	String agencia;
	String nomeDoCliente;
	double saldo;
	//--- constant
	final int WRONG_VALUE=-1;
	//--- Enumeration
	enum ENUM_MESSAGE{
		WELCOME,STEP_1,STEP_2,STEP_3,STEP_4
	}
	
	//--- Message list
	List<String> messagesList=new ArrayList<>();
	//--- Constructor
	public ContaTerminal() {
		this.messagesList.add("Bem vindo ao Banco Santander. Vamos iniciar o processo de abertura da sua conta!");
		this.messagesList.add("Passo 1: digite 4 algarimos para compor o número da sua conta (ex: 1021): ");
		this.messagesList.add("Passo 2: digite 4 algarimos para para compor o número da agência (ex: 067-8):");
		this.messagesList.add("Passo 3: Digite o seu nome:");
		this.messagesList.add("Passo 4: Digite o saldo a ser depositado (ex:237.48):");
	}
	//---
	public String message(ENUM_MESSAGE msg) {
		String str="";
		//---
		switch(msg) {
			case WELCOME:
				str=messagesList.get(0);
				break;
			case STEP_1:
				str=messagesList.get(1);
				break;
			case STEP_2:
				str=messagesList.get(2);
				break;
			case STEP_3:
				str=messagesList.get(3);
				break;
			case STEP_4:
				str=messagesList.get(4);
				break;
		}
		//---
		return str;
	}
	//---
	Scanner scanner=new Scanner(System.in);
	//--- Methods
	public void closeScanner() {
		scanner.close();
	}
	//---
	public void promptInicial() {
		//--- prompt inicial
		System.out.println(message(ENUM_MESSAGE.WELCOME));
	}
	//---
	public void inputNumeroDaConta() {
		//--- passo 1: número da conta
		System.out.println(message(ENUM_MESSAGE.STEP_1));
		//---
		numero=WRONG_VALUE;
		while(numero==WRONG_VALUE) {
			if(scanner.hasNextInt()) {
				numero=scanner.nextInt();
				scanner.nextLine(); //erase new line character left by nextInt()
			}
			//--- check value
			if(numero==WRONG_VALUE) {
				System.out.println("Número inválido! Tente outra vez:");
				scanner.nextLine(); //erase the wrong line
			}
			//---
		}
	}
	//---
	public void inputAgencia() {
		//--- passo 2: número da agência
		System.out.println(message(ENUM_MESSAGE.STEP_2));
		agencia=scanner.nextLine();
	}
	//---
	public void inputNome() {
		//--- passo 3: nome do cliente
		System.out.println(message(ENUM_MESSAGE.STEP_3));
		nomeDoCliente=scanner.nextLine();
	}
	//---
	public void inputSaldo() {
		System.out.println(message(ENUM_MESSAGE.STEP_4));
		saldo=(double)WRONG_VALUE;
		//---
		while(saldo==WRONG_VALUE) {
			String input=scanner.nextLine().replace(",",".");
			try {
				saldo=Double.parseDouble(input);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	//---
	public void mensagemFinal() {
		System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d,"+
						  " e seu saldo de R$ %.2f já está disponível para saque.",nomeDoCliente,agencia,numero,saldo);
	}
	//---
}
