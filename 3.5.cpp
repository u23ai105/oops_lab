#include<bits/stdc++.h>
using namespace std;
class Publication{
    private:
    string name;
    double price;
    string author;
    public:
    Publication(string name,double price,string author){
        this->name=name;
        this->price=price;
        this->author=author;
    }
    void display_data(){
        cout<<"Name : "<<name<<endl;
        cout<<"Price : "<<price<<endl;
        cout<<"Author : "<<author<<endl;
    }
};
class Book:public Publication{
    private:
    int page_count=0;
    public:
    Book(string name,double price,string author,int count):Publication(name,price,author){
        this->page_count=count;
    }
    void display_data(){
        Publication::display_data();
        cout<<"The current reading page is "<<page_count<<endl;
    }
};
class EBook:public Publication{
    private:
    int p_time=0;
    public:
    EBook(string name,double price,string author,int count):Publication(name,price,author){
         this->p_time=count;
    }
    void display_data(){
        Publication::display_data();
        cout<<"The current reading time is "<<p_time<<" minutes"<<endl;
    }
};
int main(){
    Book B1("Haunting Adeline",10000,"ZADE",1024);
    B1.display_data();
    EBook EB1("Tony Stark",20000,"Steve Harvey",140);
    EB1.display_data();
return 0;
}