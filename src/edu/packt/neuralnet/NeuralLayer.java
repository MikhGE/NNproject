package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

import java.util.ArrayList;

public abstract class NeuralLayer {
    protected   int                 numberOfNeuronsInLayer;
    private     ArrayList<Neuron>   neuron;
    protected IActivationFunction activationFnc;
    protected   NeuralLayer         previousLayer;
    protected   NeuralLayer         nextLayer;
    protected   ArrayList<Double>   input;
    protected   ArrayList<Double>   output;
    protected   int                 numberOfInputs;

    protected void init() {
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            try {
                neuron.get(i).setActivationFunction(activationFnc);
                neuron.get(i).init();
            } catch (IndexOutOfBoundsException iobe) {
                neuron.add(new Neuron(numberOfInputs, activationFnc));
                neuron.get(i).init();
            }
        }
    }

    protected void calc() {
        for (int i = 0; i < numberOfNeuronsInLayer; i++) {
            neuron.get(i).setInputs(this.input);
            neuron.get(i).calc();
            try {
                output.set(i, neuron.get(i).getOutput());
            } catch (IndexOutOfBoundsException iobe) {
                output.add(neuron.get(i).getOutput());
            }
        }
    }
}
