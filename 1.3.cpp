#include<bits/stdc++.h>
using namespace std;
    struct Publication{
        string title;
        float price;
        string name;
        void getdata(){
            cout<<"enter the title of the book"<<endl;
            cin>>title;
            cout<<"enter the price of the book"<<endl;
            cin>>price;
            cout<<"enter the name of the author"<<endl;
            cin>>name;
        }
        void display(){
            cout<<"Title: "<<title<<endl;
        cout<<"Price: "<<price<<endl;
        cout<<"Author: "<<author<<endl;
        }
    }; 
        struct book: public Publication{
            int count;
            void getdata(){
                Publication::getdata();
                cout<<"enter the number of pages in the book"<<endl;
                cin>>count;
            }
            void display(){
                Publication::display();
                cout<<"number of pages in the book are "<<count<<endl;
            }
        };
        struct ebook: public Publication{
            int time;
            void getdata(){
                Publication::getdata();
                cout<<"enter the time"<<endl;
                cin>>time;
            }
            void display(){
                Publication::display();
                cout<<"time is "<<time<<endl;
            }
        };
    int main(){
        struct book b;
        struct ebook e;
        cout<<"enter the details of book"<<endl;
        b.getdata();
        cout<<"the details of book are"<<endl;
        b.display();
        cout<<"enter the details of ebook"<<endl;
        e.getdata();
        cout<<"the details of ebook are"<<endl;
        e.display();
        return 0;
}