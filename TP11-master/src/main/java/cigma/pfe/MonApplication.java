package cigma.pfe;

import cigma.pfe.models.CarteFidelio;
import cigma.pfe.models.Facture;
import cigma.pfe.models.Promotion;
import cigma.pfe.presentation.ClientController;
import cigma.pfe.models.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class MonApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController) context.getBean("controller");
        Client client = new Client("Anass");

        List<Facture> factures=Arrays.asList(
          new Facture(1500,"facture1",client),new Facture(2000,"facture2",client)
        );
        client.setFactures(factures);
        List<Promotion> promotions=Arrays.asList(
                new Promotion("remise 10%"),new Promotion("solde 40%")
        );
        client.setPromotions(promotions);

        CarteFidelio carteFidelio=new CarteFidelio("A254202545");
                carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);

        ctrl.save(client);

        Client client1 = new Client("Omar");
        Client client2 = new Client("Said");
        Client client3 = new Client("Ahmed");

        client1=ctrl.save(client1);
        client2=ctrl.save(client2);
        client3=ctrl.save(client3);

        ctrl.getAll().stream()
                .forEach(i-> System.out.println(i));

        System.out.println(ctrl.getOne(1));

        client1.setName("Hassan");
        ctrl.modify(client1);

        ctrl.remove(2);

        ctrl.getAll().stream()
                .forEach(i-> System.out.println(i));
    }
}
