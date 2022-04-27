package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

public class OutputLayer extends NeuralLayer {
    public OutputLayer(int numberOfNeurons, IActivationFunction iaf, int numberOfInputs){
        this.numberOfNeuronsInLayer = numberOfNeurons;
        this.activationFnc          = iaf;
        this.numberOfInputs         = numberOfInputs;
    }
}
