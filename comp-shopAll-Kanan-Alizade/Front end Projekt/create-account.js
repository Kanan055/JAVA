let sellersStorageString=localStorage.getItem("ps-shopping-sellers")
let sellers=[]
if(sellersStorageString != null){
sellers=JSON.parse(sellersStorageString)
}
function addSeller(event){
    let allow=true
    event.preventDefault()
    let username=document.getElementById("username").value
    let password=document.getElementById("password").value
    for(let i=0;i<sellers.length;i++){
const seller=sellers[i]
if(seller.username===username){
allow=false
}
    }
    if(allow===true){
let seller={}
seller.id=sellers.length+1
seller.username=username
seller.password=password
sellers.push(seller)
localStorage.setItem("ps-shopping-sellers",JSON.stringify(sellers))
setTimeout(()=>{
    document.getElementById("alert-seller-add-success").style.display="block"
    setTimeout(()=>{
        window.location.href="index.html"
    },1500)
},400)
    }else{
        setTimeout(()=>{
            document.getElementById("alert-seller-add-fail").style.display="none"
        },400)
    }
}