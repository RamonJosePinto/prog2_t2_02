/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.PessoaDAO;
import exception.PessoaInexistenteException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author guilh
 */
public abstract class Pessoa {

    protected String username;
    protected String email;
    protected String senha;
    protected String nome;
    protected TipoPessoa tipoPessoa;
    protected int idPessoa;
    protected static int geradorIdPessoa = 0;
    protected static Pessoa usuarioLogado;
    protected Path pathImagemPerfil;

    public Pessoa(String username, String email, String senha, String nome, TipoPessoa tipoPessoa) {
        this.idPessoa = ++geradorIdPessoa;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public Pessoa(int id, String username, String email, String senha, String nome, TipoPessoa tipoPessoa) {
        this.idPessoa = id;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public Pessoa(String username, String email, String senha, String nome, TipoPessoa tipoPessoa, Path pathImagemPerfil) {
        this.idPessoa = ++geradorIdPessoa;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.pathImagemPerfil = pathImagemPerfil;
    }

    // Enum
    public enum TipoPessoa {
        ARTISTA,
        REVIEWER
    }

    public static Pessoa login(String email, String senha) throws PessoaInexistenteException {
        PessoaDAO dao = new PessoaDAO();
        Pessoa p = dao.getPessoaEmail(email);

        if ((p != null) && (p.getSenha().equals(senha))) {
            Pessoa.usuarioLogado = p;
            return usuarioLogado;
        } else {
            throw new PessoaInexistenteException("Usuário não encontrado");
            //return null;
        }
    }

    public abstract int contarReviews();

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public static int getGeradorIdPessoa() {
        return geradorIdPessoa;
    }

    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public Path getPathImagemPerfil() {
        return pathImagemPerfil;
    }

    public void setPathImagemPerfil(Path pathImagemPerfil) {
        this.pathImagemPerfil = pathImagemPerfil;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "username=" + username + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", tipoPessoa=" + tipoPessoa + ", idPessoa=" + idPessoa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.username);
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Pessoa other = (Pessoa) obj;

        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

}
