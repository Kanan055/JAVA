let sellersStorageString=localStorage.getItem("ps-shopping-sellers")
let sellers={}
if(sellersStorageString !=null){
sellers=JSON.parse(sellersStorageString)
}
function changeToCreateAccountPage(){
    window.location.href="create-account.html"
}
function loginSeller(event){
  
    let allowLogin=false
    event.preventDefault();

    let username=document.getElementById("username").value
    let password=document.getElementById("password").value
    for(let i=0;i < sellers.length;i++){
let seller=sellers[i]
if(seller.username===username && seller.password===password){
allowLogin=true
}
}
    if(allowLogin === true){
document.getElementById("alert-seller-login-success").style.display="block"
localStorage.setItem("ps-shopping-currentseller",username)
setTimeout(()=>{
window.location.href="index.html"
},1200)
    }else{
        document.getElementById("alert-seller-login-fail").style.display="block"
        setTimeout(()=>{
document.getElementById("alert-seller-login-success").style.display="none"
        },100)
    }
}