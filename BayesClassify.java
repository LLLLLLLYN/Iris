import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BayesClassify {
    static List<Iris> irisDataSet; //鸢尾花数据集
    static List<Iris> testDataSet;//测试数据集
    static List<Iris> trainingDataSet;//训练数据集

    public BayesClassify() {
        irisDataSet = new ArrayList<Iris>();
        testDataSet = new ArrayList<Iris>();
        trainingDataSet = new ArrayList<Iris>();
    }

    public static void main(String[] args) throws IOException {
        DataReader reader = new DataReader();
        BayesClassify bayes = new BayesClassify();
        trainingDataSet = reader.getIrisData("D:/JavaIDEA/Iris/src/train_data.txt");//读取鸢尾花数据集
        //bayes.prepareTrainingData();//准备训练数据
        Bayes calcu = new Bayes();
        calcu.CalMV(trainingDataSet);//计算均值、方差
        //bayes.prepareTestData();//准备测试数据
        int n = 0; //分类正确的个数
        testDataSet = reader.getIrisData("D:/JavaIDEA/Iris/src/test_data.txt");
        for (Iris i : testDataSet) {
            String type = calcu.getResult(i);//获得分类
            System.out.println("原本类别:" + i.getLable(i.getId()) + "---->最终分类为：" + type);
            if (type.equals(i.getLable(i.getId()))) {
                n++;
            }
        }
        //分类的准确率
        System.out.println("分类的正确率：" + (double) n / 15);
    }
}
