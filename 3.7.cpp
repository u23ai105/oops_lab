#include<bits/stdc++.h>
using namespace std;
class cuboid{
    private:
    double l,b,h;
    public:
    cuboid(double l,double b,double h){
        this->l=l;
        this->b=b;
        this->h=h;
    }
    void area(){
        cout<<"area of cuboid is "<<2*(l*b + b*h + l*h)<<endl;
    }
    friend class cube;
};
class cube{
    private:
    double s;
    public:
    cube(){
        s=0;
        cout<<"this is cube constructor"<<endl;
    }
    void convert(cuboid& c1){
        s=(double)cbrt(c1.l*c1.b*c1.h);
        cout<<"the side length of cube is : "<<s<<endl;
    }
};
int main(){
    cube cu1;
    cuboid c1(10,10,1);
    cu1.convert(c1);
    return 0;
}