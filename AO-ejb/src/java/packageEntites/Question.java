/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEntites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 3099709
 */
@Entity
public class Question implements Serializable {
    @OneToMany(mappedBy = "laQuestion")
    private List<QuestionProposition> lesPropositions;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Question[ id=" + id + " ]";
    }
    private String question;
    private int numquestion;
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<QuestionProposition> getLesPropositions() {
        return lesPropositions;
    }

    public void setLesPropositions(List<QuestionProposition> lesPropositions) {
        this.lesPropositions = lesPropositions;
    }

    public int getNumquestion() {
        return numquestion;
    }

    public void setNumquestion(int numquestion) {
        this.numquestion = numquestion;
    }
    
}
