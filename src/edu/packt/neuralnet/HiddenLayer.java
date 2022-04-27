package edu.packt.neuralnet;

public class HiddenLayer extends NeuralLayer{
    public HiddenLayer(int numberOfNeurons, IActivationFunction iaf, int numberOfInputs){
        this.numberOfNeuronsInLayer = numberOfNeurons;
        this.activationFnc          = iaf;
        this.numberOfInputs         = numberOfInputs;
    }
}
