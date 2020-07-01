
let vegetables = ["asparagus", "tomato", "broccoli"];
let fruits = "apple, pineapple, orange";
fruits = fruits.split(",");
console.log(fruits);

let animals = new Array("dog", "cat", "hippo", "owl");

//Joining
console.log(animals.join("**"));

//Slicing
console.log(animals.slice(1, 3));

//Push new elements
animals.push("frog");
console.log(animals);

//To String
console.log(animals.toString());

//Pop last elements
animals.pop()
console.log(animals);

//Add new element, beside push
animals[animals.length] = "bat";
console.log(animals.toString());

//Remove first element
animals.shift();
console.log(animals);

//Add new element to the first index of array
animals.unshift("pokemon");
console.log(animals);

//Concatenate two arrays
console.log(animals.concat(vegetables));

console.log(animals.reverse());

let arr = [5, 10, 17, 4, -2, 18, 6, 9];
console.log(arr.sort());

let usa = {
    capital : "Washington",
    pop : 330000000,
    avg_age : 30,
    countryInfo : function(){
        return this.capital + "\n" + this.avg_age;
    }
}

usa.avg_age++;
console.log(usa.avg_age);
console.log(usa.countryInfo());

setTimeout(function () {
    alert("Hello");
}, 5000);

