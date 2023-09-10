import java.util.Random;

public class AI {
        // Q-tabulka pro uložení znalostí AI
        private double[][] qTable;

        // Počet akcí (směrů), které může model provádět
        private int numActions;

        // Konstruktor modelu AI
        public AI(int numStates, int numActions) {
            this.qTable = new double[numStates][numActions];
            this.numActions = numActions;
        }

        // Metoda pro komunikaci s modelem AI
        public int communicate(int state) {
            // Vyber akci na základě epsilon-greedy politiky
            double epsilon = 0.1;  // Pravděpodobnost náhodné akce
            if (Math.random() < epsilon) {
                return new Random().nextInt(numActions);  // Náhodná akce
            } else {
                int maxAction = 0;
                for (int i = 1; i < numActions; i++) {
                    if (qTable[state][i] > qTable[state][maxAction]) {
                        maxAction = i;
                    }
                }
                return maxAction;  // Akce s nejvyšší Q-hodnotou
            }
        }

        // Metoda pro trénink modelu AI na základě nových dat
        public void train(int state, int action, double reward, int nextState, double learningRate, double discountFactor) {
            // Aktualizace Q-hodnoty podle Q-learning aktualizace pravidla
            double maxQValue = maxQValue(qTable[nextState]);
            qTable[state][action] = qTable[state][action] + learningRate * (reward + discountFactor * maxQValue - qTable[state][action]);
        }

        // Výpočet maximální Q-hodnoty z pole Q-hodnot
        private double maxQValue(double[] qValues) {
            double maxQValue = qValues[0];
            for (double qValue : qValues) {
                if (qValue > maxQValue) {
                    maxQValue = qValue;
                }
            }
            return maxQValue;
        }
    }