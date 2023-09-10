public class Block {
        double x, y;  // Pozice bloku
        double velocityX, velocityY;  // Rychlost bloku
        double mass;  // Hmotnost bloku

        public Block(double x, double y, double mass) {
            this.x = x;
            this.y = y;
            this.mass = mass;
            this.velocityX = 0;
            this.velocityY = 0;
        }
    }