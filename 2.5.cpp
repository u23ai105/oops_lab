#include<bits/stdc++.h>
using namespace std;
class Fractions{
    private:
    double f1,f2;
    public:
    Fractions(double f1,double f2){
        this->f1=f1;
        this->f2=f2;
    }
    void add(){
        double sum=f1+f2;
        cout<<"sum of two fractions is : "<<sum<<endl;
    } 
    void sub(){
        double diff=f1-f2;
        cout<<"difference of two fractions is : "<<diff<<endl;
    }
    void multiply(){
        double mul=f1*f2;
        cout<<"product of two fractions is : "<<mul<<endl;
    }
};
double Fraction(string &fraction) {
    int Pos = fraction.find('/');
    if (Pos != string::npos) {
        int numerator = stoi(fraction.substr(0, Pos));
        int denominator = stoi(fraction.substr(Pos + 1));
        return (double)numerator/denominator;
    }
    return stod(fraction);
}
int main() {
    string f1, f2;
    cout << "Enter the two fractions: " << endl;
    cin >> f1 >> f2;
    double f3 = Fraction(f1);
    double f4 = Fraction(f2);
    Fractions frac(f3, f4);
    frac.add();
    frac.sub();
    frac.multiply();
    return 0;
}