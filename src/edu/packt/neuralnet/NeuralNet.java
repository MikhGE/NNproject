package edu.packt.neuralnet;

import edu.packt.neuralnet.math.IActivationFunction;

import java.util.ArrayList;

public class NeuralNet {
    private     InputLayer                  inputLayer;
    private     ArrayList<HiddenLayer>      hiddenLayer;
    private     OutputLayer                 outputLayer;
    private     int                         numberOfHiddenLayers;
    private     int                         numberOfInputs;
    private     int                         numberOfOutputs;
    private     ArrayList<Double>           input;
    private     ArrayList<Double>           output;

    public NeuralNet(int numberOfInputs, int numberOfOutputs, int[] numberOfHiddenNeurons, IActivationFunction[] hiddenAcFnc, IActivationFunction outputAcFnc) {
        this.numberOfHiddenLayers    = numberOfHiddenNeurons.length;
        this.numberOfInputs          = numberOfInputs;
        this.numberOfOutputs         = numberOfOutputs;
        if (this.numberOfHiddenLayers == hiddenAcFnc.length) {
            input       = new ArrayList<>(this.numberOfInputs);
            inputLayer  = new InputLayer(this.numberOfInputs);
            if (this.numberOfHiddenLayers > 0) {
                this.hiddenLayer = new ArrayList<>(numberOfHiddenLayers);
            }
            for (int i = 0; i < this.numberOfHiddenLayers; i++) {
                if (i == 0) {
                    try {
                        hiddenLayer.set(i, new HiddenLayer(numberOfHiddenNeurons[i],
                                hiddenAcFnc[i],
                                inputLayer.getNumberOfNeuronsInLayer()));
                    } catch (IndexOutOfBoundsException iobe) {
                        hiddenLayer.add(new HiddenLayer(numberOfHiddenNeurons[i],
                                hiddenAcFnc[i],
                                inputLayer.getNumberOfNeuronsInLayer()));
                    }
                    inputLayer.setNextLayer(hiddenLayer.get(i));
                } else {
                    try {
                        hiddenLayer.set(i, new HiddenLayer(numberOfHiddenNeurons[i],
                                hiddenAcFnc[i], hiddenLayer.get(i - 1)
                                .getNumberOfNeuronsInLayer()
                        ));
                    } catch (IndexOutOfBoundsException iobe) {
                        hiddenLayer.add(new HiddenLayer(numberOfHiddenNeurons[i],
                                hiddenAcFnc[i], hiddenLayer.get(i - 1)
                                .getNumberOfNeuronsInLayer()
                        ));
                    }
                    hiddenLayer.get(i - 1).setNextLayer(hiddenLayer.get(i));
                }
            }
            if (numberOfHiddenLayers > 0) {
                outputLayer = new OutputLayer(this.numberOfOutputs, outputAcFnc,
                        hiddenLayer.get(numberOfHiddenLayers - 1)
                                .getNumberOfNeuronsInLayer()
                );
                hiddenLayer.get(numberOfHiddenLayers - 1).setNextLayer(outputLayer);
            } else {
                outputLayer = new OutputLayer(this.numberOfInputs, outputAcFnc,
                        this.numberOfOutputs);
                inputLayer.setNextLayer(outputLayer);
            }
        }

    }
}
