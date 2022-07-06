package Programs;

public class Decoder implements IProgram{
    protected String encrypted;
    protected String string;
    protected Integer shift;

    public Decoder() {
        encrypted = null;
        string = null;
        shift = null;
    }
    
    public void setString(String string) {
        encrypted = string;
    }

    public void setShift(Integer shift) {
        if(shift < 0) this.shift = 26 + (shift % 26);
        else this.shift = shift % 26;
    }

    public String getString() {
        if(string == null) throw new Error("String is not decrypted");
        return string;
    }

    public void execute() {
        validate();
        string = "";
        char[] symbols = encrypted.toCharArray();
        for(char ch : symbols) {
            char shifted = (char)(ch - shift);
            if(ch >= 97 && ch <= 122) {
                if(shifted > 122) shifted -= 26;
                if(shifted < 97) shifted += 26;
                string += shifted;
            } else if (ch >= 65 && ch <= 90) {
                if(shifted > 90) shifted -= 26;
                if(shifted < 65) shifted += 26;
                string += shifted;
            } else
                string += ch;
        }
    }

    protected void validate() {
        if(encrypted == null) throw new Error("String is not set");
        if(shift == null) throw new Error("Shift is not set");
    }
}
