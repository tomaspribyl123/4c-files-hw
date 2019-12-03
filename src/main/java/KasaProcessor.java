import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class KasaProcessor {

    public void loadDiscountedItems() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("kasa-items.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader reader = new FileReader(file)) {
            KasaItem[] items = objectMapper.readValue(reader, KasaItem[].class);
            for(KasaItem m : items){
                if(m.isDiscounted()){
                    System.out.println(m.getItemName());
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFromLowest() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("kasa-items.json").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try (Reader reader = new FileReader(file)) {
            KasaItem[] items = objectMapper.readValue(reader, KasaItem[].class);
            for(int i = items.length; i<50;i++){
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
