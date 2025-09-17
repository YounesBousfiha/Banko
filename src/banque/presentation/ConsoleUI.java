package banque.presentation;

import java.util.List;
import java.util.Scanner;

import banque.domain.entity.Operation;
import banque.domain.util.ValidationUtils;
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
		
		if(!(ValidationUtils.CheckValidCode(code))) {
			System.err.println("Invalid Code Format ");
			return;
		}
		
		System.out.print("Type (courant/epargne) : ");
		String type = scanner.nextLine();
		if(ValidationUtils.isValidAccountType(type)) {
			System.err.println("Invalid Account Type");
			return;
		}
		
		System.out.print("Solde initial : ");
		String solde = scanner.nextLine();
		if(ValidationUtils.isDouble(solde)) {
			System.err.println("Invalid Data Type");
			return;
		}
		Double newSolde = Double.parseDouble(solde);
		if(ValidationUtils.isNegative(newSolde)) {
			System.err.println("Cant' Enter negative solde");
			return;
		}
		this.comptecontroller.CreateAccount(code, type, newSolde);
	}
	
	private void effectuerVersement() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		if(!(ValidationUtils.CheckValidCode(code))) {
			System.err.println("Invalid Code Format ");
			return;
		}
		
		System.out.print("Montant : ");
		String montant = scanner.nextLine();
		if(ValidationUtils.isDouble(montant)) {
			System.err.println("Invalid Data Type");
			return;
		}
		
		Double newMontant = Double.parseDouble(montant);
		if(ValidationUtils.isNegative(newMontant)) {
			System.err.println("Cant' Enter negative solde");
			return;
		}
		
		System.out.print("Source : ");
		String source = scanner.nextLine();
		scanner.nextLine();
		this.operationcontroller.makeDepot(code, newMontant, source);
	}
	
	private void effectuerRetrait() {
		System.out.print("Code du Compte : ");
		String code = scanner.nextLine();
		if(!(ValidationUtils.CheckValidCode(code))) {
			System.err.println("Invalid Code Format");
			return;
		}
		System.out.print("Montant : ");
		String montant = scanner.nextLine();
		if(!(ValidationUtils.isDouble(montant))) {
			System.err.println("Invalid Data Type");
			return;
		}
		Double newMontant = Double.parseDouble(montant);
		if(ValidationUtils.isNegative(newMontant)) {
			System.err.println("Cant' Enter negative mountant");
			return;
		}
		System.out.print("Destination : ");
		String dest = scanner.nextLine();
		scanner.nextLine();
		this.operationcontroller.makeRetrait(code, newMontant, dest);
	}
	
	private void effectuerVirement() {
	    System.out.print("Sender Compte  : ");
	    String codesource = scanner.nextLine();
	    if(!ValidationUtils.CheckValidCode(codesource)) {
	        System.err.println("Invalid Sender Code Format");
	        return;
	    }

	    System.out.print("Receiver Compte : ");
	    String codeDest = scanner.nextLine();
	    if(!ValidationUtils.CheckValidCode(codeDest)) {
	        System.err.println("Invalid Receiver Code Format");
	        return;
	    }

	    if(codesource.equals(codeDest)) {
	        System.err.println("Sender and Receiver must be different");
	        return;
	    }

	    System.out.print("Montant : ");
	    String montant = scanner.nextLine();
	    if(!ValidationUtils.isDouble(montant)) {
	        System.err.println("Invalid Data Type for montant");
	        return;
	    }

	    double newMontant = Double.parseDouble(montant);
	    if(ValidationUtils.isNegative(newMontant)) {
	        System.err.println("Can't transfer negative amount");
	        return;
	    }

	    System.out.print("Source : ");
	    String source = scanner.nextLine();

	    System.out.print("Destination : ");
	    String destination = scanner.nextLine();

	    this.operationcontroller.makeViremenet(codesource, codeDest, newMontant, source, destination);
	}
	
	private void CalculerInteret() {
	    System.out.print("Compte Code : ");
	    String code = scanner.nextLine();
	    if(!ValidationUtils.CheckValidCode(code)) {
	        System.err.println("Invalid Code Format");
	        return;
	    }

	    Double interest = this.comptecontroller.calcInterest(code);
	    if(interest == null) {
	        System.err.println("Compte introuvable ou pas d'intérêt applicable");
	        return;
	    }

	    System.out.println("Your Account interest is : " + interest);
	}

	
	private void consulterSolde() {
	    System.out.print("Code du compte : ");
	    String code = scanner.nextLine();
	    if(!ValidationUtils.CheckValidCode(code)) {
	        System.err.println("Invalid Code Format");
	        return;
	    }

	    Double solde = this.comptecontroller.getSolde(code);
	    if(solde == null) {
	        System.err.println("Compte introuvable");
	        return;
	    }

	    System.out.println("Solde du compte : " + solde);
	}

	
	private void consulerOperations() {
	    System.out.print("Code du compte : ");
	    String code = scanner.nextLine();
	    if(!ValidationUtils.CheckValidCode(code)) {
	        System.err.println("Invalid Code Format");
	        return;
	    }

	    List<Operation> operations = this.operationcontroller.getAllOperations(code);
	    if(operations == null || operations.isEmpty()) {
	        System.out.println("Aucune opération trouvée pour ce compte.");
	        return;
	    }

	    operations.forEach(System.out::println);
	}

}