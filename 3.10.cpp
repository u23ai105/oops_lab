#include<bits/stdc++.h>
using namespace std;
class Vector{
    private:
    int size;
    int *elements;
    public:
    Vector(int size){
        this->size=size;
        elements = new int[size];
    }
    Vector(const Vector& v){
        elements=new int[v.size];
        for(int i=0;i<v.size;i++){
            elements[i]=v.elements[i];
        }
    }
    ~Vector(){
        delete []elements;
    }
    friend istream& operator>>(istream& in,Vector& v){
        for(int i=0;i<v.size;i++){
            in>>v.elements[i];
        }
        return in;
    }
    friend ostream& operator<<(ostream& out,Vector &v){
        for(int i=0;i<v.size;i++){
            out<<v.elements[i];
        }
        return out;
    }
    Vector operator+(Vector& v1,Vector& v2){
        Vector result(v1.size);
        for(int i=0;i<v.size;i++){
            result[i]=v1[i]+v2[i];
        }
        return result;
    }
    Vector operator-(Vector& v1,Vector& v2){
        Vector result(v1.size);
        for(int i=0;i<v1.size;i++){
            result[i]=v1[i]-v2[i];
        }
        return result;
    }
};
int main(){
    int size;
    cout<<"Enter the size of the vector"<<endl;
    cin>>size;
    Vector v1(size),v2(size);
return 0;
}




























// #include<bits/stdc++.h>
// using namespace std;
// class Vector{
//     private:
//     int *elements;
//     int size;
//     public:
//     Vector(int size): size(size){
//        elements=new int [size];
//     }
//     Vector(const Vector &v) {
//         size = v.size;
//         elements = new int[size];
//         for (int i = 0; i < size; i++) {
//             elements[i] = v.elements[i];
//         }
//     }
//     ~Vector(){
//        delete []elements;
//     }
//     friend istream& operator>>(istream &input, Vector &v) {
//         for (int i = 0; i < v.size; i++) {
//             input >> v.elements[i];
//         }
//         return input;
//     }
//     friend ostream& operator<<(ostream &output, const Vector &v) {
//         output << "[";
//         for (int i = 0; i < v.size; i++) {
//             output << v.elements[i];
//             if (i != v.size - 1) {
//                 output << ", ";
//             }
//         }
//         output << "]";
//         return output;
//     }
//     Vector operator+(const Vector &v) const {
//         Vector result(size);
//         for (int i = 0; i < size; i++) {
//             result.elements[i] = this->elements[i] + v.elements[i];
//         }
//         return result;
//     }
//     Vector operator-(const Vector &v) const {
//         Vector result(size);
//         for (int i = 0; i < size; i++) {
//             result.elements[i] = this->elements[i] - v.elements[i];
//         }
//         return result;
//     }
// };
// int main(){
//     int n;
//     cout<<"enter the size of vector"<<endl;
//     cin>>n;
//     Vector v1(n),v2(n);
//     cout<<"enter the elements of v1"<<endl;
//     cin>>v1;
//     cout<<"enter the elements of v2"<<endl;
//     cin>>v2;
//     Vector sum = v1 + v2;
//     Vector diff = v1 - v2;
//     cout << "Sum of vectors: " << sum << endl;
//     cout << "Difference of vectors: " << diff << endl;
// return 0;
// }