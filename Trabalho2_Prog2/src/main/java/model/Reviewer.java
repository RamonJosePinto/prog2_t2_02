/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ReviewDAO;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Reviewer extends Pessoa {

    public Reviewer(String username, String email, String senha, String nome) {
        super(username, email, senha, nome, TipoPessoa.REVIEWER);
    }

    public Reviewer(int id, String username, String email, String senha, String nome, String caminhoImagemPerfil) {
        super(id, username, email, senha, nome, TipoPessoa.REVIEWER, caminhoImagemPerfil);
    }

    public Reviewer(String username, String email, String senha, String nome, String caminhoImagemPerfil) {
        super(username, email, senha, nome, TipoPessoa.REVIEWER, caminhoImagemPerfil);
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public List<Review> getReviews() {
        ReviewDAO daoReview = new ReviewDAO();
        return daoReview.getReviewsReviewer(idPessoa);
    }

    @Override
    public int contarReviews() {
        ReviewDAO daoReview = new ReviewDAO();
        List<Review> reviewsReviewer = daoReview.getReviewsReviewer(idPessoa);

        return reviewsReviewer.size();
    }

    
    
    @Override
    public String toString() {
        return "Reviewer{" + super.toString() + '}';
    }
}
