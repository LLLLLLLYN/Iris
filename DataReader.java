import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataReader {


    public List<Iris> getIrisData(String path) throws IOException {
        List<Iris> list = new ArrayList<>();
        File file = new File(path);
        //读取内容
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String str = null;
            while ((str =bf.readLine()) == null ? false : true) {
                Iris iris = new Iris();
                iris.setId(str.split("\t")[0]);
                iris.setSepalLength(str.split("\t")[1]);
                iris.setSepalWidth(str.split("\t")[2]);
                iris.setPetalLength(str.split("\t")[3]);
                iris.setPetalWidth(str.split("\t")[4]);
                list.add(iris);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        String path = "D:/JavaIDEA/Iris/src/train_data.txt";
        DataReader dataReader = new DataReader();
        List<Iris> list = dataReader.getIrisData(path);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).getId());

        }
    }
}
