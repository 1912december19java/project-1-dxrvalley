`use strict`;
let keysButton = document.getElementById("sub-button");
const trig = document.querySelector("#work1");
const getData = () => {
  return fetch(`http://localhost:8080/projectone/ehome`);
};
/*
 * String zname = document.querySelector("#l-Name"); String email =
 * document.querySelector('#email'); String stat =
 * document.querySelector("#status");
 */
getData()
  .then(res => res.json())
  .then(json => {
    let uData = json;
    
      document.getElementById("f-Name").innerHTML = uData.firstName;
      document.getElementById("l-Name").innerHTML = uData.lastName;
      document.getElementById("email").innerHTML = uData.email;
      document.getElementById("status").innerHTML = uData.position;
     
    // getElem by id logic
    console.log(json);
  })
  .catch(err => console.error(err));

