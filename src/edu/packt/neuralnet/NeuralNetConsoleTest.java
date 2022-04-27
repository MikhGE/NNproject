package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;
import edu.packt.neuralnet.math.Linear;
import edu.packt.neuralnet.math.RandomNumberGenerator;
import edu.packt.neuralnet.math.Sigmoid;

public class NeuralNetConsoleTest {
    public static void main(String[] args) {
        RandomNumberGenerator.seed  = 0;
        int numberOfInputs          = 2;
        int numberOfOutputs         = 1;
        int[] numberOfHiddenNeurons = {3};
        IActivationFunction[] hiddenAcFnc = {new Sigmoid(1.0)};
        Linear outputAcFnc = new Linear(1.0);
        System.out.println("Creating Neural Network...");
        NeuralNet nn = new NeuralNet(numberOfInputs, numberOfOutputs, numberOfHiddenNeurons, hiddenAcFnc, outputAcFnc);
        System.out.println("Neural Network created!");
        nn.print();
    }
}
