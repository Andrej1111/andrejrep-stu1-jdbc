package lt.bit.aje.jdbc.entity;

public class Pazymiai {

    private String id;

    private String studentas_id;

    private String data;

    private String pazymys;

    public Pazymiai() {
    }

    public Pazymiai(String id, String studentas_id, String pazymys) {
        this.id = id;
        this.studentas_id = studentas_id;
        this.pazymys = pazymys;
    }

    public Pazymiai(String id, String studentas_id, String data, String pazymys) {
        this.id = id;
        this.studentas_id = studentas_id;
        this.data = data;
        this.pazymys = pazymys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentas_id() {
        return studentas_id;
    }

    public void setStudentas_id(String studentas_id) {
        this.studentas_id = studentas_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPazymys() {
        return pazymys;
    }

    public void setPazymys(String pazymys) {
        this.pazymys = pazymys;
    }

    @Override
    public String toString() {
        return "Pazymiai{" +
                "id=" + id +
                ", studentas_id=" + studentas_id +
                ", data=" + data +
                ", pazymys=" + pazymys +
                '}';
    }
}
