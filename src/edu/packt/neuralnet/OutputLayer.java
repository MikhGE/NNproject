package edu.packt.neuralnet;

public class OutputLayer extends NeuralLayer {
    public OutputLayer(int numberOfNeurons, IActivationFunction iaf, int numberOfInputs){
        this.numberOfNeuronsInLayer = numberOfNeurons;
        this.activationFnc          = iaf;
        this.numberOfInputs         = numberOfInputs;
    }
}
