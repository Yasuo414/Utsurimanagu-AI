public class App {
    public static void main(String[] args) {
        // Inicializace bloků
        Block block1 = new Block(0, 0, 1.0);
        Block block2 = new Block(10, 0, 2.0);

        // Simulační časový krok (v sekundách)
        double timeStep = 0.01;

        // Hlavní simulační smyčka
        for (int i = 0; i < 100; i++) { // Simulace po dobu 1 sekundy
            // Komunikace s modelem AI a volba akce
            int currentState = 0; // Předpokládejme, že AI začíná ve stavu 0
            AI ai = new AI(1, 4); // Předpokládejme, že existuje 1 stav a 4 možné akce
            int action = ai.communicate(currentState);

            // Výpočet síly působící mezi bloky (jednoduchý model gravitace)
            double distance = Math.sqrt(Math.pow(block2.x - block1.x, 2) + Math.pow(block2.y - block1.y, 2));
            double force = (block1.mass * block2.mass) / Math.pow(distance, 2);

            // Výpočet zrychlení
            double acceleration1 = force / block1.mass;
            double acceleration2 = force / block2.mass;

            // Výpočet rychlosti
            block1.velocityX += acceleration1 * timeStep;
            block1.velocityY += acceleration1 * timeStep;

            block2.velocityX -= acceleration2 * timeStep;
            block2.velocityY -= acceleration2 * timeStep;

            // Výpočet nové pozice
            block1.x += block1.velocityX * timeStep;
            block1.y += block1.velocityY * timeStep;

            block2.x += block2.velocityX * timeStep;
            block2.y += block2.velocityY * timeStep;

            // Pauza pro simulaci časového kroku
            try {
                Thread.sleep((long) (timeStep * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
