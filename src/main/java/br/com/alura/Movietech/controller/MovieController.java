package br.com.alura.Movietech.controller;

import br.com.alura.Movietech.domain.filme.*;
import br.com.alura.Movietech.service.DataConvert;
import br.com.alura.Movietech.service.GetDataMovie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private GetDataMovie apiMovie;

    @Autowired
    private MovieRepository repository;

    @Autowired
    private DataConvert convert;

    @GetMapping("/form")
    public String loadMovie(Long id, Model model){
        if(id!=null){
            var movie = repository.getReferenceById(id);
            model.addAttribute("movie", movie);
        }
        return "movie/form";
    }

    @GetMapping("/search")
    public String getMovieApi(){
        return "movie/search";
    }

    @PostMapping("/search")
    public String loadMovieApi(SearchText search, Model model){
        if(search.search() !=null) {
            System.out.println("entrou");
            DataApiRecord api = convert.getData(apiMovie.getData(search.search().replaceAll(" ", "+")), DataApiRecord.class);
            System.out.println(api);
            model.addAttribute("movie", api);
        }
        return "movie/search";
    }

    @GetMapping
    public String loadMovieForTable(Model model){

        model.addAttribute("list", repository.findAll());
        return "movie/listofmovie";
    }

    @PostMapping
    @Transactional
    public String registerMovie(RegisterDataMovie data){
        var movie = new Movie(data);
        repository.save(movie);
        return "redirect:/movie";
    }

    @DeleteMapping
    @Transactional
    public String delete(Long id){
        repository.deleteById(id);
        return "redirect:/movie";
    }

    @PutMapping
    @Transactional
    public String updateMovie(UpdateDataMovie data){
       var movie = repository.getReferenceById(data.id());
       movie.UpdateData(data);
       return "redirect:/movie";
    }


}
