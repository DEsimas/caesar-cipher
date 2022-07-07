import Programs.Dictionary;
import Programs.DictionaryDecoder;
import UI.Payload;
import UI.UI;

public class CaesarCipher {
    public static void main(String[] args) {
        Dictionary.read("Dictionary");
        Payload data;
        while(true) {
            data = UI.getPayload();

            if(data == null) {
                System.out.println("Wrong program\n");
                continue;
            }

            if(data.program == null) return;

            if(data.program.getClass() != new DictionaryDecoder().getClass() && data.shift == null) {
                System.out.println("Wrong shift\n");
                continue;
            }

            data.program.setString(data.text);
            data.program.setShift(data.shift);
            data.program.execute();
            
            System.out.println("\nResult:");
            System.out.println(data.program.getString() + '\n');
        }
    }
}
