package Model;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Takes all output print statements and allows them
 * to be printed into the text area
 * @author Keefer Belanger 101152085
 */
public class TextAreaOutputStream extends OutputStream {
    private final JTextArea text_area;

    /**
     * Constructor for the JTextArea output class
     *
     * @param text_area
     */
    public TextAreaOutputStream(JTextArea text_area) {
        this.text_area = text_area;
    }

    public static void directingMessageToTextArea(JTextArea text_area) {
        try {
            PrintStream printStream = new PrintStream(new TextAreaOutputStream(text_area));

            // PrintStream standardOut = System.out;
            // PrintStream standardErr = System.err;

            System.setOut(printStream);
            System.setErr(printStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes the print string from all System.out.print and puts it into the
     * JTextArea
     *
     * @param buffer
     * @param offset
     * @param length
     * @throws IOException
     */
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        // directs print statements to the text area
        text_area.append(new String(buffer, offset, length));

        // scrolls the text area to the end of the print statements
        text_area.setCaretPosition(text_area.getDocument().getLength());
    }

    /**
     * Takes the print string and changes it to be able to be put into the JTextArea
     *
     * @param b
     * @throws IOException
     */
    @Override
    public void write(int b) throws IOException {
        // directs print statements to the text area
        text_area.append(String.valueOf((char) b));

        // scrolls the text area to the end of the print statements
        text_area.setCaretPosition(text_area.getDocument().getLength());
    }
}

