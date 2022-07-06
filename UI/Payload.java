package UI;

import Programs.IProgram;

public class Payload {
    public IProgram program;
    public String text;
    public Integer shift;

    public Payload(IProgram program, String text, Integer shift) {
        this.program = program;
        this.text = text;
        this.shift = shift;
    }
}
