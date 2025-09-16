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
					creeCompte(); // compte controller
					break;
				case 2:
					effectuerVersement(); // operation controller
					break;
				case 3:
					effectuerRetrait(); // operation controller
					break;
				case 4:
					effectuerVirement(); // operation controller
					break;
				case 5:
					consulterSolde(); // compte controller
					break;
				case 6:
					consulerOperations(); // operation controller
					break;
				case 0:
					System.out.println("Au revoir");
					break;
				default:
					System.out.println("Choix invalide !");
			}
		} while( choice != 0);
	}
	
	private void WelcomeMenu() {
        System.out.println("\n=== Banque Console ===");
        System.out.println("1. Créer un compte (courant/épargne)");
        System.out.println("2. Effectuer un versement");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Effectuer un virement");
        System.out.println("5. Consulter le solde");
        System.out.println("6. Consulter la liste des opérations");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
	}
	
	private void creeCompte() {
		System.out.print("Code du Compte : "); // validation aprés
		String code = scanner.nextLine();
		System.out.print("Type (courant/epargne) : ");
		String type = scanner.nextLine();
		System.out.print("Solde initial : ");
		double solde = scanner.nextDouble();
		// Call CompteController to Create the Account
	}
	
	private void effectuerVersement() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		System.out.print("Montant : ");
		double motant = scanner.nextDouble();
		scanner.nextLine();
		// Call controller to handle Versement(depot) 
	}
	
	private void effectuerRetrait() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		System.out.print("Montant : ");
		double motant = scanner.nextDouble();
		scanner.nextLine();
		// Call controller to handle retrait
	}
	
	private void effectuerVirement() {
		System.out.print("Compte source : ");
		String codesource = scanner.nextLine();
		System.out.print("Compte destination : ");
		String codeDest = scanner.nextLine();
		System.out.print("Montant : ");
		double montant = scanner.nextDouble();
		scanner.nextLine();
		// Call Virement Controller
	}
	
	private void consulterSolde() {
		System.out.print("Code du compte : ");
		String code = scanner.nextLine();
		// call comptecontroller.consulter solde & return data in double variable
		System.out.println("Solde du compte "); // concatinate it with code & solde
	}
	
	private void consulerOperations() {
		System.out.println("Code du compte : ");
		String code = scanner.nextLine();
		// Call compteController.consulerOperations with code & return List of Operation 
	}
}