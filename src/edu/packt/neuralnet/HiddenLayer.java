package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

public class HiddenLayer extends NeuralLayer{
    public HiddenLayer(int numberOfNeurons, IActivationFunction iaf, int numberOfInputs){
        this.numberOfNeuronsInLayer = numberOfNeurons;
        this.activationFnc          = iaf;
        this.numberOfInputs         = numberOfInputs;
    }
}
