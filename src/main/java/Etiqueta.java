import java.util.Set;

public class Etiqueta {

    private Long id;
    private String name;
//    Relación
    private Set<Candidato> candidates;

    public Etiqueta() {}

    public Etiqueta(String name) {
        this.name = name;
    }

    public Etiqueta(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Candidato> getStudent() {
        return candidates;
    }

    public void setStudent(Set<Candidato> student) {
        this.candidates = student;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
