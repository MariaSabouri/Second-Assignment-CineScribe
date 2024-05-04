# CineScribe

A platform for searching films/series & actors/actress.

# Description

First, the screen will display a question and ask you to choose a name of the film/series.Be aware to enter a valid name.
Then a list of famous actors will be displayed.You could choose between these actors or other actors to get a summary of their information.
To get the information you have to apply the methods described in below:

## Getting Started

### Dependencies

* adding "org.json" package
* Working with "Windows 11"

### Installing

* IPA key from:

  https://omdbapi.com/

  https://api-ninjas.com/api/celebrity
* I've changed a little bit test files

  
Movie test:
```
    static void setUp() throws IOException {
        movie = new Movie();
        movie2=new Movie();
        data1 = movie.getMovieData("maze runner");  // movie
        data2 = movie2.getMovieData("this is us");   // series
    }
```
Actor  test:
```
    static void setUp() {
        actors = new Actors();
        actors2 = new Actors();
        data1 = actors.getActorData("jennifer lawrence");
        data2 =  actors2.getActorData("robin williams");
    }
```
### Executing program


### Films/Series
* movieinfo.getMovieData(moviename)->"data":

  A general json form description
```
movieinfo.getMovieData(moviename)
```
* movieinfo.getImdbVotesViaApi(data): Give a string form for Imdb
```
movieinfo.getImdbVotesViaApi(data)
```
* movieinfo.get.RatingViaApi(data): Give a string form for Rating
```
movieinfo.get.RatingViaApi(data)
```
* movieinfo.getActorListViaApi(data): Give a string form of famous actors name
```
movieinfo.getActorListViaApi(data)
```
### Actors
* actorsinfo.getActorData(actorname)->"data":
  A general json form description
```
actorsinfo.getActorData(actorname)
```
* actorsinfo.getNetWorthViaApi(actorname): Give a double form of NetWorth
```
actorsinfo.getNetWorthViaApi(actorname)
```
* actorsinfo.isAlive(actorname): return true if the actor mentioned is alive
```
actorsinfo.isAlive(actorname)
```
* actorsinfo.getDateOfDeathViaApi(actorname): Give a string form of Date Of Death
```
actorsinfo.getDateOfDeathViaApi(actorname)
```

## Help

This code is based on entering the correct name of films/series and actor/actress.
So if you enter a wrong name,you might receive a systematic error.
To fix it, please run the code again and reconsider to your input.

## Authors


Maria Sbouri Dodaran

Mohammad Ghaderi

## Acknowledgments

Inspiration, code snippets, etc.
* [HW](https://github.com/orgs/Advanced-Programming-1402/repositories)
