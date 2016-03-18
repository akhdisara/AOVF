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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 3099709
 */
@Entity
public class QuestionProposition implements Serializable {
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
        if (!(object instanceof QuestionProposition)) {
            return false;
        }
        QuestionProposition other = (QuestionProposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.QuestionProposition[ id=" + id + " ]";
    }
    private String proposition;
    @ManyToOne
    private Question laQuestion;

    
    @OneToMany(mappedBy = "laProposition")
    List <QuestionReponse> lesReponses;

    public List<QuestionReponse> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(List<QuestionReponse> lesReponses) {
        this.lesReponses = lesReponses;
    }

    
    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public Question getLaQuestion() {
        return laQuestion;
    }

    public void setLaQuestion(Question laQuestion) {
        this.laQuestion = laQuestion;
    }
    
}
