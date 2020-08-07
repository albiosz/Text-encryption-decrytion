import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ProcessCommand {
    private String[] args;
    private int key;
    private String chosenMode;
    private String toProcess;
    private String chosenAlgo;

    public ProcessCommand(String[] args) {
        this.args = args;
        this.key = 0;
        this.chosenMode = "enc";
        this.toProcess = "";
        this.chosenAlgo = "Unicode";
    }

    public int getKey() {
        return key;
    }

    public String getChosenMode() {
        return chosenMode;
    }

    public String getToProcess() {
        return toProcess;
    }

    public String getChosenAlgo() {
        return chosenAlgo;
    }

    public void readKey() {
        int keyIdx = Arrays.asList(args).indexOf("-key");
        if (keyIdx != -1) {
            key = Integer.parseInt(args[keyIdx + 1]);
        }
    }

    public void readMode() {
        int chosenModeIdx = Arrays.asList(args).indexOf("-mode");
        if (chosenModeIdx != -1) {
            chosenMode = args[chosenModeIdx + 1];
        }
    }

    public boolean readToProcess() {
        int toProcessIdx = Arrays.asList(args).indexOf("-data");
        if (toProcessIdx != -1) {
            toProcess = args[toProcessIdx + 1];
            return true;
        } else {
            return false;
        }
    }

    public void readFileToProcess() {
        int toProcessFileIdx = Arrays.asList(args).indexOf("-in");
        File file = new File("./TextFiles/" + args[toProcessFileIdx + 1]);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                toProcess += scan.nextLine();
                toProcess += "\n";
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public boolean outToFile(String ans) {
        int outFileIdx = Arrays.asList(args).indexOf("-out");
        if (outFileIdx != -1) {
            File fileOut = new File("./TextFiles/" + args[outFileIdx + 1]);
            try (FileWriter writeOut = new FileWriter(fileOut)) {
                writeOut.write(ans);
            } catch (java.io.IOException e) {
                System.out.println("Error");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public void readAlgo() {
        int algoIdx = Arrays.asList(args).indexOf("-alg");
        if (algoIdx != -1) {
            switch (args[algoIdx + 1]) {
                case "unicode":
                    chosenAlgo = "Unicode";
                    break;
                default:
                    chosenAlgo = "Shift";
            }
        } else {
            chosenAlgo = "Shift";
        }
    }
}
