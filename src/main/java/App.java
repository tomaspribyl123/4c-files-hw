import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
    private static int pocatecniCena = 0;
    private static int pocetProduktu = 0;

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("")) { //skolni json path 

            Object jsonObject = parser.parse(reader);

            JSONArray productList = (JSONArray) jsonObject;

            productList.forEach(emp -> parseDiscountedObjects((JSONObject) emp));
           // productList.forEach(emp -> parseCelkovaCenaObjects((JSONObject) emp));
           // productList.forEach(emp -> parsePriceDifference((JSONObject) emp));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static void parseDiscountedObjects(JSONObject product) {
        JSONObject productObject = product;
        Boolean discount = (Boolean) productObject.get("discounted");
        String itemName = (String) productObject.get("itemName");


        if (discount == true) {
            int pocet = pocetProduktu++;
            System.out.println(itemName);
            System.out.println(pocet + 1);
        }
    }


    private static void parseCelkovaCenaObjects(JSONObject product) {
        JSONObject productObject = product;

        String originalPrice = (String) productObject.get("originalPrice");
        String currentPrice = (String) productObject.get("currentPrice");

        int result = Integer.parseInt(pocatecniCena + currentPrice);
        pocatecniCena = result;
        if(originalPrice == null ){
            result = Integer.parseInt(originalPrice) + result;
        }else if(originalPrice != null){
            result = Integer.parseInt(currentPrice) + result;
        }


        System.out.println("Celková cena produktů je: " + result + " Kč. ");


    }

    private static void parsePriceDifference(JSONObject product) {
        JSONObject productObject = product;

        String price2 = (String) productObject.get("originalPrice");
        int originalPrice = Integer.parseInt(price2);

        String price1 = (String) productObject.get("currentPrice");
        int currentPrice = Integer.parseInt(price1);

        String itemName = (String) productObject.get("itemName");

        if (originalPrice != 0) {
            int rozdil = originalPrice - currentPrice;

        }

    }

}
