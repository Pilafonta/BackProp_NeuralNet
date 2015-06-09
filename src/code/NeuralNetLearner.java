/**
 * @author Peter LaFontaine 
 * date: 2/20/15
 * 
 */

import java.io.FileNotFoundException;
import java.util.Random;

public class NeuralNetLearner {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int[] layers = { 6, 2, 1 }; // three layers
        NeuralNet net = new NeuralNet(layers);
        net.connectTest();

        double[][] inputvs = { { 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 0, 1 }, { 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 1 } };

        double[][] outputvs = { { 0 }, { 0 }, { 1 }, { 1 }, { 1 }, { 0 },
                { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 0 }, { 0 }, { 0 } };

        for (int n = 0; n < 300; ++n) {
            net.train(inputvs, outputvs, 1);
        }

        net.errorrate(inputvs, outputvs);
        System.out.println("============================");

        int[] layers2 = { 2, 2 }; // two layers
        NeuralNet net2 = new NeuralNet(layers2);
        net2.connectAll();

        double[][] inputvs2 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
        double[][] outputvs2 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 0, 1 } };

        for (int n = 0; n < 100; ++n) {
            net2.train(inputvs2, outputvs2, 1);
        }
        
        net2.errorrate(inputvs2, outputvs2);
        //System.out.println("============================");
        System.out.println("=======CreditTraining=======");
        DataProcessor data = new DataProcessor("crx.data.training",0);
        int[] layers3 = { 15, 30, 1 }; // two layers
        NeuralNet net3 = new NeuralNet(layers3);
        net3.connectAll();
        
        double[][] inputvs3 = data.m_inputvs;
        double[][] outputvs3 = data.m_outputvs;

        for (int n = 0; n < 300; ++n) {
            net3.train(inputvs3, outputvs3, 3);

            double error = net3.error(inputvs3, outputvs3);
           // System.out.println("error is " + error);
        }
        
        net3.errorrate(inputvs3, outputvs3);
        //System.out.println("============================");
        System.out.println("========CreditTest==========");
        data = new DataProcessor("crx.data.testing",0);
        net3.connectAll();
        inputvs3 = data.m_inputvs;
        outputvs3 = data.m_outputvs;

        System.out.print("Credit Approval Testing Net ");
        net3.errorrate(inputvs3, outputvs3);

        System.out.println("============================");

        System.out.println("=======LensTraining=======");
        DataProcessor lensData = new DataProcessor("lenses.training",1);
        int[] lenslayers3 = { 4, 30, 1 }; // two layers
        NeuralNet lensNet3 = new NeuralNet(lenslayers3);
        lensNet3.connectAll();
        
        double[][] inputvss3 = lensData.m_inputvs;
        double[][] outputvss3 = lensData.m_outputvs;

        for (int n = 0; n < 300; ++n) {
            lensNet3.train(inputvss3, outputvss3, 3);

            double lensError = lensNet3.error(inputvss3, outputvss3);
            //System.out.println("error is " + lensError);
        }
        
        net3.errorrate(inputvs3, outputvs3);
        //System.out.println("============================");
        System.out.println("========LensTest==========");
        lensData = new DataProcessor("lenses.testing",1);
        lensNet3.connectAll();
        inputvss3 = lensData.m_inputvs;
        outputvss3 = lensData.m_outputvs;

        System.out.print("Credit Approval Testing Net ");
        lensNet3.lensErrorRate(inputvss3, outputvss3);

        System.out.println("============================");

        System.out.println("=======BubilTraining=======");
        DataProcessor bubilData = new DataProcessor("BUBIL.training",1);
        int[] bubilLayers3 = { 4, 30, 1 }; // two layers
        NeuralNet bubilNet3 = new NeuralNet(bubilLayers3);
        bubilNet3.connectAll();
        
        double[][] inputvss4 = bubilData.m_inputvs;
        double[][] outputvss4 = bubilData.m_outputvs;

        for (int n = 0; n < 300; ++n) {
            bubilNet3.train(inputvss4, outputvss4, 1);

            double lensError = bubilNet3.error(inputvss4, outputvss4);
            //System.out.println("error is " + lensError);
        }
        
        net3.errorrate(inputvs3, outputvs3);
        //System.out.println("============================");
        System.out.println("========LensTest==========");
        bubilData = new DataProcessor("BUBIL.testing",1);
        bubilNet3.connectAll();
        inputvss4 = bubilData.m_inputvs;
        outputvss4 = bubilData.m_outputvs;

        System.out.print("Credit Approval Testing Net ");
        bubilNet3.lensErrorRate(inputvss4, outputvss4);

        System.out.println("============================");
        
        return;
    }

}