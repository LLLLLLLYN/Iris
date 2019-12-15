public class Iris {
    public String id;
    public String SepalLength;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSepalLength() {
        return SepalLength;
    }

    public void setSepalLength(String sepalLength) {
        SepalLength = sepalLength;
    }

    public String getSepalWidth() {
        return SepalWidth;
    }

    public void setSepalWidth(String sepalWidth) {
        SepalWidth = sepalWidth;
    }

    public String getPetalLength() {
        return PetalLength;
    }

    public void setPetalLength(String petalLength) {
        PetalLength = petalLength;
    }

    public String getPetalWidth() {
        return PetalWidth;
    }

    public void setPetalWidth(String petalWidth) {
        PetalWidth = petalWidth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String SepalWidth;
    public String PetalLength;
    public String PetalWidth;
    public String type;

    public String getLable(String id) {
        if (Integer.parseInt(id) > 0 & Integer.parseInt(id) <= 5) {
            return "Iris setosa";
        } else if (Integer.parseInt(id) > 5 & Integer.parseInt(id) <= 10) {
            return "Iris versicolor";
        } else {
            return "Iris virginica";
        }
    }



}
