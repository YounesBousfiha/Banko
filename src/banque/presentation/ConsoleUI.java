package banque.presentation;

import java.util.Scanner;

import banque.presentation.controller.CompteController;
import banque.presentation.controller.OperationController;
public class ConsoleUI {
	
	private CompteController comptecontroller;
	private OperationController operationcontroller;
	private Scanner scanner = new Scanner(System.in);
	
	
	public ConsoleUI(CompteController comptecontroller, OperationController operationcontroller) {
		this.comptecontroller = comptecontroller;
		this.operationcontroller = operationcontroller;
	}
	
	public void start() {
		int choice;
		do {
			WelcomeMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				case 1:
					creeCompte();
					break;
				case 2:
					effectuerVersement();
					break;
				case 3:
					effectuerVirement();
					break;
				case 4:
					consulterSolde();
					break;
				case 5:
					consulerOperations();
					break;
				case 0:
					System.out.println("Au revoir");
					break;
				default:
					System.out.println("Choix invalide !");
			}
		} while( choice != 0);
	}
	
	private void WelcomeMenu() {}
	private void creeCompte() {}
	private void effectuerVersement() {}
	private void effectuerVirement() {}
	private void consulterSolde() {}
	private void consulerOperations() {}
}