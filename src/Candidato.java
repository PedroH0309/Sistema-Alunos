public non-sealed class Candidato extends Pessoa{
    private double notaProva;

    public double getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(double notaProva) {
        this.notaProva = notaProva;
    }

    public void informarNota(int nota) throws ValidarProva{
        if (nota < 0 || nota > 100){
            throw new ValidarProva("Nota inválida: a nota deve ser entre 0 e 100!");
        }

        this.notaProva = nota;
    }
}
