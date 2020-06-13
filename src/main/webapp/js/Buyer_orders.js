$.ajax({

      type: "get",
      url:  "http://localhost:9000/EC/webapi/orderService/buyerOrderDetails",
      //data: JSON.stringify(myFunction()),
      //datatype : JSON,
      headers: {
       'username':sessionStorage.username?sessionStorage.getItem('username'):'',
       'password':sessionStorage.username?sessionStorage.getItem('password'):''//sessionStorage.getItem('password')

 },
      success: function(OrdersArray){
       console.log("hereX")
        console.log(OrdersArray);
       console.log("hereY")
        
//        var html="<ul><div class ='category'>";
//        for(var i = 0; i < OrdersArray.length; i++) {
//            html += "<li onmouseover='subcatdisplay("+OrdersArray[i].id+")'><span class='category'> "+ OrdersArray[i].category_name + "</span></li>";
//        }
//        html+="</ul>";
//        //console.log("here11");
//        document.getElementById("categories").innerHTML = html;
//        //console.log("here12");
       /*
       var html="<ul><div>";
          for(var i = 0; i < OrdersArray.length; i++) {
           //console.log("prod item_id is "+OrdersArray[i].item_id);
              html += "<li onclick='itemDisplay("+OrdersArray[i].item_id+")'><div class='row'> ";
              //html += "<li><div class='row'>";
              html += "<div class='column' style='background-color:#ffffff;'>";
              html += "<tbody>";
              html += "<tr>";
              html += "<img src='images'></img>"
              html += "<h2> Item Name:"+OrdersArray[i].name+"</h2>";
              html += "</div>";
              html += "</div>";
              html += "</li>";*/
       
       var html="<ul><div>";
          for(var i = 0; i < OrdersArray.length; i++) {
//          for(var i = 0; i <1 ; i++) {
       html += "<li onclick='itemDisplay("+OrdersArray[i].item_id+")'><div class='row'> ";

       //html += "<li><div class='row'>";

       html += "<div class='column' style='background-color:#aaa;'>";

       html+="<tbody>";

       html+="<tr>";

       html+="<td>";

       html += "<h2> Item Name:"+OrdersArray[i].name+"</h2>";
       

       html+="</td>";
       html+="<td>";

       html += "<h2> Item Quantity:"+OrdersArray[i].quantity+"</h2>";

       html+="</td>";
       html+="<td>";

       html += "<h2> Status:"+OrdersArray[i].status+"</h2>";

       html+="</td>";
 html+="<td>";
       
       
      

       html += "<a><img src="+OrdersArray[i].pic_location+" height='75' width='75' /></a>";
       if(OrdersArray[i].status=='Delivered'){
           html+= "<h2>Liked the product? Share your review</h2>";
           
           html += "<fieldset class='rating'>";
           //<fieldset class="rating">
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",5"+")' id='star5' name='rating' value='5'/><label class = 'full' for='star5' title='Awesome - 5 stars'></label>";
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",5"+")' id='star4half' name='rating' value='4 and a half'/><label class = 'half' for='star4half' title='Pretty good - 4.5 stars'></label>";

           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",4"+")' id='star4' name='rating' value='4'/><label class = 'full' for='star4' title='Pretty good - 4 stars'></label>";
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",4"+")' id='star3half' name='rating' value='3 and a half'/><label class = 'half' for='star3half' title='Meh - 3.5 stars'></label>";

           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",3"+")' id='star3' name='rating' value='3'/><label class = 'full' for='star3' title='Meh - 3 stars'></label>";
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",3"+")' id='star2half' name='rating' value='2 and a half'/><label class = 'half' for='star2half' title='Kinda bad - 2.5 stars'></label>";

              html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",2"+")' id='star2' name='rating' value='2'/><label class = 'full' for='star2' title='Kinda bad - 2 stars'></label>";
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",2"+")' id='star1half' name='rating' value='1 and a half'/><label class = 'half' for='star1half' title='Meh - 1.5 stars'></label>";
           
              html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",1"+")' id='star1' name='rating' value='1'/><label class = 'full' for='star1' title='very bad - 1 stars'></label>";
           html += "<input type='radio' onclick='ratingUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+",1"+")' id='starhalf' name='rating' value='half'/><label class = 'half' for='starhalf' title='very bad - 0.5 stars'></label>";

           
           
           html += "</fieldset>"
           
          }
       html+="</td>";
//       html+="<td>";
//       
//       
//       
//
//       html += "<a><img src="+OrdersArray[i].order_id+" height='75' width='75' /></a>";
//
//       html+="</td>";

       


       

       

//       html += "<h3> Item Name:"+OrdersArray[i].pic_location+"</h3>";

//       html += "<a><img src="+OrdersArray[i].pic_location+" /></a>";

       

      

      
      

       html+="</tr>";

       html+="</tbody>";
       html += "</div>";
       html += "</div>";
       html+="</li>";
       if(OrdersArray[i].status=="Shipped Items")
    	   {
    	   
       html+="</td>";
       html += "<li onclick='orderUpdate("+OrdersArray[i].id+","+OrdersArray[i].item_id+")'>Delivered<\li>";
       html+="<td>";
    	   }
       
                          
          }
          html+="<\div>";
          html+="</ul>";
          
          console.log("html is "+html);
          document.getElementById("allitemsubcat").innerHTML = html;
          
      }
    });


//function myFunction(){
//var a = location.href;
//console.log("a is"+a);
//var b = a.substring(a.indexOf("=")+1);
//console.log("b is"+b);
//var c=JSON.parse('{"id":'+b+'}');
//console.log("c is "+typeof(c));
//return b;
//}

function itemDisplay(itemId){
//window.location.href = "http://localhost:9000/EC/displaySelectedItem.html?itemId="+itemId;
}
function orderUpdate(orderId,itemId){
	console.log(orderId);
	$.ajax({

	      type: "get",
	      url:  "http://localhost:9000/EC/webapi/orderService/updateBuyerStatusOrderItem/"+orderId+"/"+itemId,
	      //data: JSON.stringify(myFunction()),
	      //datatype : JSON,
	      headers: {
	       'username':sessionStorage.username?sessionStorage.getItem('username'):'',
	       'password':sessionStorage.username?sessionStorage.getItem('password'):''//sessionStorage.getItem('password')

	 },
	      success: function(res){
	       console.log("hereX")
	        console.log(res);
	       console.log("hereY")
	       location.reload();

	        

//	          console.log("html is "+html);
//	          document.getElementById("allitemsubcat").innerHTML = html;
	          
	      }
	    });
	
	}

function ratingUpdate(orderId,itemId,stars){


	console.log("helloooooooooooooooo");
	//alert("coming");
	console.log(orderId);
	console.log(itemId);
	var link= "http://localhost:9000/EC/webapi/orderService/Rate/"+orderId+"/"+itemId+"/"+stars;

	console.log("link "+link);
	console.log("stars given "+stars);
	$.ajax({

	      type: "post",
	      //url:  "http://localhost:9000/EC/webapi/orderService/Rate/"+orderId+"/"+itemId+"/"+stars,
	      url: link,
	      //data: JSON.stringify(stars),
	      //datatype : JSON,
	      headers: {
	       'username':sessionStorage.username?sessionStorage.getItem('username'):'',
	       'password':sessionStorage.username?sessionStorage.getItem('password'):''//sessionStorage.getItem('password')

	 },
	      success: function(res){
	       console.log("hereX")
	        console.log(res);
	       console.log("hereY")
	       location.reload();

	        

//	           console.log("html is "+html);
//	           document.getElementById("allitemsubcat").innerHTML = html;
	          
	      }
	    });

	}

