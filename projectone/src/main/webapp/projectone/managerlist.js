
`use strict`;
    
let tableM = document.getElementById("user-w")
    const trig4 = document.querySelector("#work5");

      const getRWork = () => {
          return fetch(`http://localhost:8080/projectone/managerlist`);
      };
    getRWork()
    .then(res => res.json())
    .then(json => {
      let WData = json;
      console.log("mlist con");
     var tableM = document.getElementById("user-w");
     
     for (let i = 0; i < json.length; i++) {
       // For looping Through the Array
       let convertedData = json[i];
       let row = document.createElement("tr");
       let idw1 = document.createElement("td");
       let idw2 = document.createElement("td");
       let idw3 = document.createElement("td");
       let idw4 = document.createElement("td");
       let idw5 = document.createElement("td");
      


       tableM.appendChild(row);
       row.appendChild(idw1);
       row.appendChild(idw2);
       row.appendChild(idw3);
       row.appendChild(idw4);
       row.appendChild(idw5);
       

       idw1.innerText = convertedData.id;
       idw2.innerText = convertedData.req_amount;
       idw3.innerText = convertedData.refund_Type;
       idw4.innerText = convertedData.req_date;
       idw5.innerText = convertedData.status;
     }
     
      // document.getElementById("user-d").innerHTML =
    // JSON.stringify(json[0].id);
      // getElem by id logic
      console.log("madeit-dom::::: " + WData);
      
    })
    .catch(err => console.error(err));