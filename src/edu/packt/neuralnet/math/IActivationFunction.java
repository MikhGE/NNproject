package edu.packt.neuralnet.math;

public interface IActivationFunction {
    double calc(double x);
    public enum ActivationFunctionENUM {STEP, LINEAR, SIGMOID, HYPERTAN}
}
