#include<bits/stdc++.h>
using namespace std;
    struct rate{
       float cost;
       float gramlim;
    };
    float price(struct rate r[],int n,float weight){
        float total=0;
        if(weight<0){
            total=0;
        }
        else if(weight<=r[0].gramlim){
            total=r[0].cost*weight;
        }
        else if(weight<=r[1].gramlim){
            total=r[0].cost*50+(weight-50)*r[1].cost;
        }
        else if(weight<=r[2].gramlim){
            total=r[0].cost*50+r[1].cost*100+(weight-150)*r[2].cost;
        }
        else{
            total=r[0].cost*50+r[1].cost*100+r[2].cost*250;
            total += r[3].cost * ((weight - 400) / 1000);
        }
        return total;
    }
int main(){
    struct rate r[4]={
        {0.5/10,50},
        {0.4/10,150},
        {0.25/10,400},
        {25/1,FLT_MAX},
    };
    float weight;
    cout<<"enter the weight of the letter"<<endl;
    cin>>weight;
    cout<<price(r,4,weight)<<endl;
return 0;
}