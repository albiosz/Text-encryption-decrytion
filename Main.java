public class Main {
    public static void main(String[] args) {

        // Create object to process arguments given in command line
        ProcessCommand proCom = new ProcessCommand(args.clone());

        // Read if user wants to encrypt or decrypt data
        proCom.readMode();

        // Read by what value we need to change Unicode values of characters in data
        proCom.readKey();

        // If switch -data is active take String from command line as data
        if (!proCom.readToProcess()) {
            // if switch -data is not present or there is not String take data from selected file
            proCom.readFileToProcess();
        }

        // Read which algorithm was chosen (Unicode or Shift)
        proCom.readAlgo();

        // Create factory class which returns chosen classes with selected algorithm
        AlgoFactory algoCreator = new AlgoCreator();

        // Get selected class
        Algorithm algorithm = algoCreator.returnAlgo(proCom.getChosenAlgo());

        String ans;

        // Decryption or encryption is performed according to chosen mode
        if (proCom.getChosenMode().equals("dec")) {
            //Decryption
            ans = algorithm.decrypt(proCom.getToProcess(), proCom.getKey());
        } else {
            // Encryption
            ans = algorithm.encrypt(proCom.getToProcess(), proCom.getKey());
        }

        // If name of file was passed we save output to this file
        if (!proCom.outToFile(ans)) {
            // Otherwise we print out data to the console
            System.out.println(ans);
        }
    }
}
