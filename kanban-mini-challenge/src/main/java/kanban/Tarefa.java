package kanban;

public class Tarefa {
    private Integer id;
    private String nome;
    private String prioridade;
    private String responsavel;

    public Tarefa (
            Integer id,
            String nome,
            String prioridade,
            String responsavel
            ) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
    }

    public Integer nextId() {
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
