package com.example.android.inclassassignment09_mingk;


public class Book {
    public String name;
    public String author;
    public String  genre;
    public boolean finish;

    public Book(){}

    public Book (String name, String author, String genre, boolean finish){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.finish = finish;

    }

    public String toString(){
        return "Book {" + "name='"+ name + '\'' + ", author = '"+ author + '\'' + ", genre = '" + genre +'\'' + ", finish = "+finish +'}';
    }



    public String getName(){return name;}

    public void setName(String name){
        this.name = name;

    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }





    public boolean isFinish(){
        return finish;
    }

    public void setFinish(boolean isFinish){
        this.finish = isFinish;
    }


}
