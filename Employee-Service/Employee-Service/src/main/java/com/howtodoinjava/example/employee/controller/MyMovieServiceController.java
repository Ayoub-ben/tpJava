package com.howtodoinjava.example.employee.controller;

import com.howtodoinjava.example.employee.beans.Acteur;
import com.howtodoinjava.example.employee.beans.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class MyMovieServiceController {
    Date dateNaissanceActeur1 = new Date(1999, 10, 1);
    Date dateFilm = new Date(2010, 10, 1);




    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(new Acteur("avengers", "PrenomActeur1", dateNaissanceActeur1, null));
        acteurs.add(new Acteur("chien", "PrenomActeur1", dateNaissanceActeur1, null));
        acteurs.add(new Acteur("neymar", "PrenomActeur1", dateNaissanceActeur1, null));
        acteurs.add(new Acteur("NomActeur1", "PrenomActeur1", dateNaissanceActeur1, null));
    }

    List<Film> films = new ArrayList<Film>();
    {
        films.add(new Film("Titre Film", "Realisateur Film", dateFilm, acteurs));
        films.add(new Film("Titre ", "Realisateur Film", dateFilm, acteurs));
        films.add(new Film(" Film", "Realisateur Film", dateFilm, acteurs));
        films.add(new Film("Bat", "Realisateur Film", dateFilm, acteurs));
    }


    @ApiOperation(value = "Get acteur in the System ", response = Iterable.class, tags = "getAllActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping(value = "/getAllActeurs/{acteurs}")
    public List<Acteur> getAllActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get all acteur ", response = Acteur.class, tags = "getActeurByName")
    @RequestMapping(value = "/getActeurByName/{firstName}")
    public Acteur getActeurByName(@PathVariable(value = "firstName") String firstName) {
        return acteurs.stream().filter(x -> x.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList()).get(0);
    }


    @ApiOperation(value = "Get acteur in the System ", response = Iterable.class, tags = "getAllFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping(value = "/getAllFilms/{film}")
    public List<Film> getAllFilms() {
        return films;
    }

    @ApiOperation(value = "Get acteur by films ", response = Film.class, tags = "getActeursByFilm")
    @RequestMapping(value = "/getActeursByFilm/{titre}")
    public List<Acteur> getActeursByFilm(@PathVariable(value = "titre") String titre) {
        List<Acteur> acteur0 = new ArrayList<Acteur>();
        for (Film film : films) {
            if (film.getTitre().equals(titre)) {
                acteur0 = film.getActeurs();
            }
        }
        return acteur0;
    }

    @ApiOperation(value = "Get acteur by titre ", response = Film.class, tags = "getActeurByTitre")
    @RequestMapping(value = "/getActeurByTitre/{titre}")
    public Film getActeurByTitre(@PathVariable(value = "titre") String titre) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get film by date ", response = Film.class, tags = "getActeurByTitre")
    @RequestMapping("/films/{sortie}")
    public List<Film> getFilmsByReleaseDate(@PathVariable Date sortie) {
        List<Film> film0 = new ArrayList<Film>();
        for (Film film : films) {
            if (film.getSortieDate().equals(sortie)) {
                film0 = films ;
            }
        }
        return film0 ;
    }

}
