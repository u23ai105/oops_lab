#include<bits/stdc++.h>
using namespace std;
int main(){
    class due{
      public:
        string date;
        due(string date){
            this->date=date;
        }
        void next(){
            int date=stoi(this->date.substr(0,2));
            int month=stoi(this->date.substr(3,2));
            int year=stoi(this->date.substr(6,4));
            if(month==2){
                if(ISLP(year)){
                    if(date>=15){
                        cout<<"01-03-"<<year<<endl;
                    }
                    else{
                        cout<<date+15<<"-02-"<<year<<endl;
                    }
                }
                else{
                    if(date>=14){
                        cout<<15-date<<"-03-"<<year<<endl;
                    }
                    else{
                       cout<<date+15<<"-02-"<<year<<endl;
                }
            }
            else if(date==30 && month%2==0){
                cout<<"01-"<<month+1<<"-"<<year<<endl;
            }
            else
            if(date==31 && month%2==1){
                if(month==12){

                }
            }
        }
        
    }
return 0;
}