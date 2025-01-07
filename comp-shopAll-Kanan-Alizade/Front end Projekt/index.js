let currentSeller=localStorage.getItem("ps-shopping-currentseller")
let loginButton=document.getElementById("login-button")
let loginoutButton=document.getElementById("logout-button")
let psButton=document.getElementById("ps-button")
let orderButton=document.getElementById("orders-button")
if(currentSeller !="null"){
    document.getElementById("seller-label").innerText += currentSeller;
}else{
    document.getElementById("seller-label").innerText +="Istifadəçi daxil olmayib"
}
function changeToLoginPage(){
window.location.href="login.html"
}
function changeToPsPage(){
    window.location.href="ps.html"
}
function changeToPsShoppingPage(){
    window.location.href="ps-shopping.html"
}
function changeToOrdersPage(){
    window.location.href="orders.html"
}
function checkLogin(){
    if(currentSeller==null){
        localStorage.setItem("ps-shopping-currentseller","null")
        window.location.reload()
    }
    if(currentSeller !="null"){
    loginButton.style.display="none"
    }else{
        loginoutButton.style.display="none"
     psButton.style.display="none"
     orderButton.style.display="none"
    }
}
function logoutSeller(){
    if(currentSeller !=null ||currentSeller!="null"){
    let result=confirm("Hesabdan cixmağa əminsiniz?")
    if(result=true){
localStorage.setItem("ps-shopping-currentseller",'null')
window.location.reload()
    }
    }
}
function resetData(){
   let allow= confirm("Sifirlamaga hazirsiz?")
   if(allow=true){
    localStorage.clear()
    window.location.reload()
   }
 
}
checkLogin()