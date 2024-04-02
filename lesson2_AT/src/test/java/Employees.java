public class Employees {
    private String name;
    private String job;
    private String companySite;

    public Employees(String name, String job, String companySite) {
        this.name = name;
        this.job = job;
        this.companySite = companySite;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCompanySite() {
        return companySite;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", companySite='" + companySite + '\'' +
                '}';
    }
}