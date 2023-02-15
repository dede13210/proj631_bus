import reseaux_bus.Parser;



public class Main {
    public static void main(String[] args) {
        Parser parser= new Parser();
        parser.parseDirection();
        parser.parseStop();


        //test:
        parser.dysplayLine();
        System.out.println(parser.getStopLine1());
        System.out.println(parser.getStopLine2());

    }
}