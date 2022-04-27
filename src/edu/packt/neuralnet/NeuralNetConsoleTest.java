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
        System.out.println("Создание нейронной сети...");
        NeuralNet nn = new NeuralNet(numberOfInputs, numberOfOutputs, numberOfHiddenNeurons, hiddenAcFnc, outputAcFnc);
        System.out.println("Нейронная сеть создана!");
        double [] neuralInput = { 1.5 , 0.5 };

        double [] neuralOutput;
        nn.setInputs(neuralInput);
        nn.calc();
        neuralOutput=nn.getOutputs();

        neuralInput[0] = 1.0;
        neuralInput[1] = 2.1;

        nn.setInputs(neuralInput);
        nn.calc();
        neuralOutput=nn.getOutputs();
    }
}
