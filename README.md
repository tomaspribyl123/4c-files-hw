# DÚ
## Zpracovat json soubor s resources

*kasa-items.json* - jeden item
```json
{
  "originalPrice": 11753,
  "currentPrice": 9990,
  "discounted": true,
  "img": "https://img.kasa.cz/k-foto/280/5/0/6/product_3338605.jpg",
  "itemId": 1420766,
  "itemUrl": "https://www.kasa.cz/trouba-electrolux-eob3454aox-nerez-ocel/",
  "itemName": "Trouba Electrolux EOB3454AOX nerez/ocel",
  "category": "KASA.cz > Vestavné domácí spotřebiče > Vestavné trouby"
}
```

kasa items obsahuje jednoduchý výčet produktů z jednotlivých kategorií z webu kasa.cz

Vaším úkolem je vytvořit několik metod pracujících s daty v souboru:

- Vytvořte metodu, která vypíše produkty ve slevě a jejich počet
- Vytvořte metodu, která sečte celkovou cenu produktů
- Vytvořte metodu, která vypíše produkty s největší rozdílnou cenou *originalPrice* vs. *currentPrice*
- Vytvořte metodu, která vytvoří z prvních 50. produktů strom kategorií


import Model.Jizdenka;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainFrame extends JFrame {
    private int count = 0;
    private Computer computer;
    public MainFrame(Computer computer){
        this.computer = computer;
        initComponents();
    }
    private void initComponents(){
        final JPanel panel = new JPanel(new MigLayout());
        this.add(panel);
        for(Map.Entry<Integer, Jizdenka>entry : computer.getTicketsMap().entrySet()){
            final Jizdenka jizdenka = entry.getValue();
            final JButton button = new JButton(jizdenka.toString());
            button.putClientProperty("id", entry.getKey());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    actionEvent.getWhen();
                }
            });
            panel.add(button);
        }

        JTextField textField =  new JTextField(String.valueOf(count));
        textField.setSize(80, 40);
        JButton tlacitko = new JButton("Zatlač");

    }
}
