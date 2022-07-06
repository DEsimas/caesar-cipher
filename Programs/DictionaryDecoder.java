package Programs;

public class DictionaryDecoder implements IProgram {
    private Decoder decoder;

    protected String encrypted;
    protected String string;

    public DictionaryDecoder() {
        decoder = new Decoder();
        encrypted = null;
        string = null;
    }

    public void setString(String string) {
        encrypted = string;
    }

    public void setShift(Integer shift) {
        shift = null;
    }

    public String getString() {
        return string;
    }

    public void execute() {
        Integer max = 0;
        for(int i = 0; i < 26; i++) {
            String decryption = decode(i);
            Integer words = countWords(decryption);
            if(words > max) {
                max = words;
                string = decryption;
            }
        }
    }

    private String decode(Integer shift) {
        decoder.setString(encrypted);
        decoder.setShift(shift);
        decoder.execute();
        return decoder.getString();
    }

    private Integer countWords(String string) {
        String[] words = string.split("[^[a-zA-Z]]");

        Integer counter = 0;
        for(String word : words) {
            if(Dictionary.has(word)) counter++;
        }
        return counter;
    }
}
