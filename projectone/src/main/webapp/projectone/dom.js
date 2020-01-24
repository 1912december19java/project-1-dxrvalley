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



let CheckButton = document.getElementById("check-stats")
	const trig2 = document.querySelector("#work2");

    const getRefund = () => {
        return fetch(`http://localhost:8080/projectone/getreq`);
    };
    
    
	getRefund()
  .then(res => res.json())
  .then(json => {
    let gData = json;
    
   var table = document.getElementById("user-d");
   
   for (let i = 0; i < json.length; i++) {
     // For looping Through the Array
	   let convertedData = json[i];
     let row = document.createElement("tr");
     let idc1 = document.createElement("td");
     let idc2 = document.createElement("td");
     let idc3 = document.createElement("td");
     let idc4 = document.createElement("td");
     let idc5 = document.createElement("td");
    


     table.appendChild(row);
     row.appendChild(idc1);
     row.appendChild(idc2);
     row.appendChild(idc3);
     row.appendChild(idc4);
     row.appendChild(idc5);
     

     idc1.innerText = convertedData.id;
     idc2.innerText = convertedData.req_amount;
     idc3.innerText = convertedData.refund_Type;
     idc4.innerText = convertedData.req_date;
     idc5.innerText = convertedData.status;
   }
   
    // document.getElementById("user-d").innerHTML = JSON.stringify(json[0].id);
    // getElem by id logic
    console.log("madeit " + gData);
    
  })
  .catch(err => console.error(err));
	
	

	var target = document.getElementById("totalAmount")
		const trig3 = document.querySelector("#work3");
	    const getTotal = () => {
	        return fetch(`http://localhost:8080/projectone/total`);
	    };
		getTotal()
	  .then(res => res.json())
	  .then(json => {
	    let TData = json;
	    
	    document.getElementById("totalAmount").innerHTML = TData.total;
	    console.log("tdata:::" +TData);
	    
	  })
	  .catch(err => console.error(err));
		
		
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
	      console.log("madeit-dom::::: " + WData.firstname);
	      
	    })
	    .catch(err => console.error(err));


  const approveAction = document.getElementById("approve_req");

const deleteAction = document.getElementById("delete_req");




  

