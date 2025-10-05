package model;

import java.time.LocalDate;

public class CupomDesconto {
    private String codigo;
    private double valorDesconto;
    private boolean percentual;
    private LocalDate validade;
    private boolean utilizado;

    public CupomDesconto(String codigo, double valorDesconto, boolean percentual, LocalDate validade) {
        this.codigo = codigo;
        this.valorDesconto = valorDesconto;
        this.percentual = percentual;
        this.validade = validade;
        this.utilizado = false;
    }

    public boolean isValido() {
        return !utilizado && LocalDate.now().isBefore(validade);
    }

    public double aplicarDesconto(double valorTotal) {
        if (!isValido()) return valorTotal;
        utilizado = true;
        return percentual ? valorTotal * (1 - valorDesconto / 100) : valorTotal - valorDesconto;
    }

    public String getCodigo() { return codigo; }
    public boolean isUtilizado() { return utilizado; }
    public void setUtilizado(boolean utilizado) { this.utilizado = utilizado; }
    public void setValorDesconto(double valorDesconto) { this.valorDesconto = valorDesconto; }
    public void setValidade(LocalDate validade) { this.validade = validade; }
}
