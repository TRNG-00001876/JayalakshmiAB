OOOPS

// var person={
//     name:"janani",
//     age:22,
//     gender:"F",
//     city:"chennai"
//            getName(){
//             function.name;

//            } 
//     return this.name;
// }

// }


class Person{
    constructor(name,age,city){
        this.name;
        this.age;
        this.city;
    }
    getName(){
        return this.city;
    }
}
var p1=new Person("janani",22,"chennai");
console.log(p1.name);
console.log(p1.getName());
p1.city="banglore"
console.log(p1.city);


class Animal{
    constructor(name){
        this.name=name;
    }
    speak(){
        console.log(this.name+'makes sound');
    }
}
class Dog extends Animal{
    constructor(name,breed){
        super(name);
        this.breed=breed;
    }
    bark(){
        console.log(this.name+'barkss!!!!');
    }
}
const animal=new Animal('generic');
const dog=new Dog('buddy','labrador');
 animal.speak();
 dog.bark();
 dog.speak();
