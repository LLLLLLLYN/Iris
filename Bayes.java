import java.math.BigDecimal;
import java.util.List;

public class Bayes {
    static double EA1;
    static double EA2;
    static double EA3;
    static double EA4;
    static double VA1;
    static double VA2;
    static double VA3;
    static double VA4;

    static double EB1;
    static double EB2;
    static double EB3;
    static double EB4;
    static double VB1;
    static double VB2;
    static double VB3;
    static double VB4;

    static double EC1;
    static double EC2;
    static double EC3;
    static double EC4;
    static double VC1;
    static double VC2;
    static double VC3;
    static double VC4;


    public void CalMV(List<Iris> trainingDataSet) {
        double sumSetosaPetalLength = 0;
        double sumSetosaPetalWidth = 0;
        double sumSetosaSepalLength = 0;
        double sumSetosaSepalWidth = 0;

        double SPL[] = new double[45];
        double SPW[] = new double[45];
        double SSL[] = new double[45];
        double SSW[] = new double[45];

        for (int i = 0; i < 45; i++) {
            SPL[i] = Double.parseDouble(trainingDataSet.get(i).getPetalLength());
            SPW[i] = Double.parseDouble(trainingDataSet.get(i).getPetalWidth());
            SSL[i] = Double.parseDouble(trainingDataSet.get(i).getSepalLength());
            SSW[i] = Double.parseDouble(trainingDataSet.get(i).getSepalWidth());
        }
        EA1 = getE(SPL);
        EA2 = getE(SPW);
        EA3 = getE(SSL);
        EA4 = getE(SSW);
        VA1 = Variance(SPL);
        VA2 = Variance(SPW);
        VA3 = Variance(SSL);
        VA4 = Variance(SSW);
        for (int i = 45; i < 90; i++) {
            SPL[i - 45] = Double.parseDouble(trainingDataSet.get(i).getPetalLength());
            SPW[i - 45] = Double.parseDouble(trainingDataSet.get(i).getPetalWidth());
            SSL[i - 45] = Double.parseDouble(trainingDataSet.get(i).getSepalLength());
            SSW[i - 45] = Double.parseDouble(trainingDataSet.get(i).getSepalWidth());
        }
        EB1 = getE(SPL);
        EB2 = getE(SPW);
        EB3 = getE(SSL);
        EB4 = getE(SSW);
        VB1 = Variance(SPL);
        VB2 = Variance(SPW);
        VB3 = Variance(SSL);
        VB4 = Variance(SSW);
        for (int i = 90; i < 135; i++) {
            SPL[i - 90] = Double.parseDouble(trainingDataSet.get(i).getPetalLength());
            SPW[i - 90] = Double.parseDouble(trainingDataSet.get(i).getPetalWidth());
            SSL[i - 90] = Double.parseDouble(trainingDataSet.get(i).getSepalLength());
            SSW[i - 90] = Double.parseDouble(trainingDataSet.get(i).getSepalWidth());
        }
        EC1 = getE(SPL);
        EC2 = getE(SPW);
        EC3 = getE(SSL);
        EC4 = getE(SSW);
        VC1 = Variance(SPL);
        VC2 = Variance(SPW);
        VC3 = Variance(SSL);
        VC4 = Variance(SSW);

    }

    public double getE(double[] x) {
        int m = x.length;
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        double dAve = sum / m;
        return dAve;
    }

    public double Variance(double[] x) {
        int m = x.length;
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        double dAve = sum / m;//求平均值
        double dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x[i] - dAve) * (x[i] - dAve);
        }
        return dVar / m;
    }

    public double calculate_P_xi_c(double E1, double E2, double E3, double E4, double V1, double V2, double V3, double V4, Iris iris) {
        // (1 / math.sqrt(2 * math.pi)) * math.exp(-(float(line_data[2]) - u_x3) ** 2 / (2 * variance_x3))
        double v = Math.pow(-(Double.parseDouble(iris.getSepalLength()) - E3), 1 / V3);
        double NUM1 = 1.0 / Math.sqrt(2 * Math.PI * V1) * Math.exp((-Math.pow((Double.parseDouble(iris.getPetalLength()) - E1), 2)) / (2 * V1));
        double NUM2 = 1.0 / Math.sqrt(2 * Math.PI * V2) * Math.exp((-Math.pow((Double.parseDouble(iris.getPetalWidth()) - E2), 2)) / (2 * V2));
        double NUM3 = 1.0 / Math.sqrt(2 * Math.PI * V3) * Math.exp((-Math.pow((Double.parseDouble(iris.getSepalLength()) - E3), 2)) / (2 * V3));
        double NUM4 = 1.0 / Math.sqrt(2 * Math.PI * V4) * Math.exp((-Math.pow((Double.parseDouble(iris.getSepalWidth()) - E4), 2)) / (2 * V4));

        return NUM1 * NUM2 * NUM3 * NUM4;
    }

    public String getResult(Iris iris) {
        double a = calculate_P_xi_c(EA1, EA2, EA3, EA4, VA1, VA2, VA3, VA4, iris);
        double b = calculate_P_xi_c(EB1, EB2, EB3, EB4, VB1, VB2, VB3, VB4, iris);
        double c = calculate_P_xi_c(EC1, EC2, EC3, EC4, VC1, VC2, VC3, VC4, iris);
        double tmp = Math.max(Math.max(a, b), c);
        if (tmp == a) {
            return "Iris setosa";
        } else if (tmp == b) {
            return "Iris versicolor";
        } else {
            return "Iris virginica";
        }
    }
}
