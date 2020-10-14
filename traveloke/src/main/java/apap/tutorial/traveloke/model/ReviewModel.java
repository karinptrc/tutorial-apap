package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "review")
public class ReviewModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max=10)
    @Column(name = "namaReviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max = 50)
    @Column(name = "isiReview", nullable = false)
    private String isiReview;

    @Size(max = 50)
    @Column(name = "saran", nullable = true)
    private Integer saran;

    @OneToMany(mappedBy = "kamar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReviewModel> listReview;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "reviewId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaReviewer() {
        return namaReviewer;
    }

    public void setNamaReviewer(String namaReviewer) {
        this.namaReviewer = namaReviewer;
    }

    public String getIsiReview() {
        return isiReview;
    }

    public void setIsiReview(String isiReview) {
        this.isiReview = isiReview;
    }

    public Integer getSaran() {
        return saran;
    }

    public void setSaran(Integer saran) {
        this.saran = saran;
    }

    public List<ReviewModel> getListReview() {
        return listReview;
    }

    public void setListReview(List<ReviewModel> listReview) {
        this.listReview = listReview;
    }
}
