package br.com.alura.Movietech.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer duration;
    private Integer years;
    private String gender;

    public Movie(RegisterDataMovie data){
        this.name = data.name();
        this.duration = data.duration();
        this.years = data.years();
        this.gender = data.gender();
    }

    public Movie(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void UpdateData(UpdateDataMovie data) {
        this.name = data.name();
        this.duration = data.duration();
        this.years = data.years();
        this.gender = data.gender();

    }
}
