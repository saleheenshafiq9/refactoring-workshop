package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlaintextToHtmlConverter {

    public String toHtml() throws Exception {
        read();
        return basicHtmlEncode();
    }

    private void read() throws IOException {
        Path filePath = Paths.get("sample.txt");
        Files.readAllBytes(filePath);
    }

    private String basicHtmlEncode() {

        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        String characterToConvert = stashNextCharacterAndAdvanceThePointer();
        convertedLine.add(conversion(characterToConvert));
        addANewLine(result, convertedLine);
        return String.join("<br />", result);
    }

    private String stashNextCharacterAndAdvanceThePointer() {
        return null;
    }

    private void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
    }

    private String conversion(String character) {
        return Objects.equals(character, "<") ? "&lt:" : Objects.equals(character, ">") ? "&gt;" : Objects.equals(character, "&") ? "&amp;" : character;
    }
}