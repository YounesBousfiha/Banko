package banque.presentation;

import java.util.List;
import java.util.Scanner;

import banque.domain.entity.Operation;
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
					effectuerVersement(); // operation controller
					break;
				case 3:
					effectuerRetrait(); // operation controller
					break;
				case 4:
					effectuerVirement(); // operation controller
					break;
				case 5:
					consulterSolde();
					break;
				case 6:
					consulerOperations(); // operation controller
					break;
				case 7:
					CalculerInteret();
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
        System.out.println("7: Calculate Interest");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
	}
	
	private void creeCompte() {
		System.out.print("Code du Compte (Should Start with CPT-) : ");
		String code = scanner.nextLine();
		System.out.print("Type (courant/epargne) : ");
		String type = scanner.nextLine();
		System.out.print("Solde initial : ");
		double solde = scanner.nextDouble();
		this.comptecontroller.CreateAccount(code, type, solde);
	}
	
	private void effectuerVersement() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		System.out.print("Montant : ");
		double montant = scanner.nextDouble();
		System.out.print("Source : ");
		String source = scanner.nextLine();
		scanner.nextLine();
		this.operationcontroller.makeDepot(code, montant, source);
	}
	
	private void effectuerRetrait() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		System.out.print("Montant : ");
		double montant = scanner.nextDouble();
		System.out.print("Destination : ");
		String dest = scanner.nextLine();
		scanner.nextLine();
		this.operationcontroller.makeRetrait(code, montant, dest);
	}
	
	private void effectuerVirement() {
		System.out.print("Sender Compte  : ");
		String codesource = scanner.nextLine();
		System.out.print("Reiceiver Compte : ");
		String codeDest = scanner.nextLine();
		System.out.print("Montant : ");
		double montant = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Source : ");
		String source = scanner.nextLine();
		System.out.print("Destination : ");
		String destination = scanner.nextLine();
		this.operationcontroller.makeViremenet(codesource, codeDest, montant, source, destination);
	}
	
	private void CalculerInteret() {
		System.out.print("Compte Code : ");
		String code = scanner.nextLine();
		Double interest = this.comptecontroller.calcInterest(code);
		System.out.println("Your Account interest is :  " + interest);
	}
	
	private void consulterSolde() {
		System.out.print("Code du compte : ");
		String code = scanner.nextLine();
		Double solde = this.comptecontroller.getSolde(code);
		System.out.println("Solde du compte : " + solde);
	}
	
	private void consulerOperations() {
		System.out.print("Code du compte : ");
		String code = scanner.nextLine();
		List<Operation> operations = this.operationcontroller.getAllOperations(code);
		
		operations.stream()
        	.forEach(System.out::println);
	}
}