import java.util.LinkedList;

/**
 * 
 */

/**
 * @author moreau
 * une classe Manager
 */
public class Manager extends Employe {
	/**
	 * liste des personnes sous les ordres du Manager
	 */
	private LinkedList<Employe> employes;
	
	/**
	 * suprieur hirarchique
	 * 
	 * pour le patron de l'entreprise, le suprieur vaudra null
	 */
	private Manager manager;
	
	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}

	/* (non-Javadoc)
	 * @see Employe#toString()
	 */
	@Override
	public String toString() {
		return "MANAGER "+super.toString();
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/**
	 * ajoute un employ ˆ la liste des gens sous les ordres du 
	 * manager
	 * @param nouveau l'employ ˆ ajouter
	 */
	public void ajouteEmploye(Employe nouveau) {
		// ajout ˆ la liste des nouveaux
		this.employes.add(nouveau);
		
		// on vrifie si nouveau est lui-mme un Manager
		if (nouveau instanceof Manager) {
			// sous-classement
			Manager m1 = (Manager) nouveau;
			m1.setManager(this);
		}
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param anneeNaissance
	 * @param numero
	 * @param entreprise
	 */
	public Manager(String nom, String prenom, boolean sexe, int anneeNaissance,
			int numero, Entreprise entreprise) {
		super(nom, prenom, sexe, anneeNaissance, numero, entreprise);
		this.employes = new LinkedList<Employe>();
	}

}
