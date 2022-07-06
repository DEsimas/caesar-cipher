package Programs;

public class Coder implements IProgram{
    private String encrypted;
    private String string;
    private Integer shift;

    public Coder() {
        encrypted = null;
        string = null;
        shift = null;
    }
    
    public void setString(String string) {
        this.string = string;
    }

    public void setShift(Integer shift) {
        if(shift < 0) this.shift = 26 + (shift % 26);
        else this.shift = shift % 26;
    }

    public String getString() {
        if(encrypted == null) throw new Error("String is not encrypted");
        return encrypted;
    }

    public void execute() {
        validate();
        encrypted = "";
        char[] symbols = string.toCharArray();
        for(char ch : symbols) {
            char shifted = (char)(ch + shift);
            if(ch >= 97 && ch <= 122) {
                if(shifted > 122) shifted -= 26;
                if(shifted < 97) shifted += 26;
                encrypted += shifted;
            } else if (ch >= 65 && ch <= 90) {
                if(shifted > 90) shifted -= 26;
                if(shifted < 65) shifted += 26;
                encrypted += shifted;
            } else
                encrypted += ch;
        }
    }

    private void validate() {
        if(string == null) throw new Error("String is not set");
        if(shift == null) throw new Error("Shift is not set");
    }
}
