package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Programs.Coder;
import Programs.Decoder;
import Programs.DictionaryDecoder;
import Programs.IProgram;

public class UI {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static IProgram getProgram()
            throws IOException, ProgramException {
        System.out.println("Select program:\n1.Coder\n2.Decoder\n3.Dictionary Decoder\n4.Exit");

        String program = reader.readLine();

        switch (program) {
            case "1":
                return new Coder();
            case "2":
                return new Decoder();
            case "3":
                return new DictionaryDecoder();
            case "4":
                return null;
            default:
                throw new ProgramException();
        }
    }

    private static String getText()
        throws IOException {
        System.out.println("Enter text:");
        return reader.readLine();
    }

    private static Integer getShift()
        throws IOException {
            System.out.println("Enter shift (for dictionary decoder use NaN):");
            String shift = reader.readLine();
            try {
                return Integer.parseInt(shift);
            } catch (NumberFormatException ex) {
                return null;
            }
        }

    public static Payload getPayload() {
        try {
            IProgram p = getProgram();
            if(p == null) return new Payload(null, null, null);
            return new Payload(p, getText(), getShift());
        } catch(IOException ex) {
            throw new Error("Input error");
        } catch(ProgramException ex) {
            return null;
        }
    }
}
