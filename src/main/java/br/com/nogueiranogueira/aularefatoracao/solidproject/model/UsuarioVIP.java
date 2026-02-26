package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VIP")
public class UsuarioVIP extends Usuario {

    @Column(name = "tem_cartao_fidelidade")
    private boolean temCartaoFidelidade;

    public UsuarioVIP() {
        super();
    }

    public UsuarioVIP(String nome, String email, boolean temCartaoFidelidade) {
        super(nome, email);
        this.temCartaoFidelidade = temCartaoFidelidade;
    }

    public boolean isTemCartaoFidelidade() {
        return temCartaoFidelidade;
    }

    public void setTemCartaoFidelidade(boolean temCartaoFidelidade) {
        this.temCartaoFidelidade = temCartaoFidelidade;
    }

    @Override
    public int getDesconto() {
        if (!temCartaoFidelidade) {
            throw new IllegalStateException(
                    "Usuário VIP deve ter cartão fidelidade para receber desconto"
            );
        }
        return 10;
    }
}