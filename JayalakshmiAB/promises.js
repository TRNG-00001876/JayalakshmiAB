// function fetchData() {
//     return new Promise((resolve, reject) => {
//       setTimeout(() => {
//         const data = { message: "Book the Ticket sucessfully" };
//         resolve(data);
//          reject(new Error("Not Book the Ticket take the Bus"));
//       }, 2000);
//     });
//   }
   
//   fetchData()
//     .then(result => console.log(result.message))
//     .catch(error => console.error(error.message))

// const personA =new Promise((resolve,reject)=>{
//     setTimeout=>()) => {
//         console.log("person A reached home");
//         resolve("person A reached home");
//     },3000)
// });
// const personB=personA.then(() =>{
//     return new Promise(resolve,reject) =>{
//         setTimeout=>(()=>{
//             console.log("person B reached home");
//             resolve("person B reached home");
//         },3000);
//     });
// });

// const personC = personB.then(() => {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             console.log("Person C reached home.");
//             resolve("Person C reached home.");
//         }, 1000);
//     });
// });


// Promise.all([personA, personB, personC])
//     .then((results) => {
//         console.log("All friends reached home:", results);
//     })
//     .catch((error) => {
//         console.error("Error occurred:", error);
//     });



// const userData=[{id:1,name:"hari",email:"hari@gmail.com"},{id:2,name:"jan",email:"jan@gmail.com"}]
// function fetchUserData1() {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const userData = {
//                 id:1,
//                 name: 'hari',
//                 email: 'john@example.com'
                
//             };
//             resolve(userData);
//         }, 2000);
//     });
// }
// function displayUserData(userData) {
//     console.log("User Data:");
//     userData.forEach(user => {
//         console.log(`ID: ${user.id}, Name: ${user.name}, Email: ${user.email}`);
//     });
// }

// async function fetchUserDataAsync() {
//     try {
//         const fetchedData = await new Promise(resolve => {
//             setTimeout(() => {
//                 resolve(userData);
//             }, 2000);
//         });
//         displayUserData(fetchedData);
//     } catch (error) {
//         console.error("Error fetching user data:", error);
//     }
// }
// fetchUserDataAsync();


function fetchUserData() {
    
    const url = 'https://jsonplaceholder.typicode.com/users';

    return fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            return data;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
            throw error;
        });
}

fetchUserData()
    .then(userData => {
        console.log('Fetched user data:', userData);
    })
    .catch(error => {
        console.error('Error:', error);
    });
