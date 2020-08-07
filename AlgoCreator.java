public class AlgoCreator extends AlgoFactory{
    @Override
    Algorithm returnAlgo(String name) {
        switch (name) {
            case "Unicode":
                return new UnicodeAlgorithm();
            case "Shift":
                return new ShiftAlgorithm();
            default:
                return null;
        }
    }
}
