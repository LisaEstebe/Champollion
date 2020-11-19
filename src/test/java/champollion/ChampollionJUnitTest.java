package champollion;

import static champollion.TypeIntervention.TD;
import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testHeuresPrevues() {
            //10CM, 10h TD, 10TP pour UML
            untel.ajouteEnseignement(uml, 10, 10, 10);
            untel.ajouteEnseignement(java, 5, 5, 5);
            
            assertEquals(49, untel.heuresPrevues(),
                    "L'enseignant doit avoir 49 heures prévues");
            
        }
        
        @Test
        public void testHeuresPlanifiees(){
            Salle s = new Salle("Amphi", 50);
            Date d = new Date(19/11/2020);
            
            Intervention i1 = new Intervention(s, uml, d, 2, TypeIntervention.TD);
            untel.ajouteIntervention(i1);
            
           assertEquals(2, untel.heuresPlanifiees());
            
            Intervention i2 = new Intervention(s, java, d, 2, TypeIntervention.CM);
            untel.ajouteIntervention(i2);
            
            assertEquals(5, untel.heuresPlanifiees());  
            
            Intervention i3 = new Intervention(s, java, d, 3, TypeIntervention.TP);
            untel.ajouteIntervention(i3);
            
            assertEquals(7, untel.heuresPlanifiees()); 
            
            Intervention i4 = new Intervention(s, java, d, 3, null);
            untel.ajouteIntervention(i4);
            
            assertEquals(10, untel.heuresPlanifiees());
        }
	
        @Test
        public void testSousService(){
            Salle s = new Salle("Amphi", 50);
            Date d = new Date(19/11/2020);
            
            untel.ajouteEnseignement(uml, 10, 10, 10);
            
            Intervention i1 = new Intervention(s, uml, d, 10, TypeIntervention.TD);
            untel.ajouteIntervention(i1);
            
            Intervention i2 = new Intervention(s, uml, d, 10, TypeIntervention.TP);
            untel.ajouteIntervention(i2);
            
            assertEquals(true, untel.enSousService(), 
                    "L'enseignant doit être en sous servise");
        }
}
